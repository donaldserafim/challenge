package com.ilegra.challenge.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import com.ilegra.challenge.config.Config;
import com.ilegra.challenge.domain.Customer;
import com.ilegra.challenge.domain.Result;
import com.ilegra.challenge.domain.Sales;
import com.ilegra.challenge.domain.SalesItem;
import com.ilegra.challenge.domain.SalesMan;
import com.ilegra.challenge.util.Convert;
import com.ilegra.challenge.util.FileUtil;

public class FileService implements Callable<Boolean>{

	private Path pathIn;
	private Path pathOut;

	public FileService(Path pathIn, Path pathOut) {
		this.pathIn = pathIn;
		this.pathOut = pathOut;
	}

	public void processFile() throws IOException {
		List<String> lines = null;
		synchronized(this)
		{
			lines = FileUtil.readFile(this.pathIn);
			FileUtil.moveFileAndDeleteSource(pathIn);
		}
		
		List<SalesMan> listSalesMan= new ArrayList<SalesMan>();
		List<Customer> listCustomer = new ArrayList<Customer>();
		List<Sales> listSales = new ArrayList<Sales>();

		for (String line : lines) {
			if(line.startsWith(Config.SALESMAN)) {
				listSalesMan.add(Convert.getSalesMan(line));
			}
			else if(line.startsWith(Config.CUSTOMER)) {
				listCustomer.add(Convert.getCustomer(line));
			}
			else if(line.startsWith(Config.SALES)) {
				listSales.add(Convert.getSales(line));
			}
		}
		processResult(listSalesMan, listCustomer, listSales);
	}

	private void processResult(List<SalesMan> listSalesMan,List<Customer> listCustomer,List<Sales> listSales) throws IOException {
		Result result = new Result();

		result.setAmountClients(listCustomer.size());
		result.setAmountSalesMan(listSalesMan.size());

		Map<String, Double> mapTotalSalesBySalesman = new HashMap<String, Double>();

		double valueMostExpensiveSale = 0.0;
		for (Sales sales : listSales) {

			double totalSale = 0.0;
			for (SalesItem item : sales.getListItem()) {
				totalSale+=item.getPrice()*item.getQuantity();	
			}

			if(totalSale>valueMostExpensiveSale) {
				result.setIdMostExpensiveSale(sales.getIdSale());
				valueMostExpensiveSale+=totalSale;
			}

			if(mapTotalSalesBySalesman.get(sales.getSalesName())!=null){
				mapTotalSalesBySalesman.put(sales.getSalesName(), mapTotalSalesBySalesman.get(sales.getSalesName())+totalSale);				
			}else{
				mapTotalSalesBySalesman.put(sales.getSalesName(), totalSale);
			}
		}
		result.setWorstSalesman(mapTotalSalesBySalesman.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey());
		FileUtil.writeFile(result.toString(), this.pathOut+"/"+this.pathIn.getFileName()+Config.FILE_NAME_OUT);
	}

	
	public Boolean call() throws Exception {
		this.processFile();
		return true;
	}
}