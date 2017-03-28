package com.fruit.sales.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class StringTools {

	public static void main(String[] args) {
		System.out.println(getTableName("OrderStatus"));
		System.out.println(getTableName("User"));
		System.out.println(getTableName("Product"));
		System.out.println(getTableName("ProductDef"));
		
		
        String line="I_HAVE_AN_IPANG3_PIG";
        System.out.println(underline2Camel(line,true));
        System.out.println(underline2Camel(line, false));
        
        
        System.out.println(underline2Camel("ID", true));//default
        System.out.println(underline2Camel("T_PRODUCT_DEF", true));//default
        System.out.println(underline2Camel("T_PRODUCT_DEF", false));
        
        
        
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
	
	/**
	 * default
	 * @param line
	 * @return
	 */
	public static String underline2Camel(String line){
		return underline2Camel(line, true);
	}
	
	
	/**
     * 下划线转驼峰法
     * @param line 源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰
     * @return 转换后的字符串
     */
    public static String underline2Camel(String line,boolean smallCamel){
        if(line==null||"".equals(line)){
            return "";
        }
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(smallCamel&&matcher.start()==0?Character.toLowerCase(word.charAt(0)):Character.toUpperCase(word.charAt(0)));
            int index=word.lastIndexOf('_');
            if(index>0){
                sb.append(word.substring(1, index).toLowerCase());
            }else{
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }
    
    /**
     * 驼峰法转下划线
     * @param line 源字符串
     * @return 转换后的字符串
     */
    public static String camel2Underline(String line){
        if(line==null||"".equals(line)){
            return "";
        }
        line=String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end()==line.length()?"":"_");
        }
        return sb.toString();
    }
	

}