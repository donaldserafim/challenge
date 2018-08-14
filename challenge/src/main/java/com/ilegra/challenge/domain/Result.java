package com.ilegra.challenge.domain;

public class Result {
	
	private Integer amountClients;
	private Integer amountSalesMan;
	private Long idMostExpensiveSale;
	private String worstSalesman;
	
	
	public Integer getAmountClients() {
		return amountClients;
	}
	public void setAmountClients(Integer amountClients) {
		this.amountClients = amountClients;
	}
	public Integer getAmountSalesMan() {
		return amountSalesMan;
	}
	public void setAmountSalesMan(Integer amountSalesMan) {
		this.amountSalesMan = amountSalesMan;
	}
	public Long getIdMostExpensiveSale() {
		return idMostExpensiveSale;
	}
	public void setIdMostExpensiveSale(Long idMostExpensiveSale) {
		this.idMostExpensiveSale = idMostExpensiveSale;
	}
	public String getWorstSalesman() {
		return worstSalesman;
	}
	public void setWorstSalesman(String worstSalesman) {
		this.worstSalesman = worstSalesman;
	}
	@Override
	public String toString() {
		return "amountClients=" + amountClients + "\namountSalesMan=" + amountSalesMan
				+ "\nidMostExpensiveSale=" + idMostExpensiveSale + "\nworstSalesman=" + worstSalesman;
	}
}
