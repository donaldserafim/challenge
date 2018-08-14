package com.ilegra.challenge.util;

import java.util.ArrayList;
import java.util.List;

import com.ilegra.challenge.config.Config;
import com.ilegra.challenge.domain.Customer;
import com.ilegra.challenge.domain.Sales;
import com.ilegra.challenge.domain.SalesItem;
import com.ilegra.challenge.domain.SalesMan;

public class Convert {
	
	public static Sales getSales(String line) {
		Sales sales = new Sales();
		String data[] = line.split(Config.SPLIT);
		sales.setId(Long.valueOf(data[0]));
		sales.setIdSale(Long.valueOf(data[1]));
		sales.setListItem(getItens(data[2]));
		sales.setSalesName(String.valueOf(data[3]));
		return sales;
	}
	
	private static List<SalesItem> getItens(String itens) {
		List<SalesItem> list = new ArrayList<SalesItem>();
		for (String item : itens.replace("[", "").replaceAll("]", "").split(Config.SPLIT_ITENS)) {
			String[] listItem = item.split("-");
			SalesItem salesItem = new SalesItem();
			salesItem.setId(Long.parseLong(listItem[0]));
			salesItem.setQuantity(Integer.valueOf(listItem[1]));
			salesItem.setPrice(Double.parseDouble(listItem[2]));
			list.add(salesItem);
		}
		return list;
	}

	public static SalesMan getSalesMan(String line) {
		SalesMan salesMan = new SalesMan();
		String data[] = line.split(Config.SPLIT);
		salesMan.setId(Long.valueOf(data[0]));
		salesMan.setCpf(Long.valueOf(data[1]));
		salesMan.setName(data[2]);
		salesMan.setSalary(Double.valueOf((data[3])));
		
		return salesMan;
	}
	
	public static Customer getCustomer(String line) {
		Customer customer = new Customer();
		String data[] = line.split(Config.SPLIT);
		customer.setId(Long.valueOf(data[0]));
		customer.setCnpj(Long.valueOf(data[1]));
		customer.setName(data[2]);
		customer.setBussinessArea(String.valueOf((data[3])));
		
		return customer;
	}
}