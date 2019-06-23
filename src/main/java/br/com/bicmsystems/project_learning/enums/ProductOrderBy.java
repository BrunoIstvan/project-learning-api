package br.com.bicmsystems.project_learning.enums;

public enum ProductOrderBy {

	ID("id"), 
	NAME("name"),
	PRICE("price"),
	STOCK("stock");
	
	private String OrderByCode;
	private ProductOrderBy(String orderBy) {
		this.OrderByCode = orderBy;
	}
	
	public String getOrderByCode() {
		return this.OrderByCode;
	}
	
}
