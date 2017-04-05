package com.fruit.sales.weechat;

public enum RegisterStatus {

	ACTIVE("active"), 
	NOTACTIVE("notactive"), 
	NA("NA");
	
	private String name;
	
	private RegisterStatus(String name) {
		this.name = name;
	}

	
}
