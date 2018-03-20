package com.chawran.api.framework.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SubmailProperty {

	@Value("${submail.api.url}")
	private String apiUrl;
	
	@Value("${submail.appid}")
	private String appId;
	
	@Value("${submail.appkey}")
	private String appKey;
	
	@Value("${submail.template.verificationCode}")
	private String verificationCodeTemplate;

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getVerificationCodeTemplate() {
		return verificationCodeTemplate;
	}

	public void setVerificationCodeTemplate(String verificationCodeTemplate) {
		this.verificationCodeTemplate = verificationCodeTemplate;
	}
	
}
