package com.zhiyou100.vo;

import java.util.List;

public class ResponseVo<T> {
	
	private int errorCode;
	
	private String errorMessage;
	
	private List<T> data;

	public ResponseVo() {
		super();
	}

	public ResponseVo(int errorCode, String errorMessage, List<T> data) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseVo [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", data=" + data + "]";
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
