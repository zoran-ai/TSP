package com.chawran.thirdparty.baidumap.geocoder;

public enum GeocoderStatus {
	
	NORMAL(0, "正常"),
	
	SERVER_INTERNAL_ERROR(1, "服务器内部错误"),
	
	INVALID_REQUEST_PARAMETER(2, "请求参数非法"),
	
	AUTH_CHECK_FAILURE(3, "权限校验失败"),
	
	QUOTA_CHECK_FAILURE(4, "配额校验失败"),
	
	AK_NOT_EXIST(5, "ak不存在或者非法"),
	
	SERVICE_DISABLED(101, "服务禁用"),
	
	NO_PASS_WHITELIST(102, "不通过白名单或者安全码不对");

	private final int code;

	private final String msg;

	GeocoderStatus(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int code() {
		return this.code;
	}

	public String msg() {
		return this.msg;
	}
	
}
