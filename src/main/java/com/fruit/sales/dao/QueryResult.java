package com.fruit.sales.dao;

import java.util.List;

public class QueryResult<T> {

	private List<T> list;
	private int totalRow;
	
	public QueryResult(List<T> list, int totalRow) {
		this.list = list;
		this.totalRow = totalRow;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
	
	
}
