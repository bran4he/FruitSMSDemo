package com.fruit.sales.common;

import java.util.Map;

public class Result {

	private boolean result;
	private Map<String, Object> msg;
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public Map<String, Object> getMsg() {
		return msg;
	}
	public void setMsg(Map<String, Object> msg) {
		this.msg = msg;
	}
	public Result(boolean result, Map<String, Object> msg) {
		super();
		this.result = result;
		this.msg = msg;
	}
	
	
}
