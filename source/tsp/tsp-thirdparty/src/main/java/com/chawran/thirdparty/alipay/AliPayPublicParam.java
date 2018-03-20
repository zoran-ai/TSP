package com.chawran.thirdparty.alipay;

public class AliPayPublicParam {

	private String gateway;

	private String app_id;

	private String app_private_key;

	private String format;

	private String charset;

	private String alipay_public_key;

	private String sign_type;

	private String notify_url;

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getApp_private_key() {
		return app_private_key;
	}

	public void setApp_private_key(String app_private_key) {
		this.app_private_key = app_private_key;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getAlipay_public_key() {
		return alipay_public_key;
	}

	public void setAlipay_public_key(String alipay_public_key) {
		this.alipay_public_key = alipay_public_key;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

}
