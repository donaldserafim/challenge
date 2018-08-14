package com.ilegra.challenge.domain;

import java.util.List;

public class Sales {
	
	private Long id;
	private Long idSale;
	private List<SalesItem> listItem;
	private String salesName;
	
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdSale() {
		return idSale;
	}
	public void setIdSale(long idSale) {
		this.idSale = idSale;
	}
	public List<SalesItem> getListItem() {
		return listItem;
	}
	public void setListItem(List<SalesItem> listItem) {
		this.listItem = listItem;
	}
	public String getSalesName() {
		return salesName;
	}
	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}
}
