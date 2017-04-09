package com.fruit.sales.common;

import java.util.Map;

public class Result {

	private boolean result;
	private Map<String, Object> msg;
	//和前端约定错误信息
	private String code;
	
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
	public Result() {
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
