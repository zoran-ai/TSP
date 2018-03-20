package com.chawran.api.framework.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeChatPayProperty {

	@Value("${wechatpay.app.appid}")
	private String appid;

	@Value("${wechatpay.app.mchid}")
	private String mchid;

	@Value("${wechatpay.app.key}")
	private String key;

	@Value("${wechatpay.app.tradeType}")
	private String tradeType;

	@Value("${wechatpay.app.notifyUrl}")
	private String notifyUrl;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

}
