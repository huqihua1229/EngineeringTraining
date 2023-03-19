package com.fzu.hqh.dto;

public class JsonMessage {
	Integer code;
	String message;
	public JsonMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JsonMessage(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
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
	@Override
	public String toString() {
		return "JsonMessage [code=" + code + ", message=" + message + "]";
	}
	
	

}
