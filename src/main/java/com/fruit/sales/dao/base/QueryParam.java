package com.fruit.sales.dao.base;

public class QueryParam {

	//每页数据量
	private int rows;//1
	//当前页数
	private int page;//1
	//排序字段
	private String sidx;//id
	//排序方式
	private String sord;//desc
	
	
	
	public QueryParam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	
	
}
