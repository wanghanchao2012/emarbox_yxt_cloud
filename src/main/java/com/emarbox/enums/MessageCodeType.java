package com.emarbox.enums;

public enum MessageCodeType {
	success("操作成功!"),
	failed("操作失败!");

	private Integer code;
	private String message;

	MessageCodeType(String message) {
		code = -1;
		message = this.message;
	}

	MessageCodeType(Integer code, String message) {
		code = this.code;
		message = this.message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
 
}
