package com.fruit.sales.wechat;

public enum RestultCode {

	SUCCESS("success"), 
	EXCEPTION("exception"), 
	FAIL("fail");
	
	private String name;
	
	private RestultCode(String name) {
		this.name = name;
	}

}
