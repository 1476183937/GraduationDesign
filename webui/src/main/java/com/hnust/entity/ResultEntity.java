package com.hnust.entity;

import java.io.Serializable;

/**
*@title:
*@description: 统一返回结果
*@author:ggh
*@updateTime: 2020/5/13 11:37
**/
public class ResultEntity<T> implements Serializable {
	
	private String result;
	private String message;
	private T data;
	
	public static final String SUCCESS = "SUCCESS";
	public static final String FAILED = "FAILED";
	public static final String NO_MSG = "NO_MSG";
	public static final String NO_DATA = "NO_DATA";

	public ResultEntity(String result, String message, T data) {
		this.result = result;
		this.message = message;
		this.data = data;
	}

	public static ResultEntity<String> successNoData() {
		return new ResultEntity<>(SUCCESS, NO_MSG, NO_DATA);
	}
	
	public static <T> ResultEntity<T> successWithData(T data) {
		return new ResultEntity<>(SUCCESS, NO_MSG, data);
	}
	
	public static <T> ResultEntity<T> failed(String message) {
		return new ResultEntity<>(FAILED, message, null);
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static String getSUCCESS() {
		return SUCCESS;
	}

	public static String getFAILED() {
		return FAILED;
	}

	public static String getNoMsg() {
		return NO_MSG;
	}

	public static String getNoData() {
		return NO_DATA;
	}
}