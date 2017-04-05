package com.fruit.sales.weechat;

public class ReturnResult {

	/**
	 * 请求返回的状态码
	 * 
	 * success: 请求正常并正确返回
	 * exception：请求参数错误，系统逻辑无法通过
	 * fail： 请求出现严重错误
	 * 
	 */
	private String code;
	
	/**
	 * 自定义消息信息
	 * 
	 * 和第三方交互信息不能影响系统内部信息定义
	 * 开放一个字段给第三方，和第三方约定好返回参数，解耦对接过程
	 * 
	 */
	private String value;
	
	
	/**
	 * 请求返回的消息体
	 * 
	 * 
	 */
	private String msg;

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
