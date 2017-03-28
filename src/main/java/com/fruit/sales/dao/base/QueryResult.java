package com.fruit.sales.dao.base;

import java.util.List;

public class QueryResult<T> {

	//分页数据结果
	private List<T> list;
	//总数据行数
	private int totalRow;
	//一页数据行数
	private int pageSize;
	//当前页码
	private int pageNo;
	//总页数
	private int totalPage;
	
	public QueryResult(List<T> list, int totalRow, int pageNo, int pageSize) {
		this.list = list;
		this.totalRow = totalRow;
		this.totalPage = (totalRow  +  pageSize  - 1) / pageSize;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
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
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
}
