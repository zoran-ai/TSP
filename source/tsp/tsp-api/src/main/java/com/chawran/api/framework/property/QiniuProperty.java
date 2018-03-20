package com.chawran.api.framework.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QiniuProperty {

	@Value("${qiniu.AccessKey}")
	private String accessKey;

	@Value("${qiniu.SecretKey}")
	private String secretKey;

	@Value("${qiniu.StorageSpace.bucket}")
	private String bucket;

	@Value("${qiniu.StorageSpace.zone}")
	private String zone;

	@Value("${qiniu.url.protocol}")
	private String protocol;

	@Value("${qiniu.url.host}")
	private String host;

	@Value("${qiniu.url.port}")
	private String port;

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

}
