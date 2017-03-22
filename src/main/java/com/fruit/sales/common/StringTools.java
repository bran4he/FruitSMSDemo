package com.fruit.sales.common;

import org.apache.commons.lang3.StringUtils;

public class StringTools {

	public static void main(String[] args) {
		System.out.println(getTableName("OrderStatus"));
		System.out.println(getTableName("User"));
		System.out.println(getTableName("Product"));
		System.out.println(getTableName("ProductDef"));
	}
	
	/**
	 * 获取表名称
	 * 
	 * @param entityName
	 * @return
	 */
	public static String getTableName(String entityName) {

		if (StringUtils.isEmpty(entityName)) {
			return null;
		}
		StringBuilder tableName = new StringBuilder("T_");

		int i = 0;
		StringBuilder str = new StringBuilder();
		char[] subStr = entityName.toCharArray();

		while (i < subStr.length) {
			if(Character.isLowerCase(subStr[i])) {
				str.append(String.valueOf(subStr[i]).toUpperCase());
			}else {
				if(i > 0){
					str.append("_").append(subStr[i]);
				}else{
					str.append(subStr[i]);
				}
			}
			i++;
		}
		tableName.append(str.toString());
		return tableName.toString();
	}

}