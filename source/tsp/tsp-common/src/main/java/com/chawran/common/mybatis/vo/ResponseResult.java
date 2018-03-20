package com.chawran.common.mybatis.vo;

public class ResponseResult<T> {

	private String code;

	private T data;
	
	public ResponseResult() {
		
	}
	
	public ResponseResult(String code) {
		this.code = code;
	}
	
	public ResponseResult(String code, T data) {
		this.code = code;
		this.data = data;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
