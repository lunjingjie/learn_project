package com.learn.util;

public enum Code 
{
	OPERATION_SUCCESS("200", "操作成功"), 
	VALIDATE_ERROR("100", "验证失败"),
	FORBIDDEN("403","无权限"),
	UNAUTHORIZED("401","未登录验证"),
	SYSTEM_ERROR("500","系统错误"),
	NULL_ERROR("400","请求资源不存在");
	
	/**
	 * 返回状态码
	 */
	private String statusCode;
	/**
	 * 返回状态信息
	 */
	private String statusMsg;

	Code(String statusCode, String statusMsg) {
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
	}

	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @return the statusMsg
	 */
	public String getStatusMsg() {
		return statusMsg;
	}
}
