package com.chawran.api.framework.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigProperty {

	@Value("${des.key}")
	private String desKey;

	@Value("${rha.key.public}")
	private String rhaPublicKey;

	@Value("${rha.key.private}")
	private String rhaPrivateKey;

	@Value("${token.name}")
	private String tokenName;

	@Value("${token.segment.size}")
	private String tokenSegmentSize;

	@Value("${token.segment.product}")
	private String tokenSegmentProduct;

	@Value("${token.segment.type}")
	private String tokenSegmentType;

	@Value("${token.segment.user}")
	private String tokenSegmentUser;

	@Value("${token.segment.timestamp}")
	private String tokenSegmentTimestamp;

	@Value("${random.code.type}")
	private String randomCodeType;

	@Value("${random.code.length}")
	private String randomCodeLength;

	public String getDesKey() {
		return desKey;
	}

	public void setDesKey(String desKey) {
		this.desKey = desKey;
	}

	public String getRhaPublicKey() {
		return rhaPublicKey;
	}

	public void setRhaPublicKey(String rhaPublicKey) {
		this.rhaPublicKey = rhaPublicKey;
	}

	public String getRhaPrivateKey() {
		return rhaPrivateKey;
	}

	public void setRhaPrivateKey(String rhaPrivateKey) {
		this.rhaPrivateKey = rhaPrivateKey;
	}

	public String getTokenName() {
		return tokenName;
	}

	public void setTokenName(String tokenName) {
		this.tokenName = tokenName;
	}

	public String getTokenSegmentSize() {
		return tokenSegmentSize;
	}

	public void setTokenSegmentSize(String tokenSegmentSize) {
		this.tokenSegmentSize = tokenSegmentSize;
	}

	public String getTokenSegmentProduct() {
		return tokenSegmentProduct;
	}

	public void setTokenSegmentProduct(String tokenSegmentProduct) {
		this.tokenSegmentProduct = tokenSegmentProduct;
	}

	public String getTokenSegmentType() {
		return tokenSegmentType;
	}

	public void setTokenSegmentType(String tokenSegmentType) {
		this.tokenSegmentType = tokenSegmentType;
	}

	public String getTokenSegmentUser() {
		return tokenSegmentUser;
	}

	public void setTokenSegmentUser(String tokenSegmentUser) {
		this.tokenSegmentUser = tokenSegmentUser;
	}

	public String getTokenSegmentTimestamp() {
		return tokenSegmentTimestamp;
	}

	public void setTokenSegmentTimestamp(String tokenSegmentTimestamp) {
		this.tokenSegmentTimestamp = tokenSegmentTimestamp;
	}

	public String getRandomCodeType() {
		return randomCodeType;
	}

	public void setRandomCodeType(String randomCodeType) {
		this.randomCodeType = randomCodeType;
	}

	public String getRandomCodeLength() {
		return randomCodeLength;
	}

	public void setRandomCodeLength(String randomCodeLength) {
		this.randomCodeLength = randomCodeLength;
	}

}
