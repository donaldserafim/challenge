package com.ilegra.challenge.domain;

public class Customer {

	private Long id;
	private Long cnpj;
	private String name;
	private String bussinessArea;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBussinessArea() {
		return bussinessArea;
	}
	public void setBussinessArea(String bussinessArea) {
		this.bussinessArea = bussinessArea;
	}
}
