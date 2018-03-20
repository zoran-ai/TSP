package com.chawran.thirdparty.wechatpay;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chawran.core.util.DateUtil;
import com.chawran.core.util.ExceptionUtil;
import com.chawran.core.util.MD5Util;
import com.chawran.core.util.RandomUtil;
import com.chawran.core.util.XMLUtil;
import com.chawran.core.util.http.HttpClientConstant;
import com.chawran.core.util.http.HttpClientRequest;
import com.chawran.core.util.http.HttpClientResponse;
import com.chawran.core.util.http.HttpClientUtil;

@SuppressWarnings("all")
public class WeChatPayUtil {

	private final static Logger logger = LoggerFactory.getLogger(WeChatPayUtil.class);
	
	/**
	 * 获取随机字符串
	 */
	public static String getNonceStr() throws Exception {
		// 前缀[9位随机字母数字组合]
		String prefix = RandomUtil.generateRandomCode("letter_number", 9);
		// 时间[14位:yyyyMMddHHmmssSSS]
		String time = DateUtil.dateToStr(new Date(), DateUtil.DATE_TIME_FORMAT_SIMPLE);
		// 后缀[9位随机字母数字组合]
		String suffix = RandomUtil.generateRandomCode("letter_number", 9);
		// 随机字符串=9位随机字母数字组合+14位时间+9位随机字母数字组合
		String nonceStr = prefix + time + suffix;
		
		return nonceStr;
	}
	
	/**
	 * 获取签名
	 * 1.把非空参数按照参数名ASCII码从小到大排序（字典序）使用URL键值对的格式拼接成字符串stringA
	 * 2.在stringA最后拼接上key得到stringSignTemp字符串
	 * 3.对stringSignTemp进行MD5运算
	 * 4.将得到的字符串所有字符转换为大写
	 * @param order 统一下单实体
	 * @param key 微信商户平台-->账户设置-->API安全-->密钥设置
	 */
	public static String getSign(UnifiedOrderRequest order, String key) throws Exception {
		SortedMap<Object, Object> map = new TreeMap<Object, Object>();
		map.put("appid", order.getAppid());
		map.put("mch_id", order.getMch_id());
		map.put("nonce_str", order.getNonce_str());
		map.put("body", order.getBody());
		map.put("out_trade_no", order.getOut_trade_no());
		map.put("total_fee", order.getTotal_fee());
		map.put("spbill_create_ip", order.getSpbill_create_ip());
		map.put("notify_url", order.getNotify_url());
		map.put("trade_type", order.getTrade_type());
		
		StringBuffer sb = new StringBuffer();
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + key);
		
		return MD5Util.MD5(sb.toString()).toString();
	}
	
	/**
	 * 微信支付:统一下单
	 * @param request 微信支付参数
	 */
	public static HttpClientResponse unifiedOrder(UnifiedOrderRequest request, String apiUrl) {
		HttpClientResponse response = null;
		
		logger.info("==========微信支付 Begin==========");
		
		try {
			String requestXmlStr = XMLUtil.java2Xml(request, "xml");
			
			logger.info("RequestXml=" + requestXmlStr);
			
			HttpClientRequest requestPost = new HttpClientRequest();
			requestPost.setRequestUrl(apiUrl);
			requestPost.setRequestMehtod(HttpClientConstant.REQUEST_METHOD_POST);
			requestPost.setRequestHeaders(null);
			requestPost.setRequestBody(requestXmlStr);
			requestPost.setRequestParams(null);
			requestPost.setContentType(HttpClientConstant.CONTENT_TYPE_XML);
			
			response = HttpClientUtil.sendHttpRequest(requestPost);
		} catch (Exception e) {
			logger.error(ExceptionUtil.getExceptionMessage(e));
			
			e.printStackTrace();
		}
		
		logger.info("==========微信支付 End==========");
		
		return response;
	}

	public static void main(String[] args) throws Exception {
//		String nonceStr = getNonceStr();
//		System.out.println(nonceStr);
		
		System.out.println(UnifiedOrderStatus.NOAUTH.code());
		System.out.println(UnifiedOrderStatus.NOAUTH.msg());
		System.out.println(UnifiedOrderStatus.valueOf(UnifiedOrderStatus.NOAUTH.code()).msg());
	}

}
