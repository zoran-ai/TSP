package com.chawran.thirdparty.alipay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.chawran.core.util.ExceptionUtil;

@SuppressWarnings("all")
public class AliPayUtil {

	private final static Logger logger = LoggerFactory.getLogger(AliPayUtil.class);

	/**
	 * 获取订单字符串
	 * @param publicParam 公共参数
	 * @param bizParam 业务参数
	 */
	public static String getOrderStr(AliPayPublicParam publicParam, AlipayTradeAppPayModel bizParam) {
		String orderstr = "";
		try {
			// 实例化客户端
			AlipayClient alipayClient = new DefaultAlipayClient(publicParam.getGateway(),
					publicParam.getApp_id(), publicParam.getApp_private_key(),
					publicParam.getFormat(), publicParam.getCharset(),
					publicParam.getAlipay_public_key(), publicParam.getSign_type());

			// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
			AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();

			// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
			request.setBizModel(bizParam);
			request.setNotifyUrl(publicParam.getNotify_url());

			// 这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			
			// 就是orderString 可以直接给客户端请求，无需再做处理。
			orderstr = response.getBody();
			
			logger.info("orderstr=" + orderstr);
		} catch (AlipayApiException e) {
			logger.error(ExceptionUtil.getExceptionMessage(e));
			
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

	}

}
