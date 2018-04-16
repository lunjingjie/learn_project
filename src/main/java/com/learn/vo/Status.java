package com.learn.vo;

public class Status {

	/**
	 * 返回状态码
	 */
	private String statusCode;
	/**
	 * 返回状态信息
	 */
	private String statusMsg;
	
	public Status(String statusCode, String statusMsg) {
		super();
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
}
