package com.fruit.sales.common;

public class Result {

	private boolean result;
	private String msg;
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Result(boolean result, String msg) {
		this.result = result;
		this.msg = msg;
	}
	
	
}
