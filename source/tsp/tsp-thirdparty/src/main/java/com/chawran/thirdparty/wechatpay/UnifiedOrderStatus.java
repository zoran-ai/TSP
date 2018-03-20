package com.chawran.thirdparty.wechatpay;

public enum UnifiedOrderStatus {
	
	NOAUTH("NOAUTH", "请商户前往申请此接口权限"),
	
	NOTENOUGH("NOTENOUGH", "用户帐号余额不足，请用户充值或更换支付卡后再支付"),
	
	ORDERPAID("ORDERPAID", "商户订单已支付，无需更多操作"),
	
	ORDERCLOSED("ORDERCLOSED", "当前订单已关闭，请重新下单"),
	
	SYSTEMERROR("SYSTEMERROR", "系统异常，请用相同参数重新调用"),
	
	APPID_NOT_EXIST("APPID_NOT_EXIST", "请检查APPID是否正确"),
	
	MCHID_NOT_EXIST("MCHID_NOT_EXIST", "请检查MCHID是否正确"),
	
	APPID_MCHID_NOT_MATCH("APPID_MCHID_NOT_MATCH", "请确认appid和mch_id是否匹配"),
	
	LACK_PARAMS("LACK_PARAMS", "请检查参数是否齐全"),
	
	OUT_TRADE_NO_USED("OUT_TRADE_NO_USED", "请核实商户订单号是否重复提交"),
	
	SIGNERROR("SIGNERROR", "请检查签名参数和方法是否都符合签名算法要求"),
	
	XML_FORMAT_ERROR("XML_FORMAT_ERROR", "请检查XML参数格式是否正确"),
	
	REQUIRE_POST_METHOD("REQUIRE_POST_METHOD", "请检查请求参数是否通过post方法提交"),
	
	POST_DATA_EMPTY("POST_DATA_EMPTY", "请检查post数据是否为空"),
	
	NOT_UTF8("NOT_UTF8", "请使用NOT_UTF8编码格式");

	private final String errorCode;

	private final String errorMsg;

	UnifiedOrderStatus(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String code() {
		return this.errorCode;
	}

	public String msg() {
		return this.errorMsg;
	}
	
}
