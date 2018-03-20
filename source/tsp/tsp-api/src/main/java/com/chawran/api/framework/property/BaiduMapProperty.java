package com.chawran.api.framework.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BaiduMapProperty {

	@Value("${baidu.map.coordtype}")
	private String coordType;

	@Value("${baidu.map.ws.geocoding.url}")
	private String wsGeocodingUrl;

	@Value("${baidu.map.app.server.code}")
	private String appServerCode;

	@Value("${baidu.map.app.server.name}")
	private String appServerName;

	@Value("${baidu.map.app.server.ak}")
	private String appServerAk;

	public String getCoordType() {
		return coordType;
	}

	public void setCoordType(String coordType) {
		this.coordType = coordType;
	}

	public String getWsGeocodingUrl() {
		return wsGeocodingUrl;
	}

	public void setWsGeocodingUrl(String wsGeocodingUrl) {
		this.wsGeocodingUrl = wsGeocodingUrl;
	}

	public String getAppServerCode() {
		return appServerCode;
	}

	public void setAppServerCode(String appServerCode) {
		this.appServerCode = appServerCode;
	}

	public String getAppServerName() {
		return appServerName;
	}

	public void setAppServerName(String appServerName) {
		this.appServerName = appServerName;
	}

	public String getAppServerAk() {
		return appServerAk;
	}

	public void setAppServerAk(String appServerAk) {
		this.appServerAk = appServerAk;
	}

}
