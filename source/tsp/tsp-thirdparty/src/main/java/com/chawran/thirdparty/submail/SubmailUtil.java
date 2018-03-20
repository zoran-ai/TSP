package com.chawran.thirdparty.submail;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;

import com.chawran.core.util.http.HttpClientConstant;
import com.chawran.core.util.http.HttpClientRequest;
import com.chawran.core.util.http.HttpClientResponse;
import com.chawran.core.util.http.HttpClientUtil;
import com.chawran.core.util.json.JsonUtil;
import com.google.common.collect.Lists;

/**
 * 赛邮工具类
 */
@SuppressWarnings("all")
public class SubmailUtil {
	
	/**
	 * 发送短信
	 * @param telephone 收件人手机号
	 * @param vars 文本变量[JSON字符串]
	 * @param appId 短信应用ID
	 * @param appKey 短信应用秘钥
	 * @param templateId 短信模板ID
	 * @param apiUrl API的地址
	 */
	public static HttpClientResponse sendSMS(String telephone, String vars, String appId, String appKey,
			String templateId, String apiUrl) throws Exception {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("appid", appId);
		paramMap.put("signature", appKey);
		paramMap.put("project", templateId);
		paramMap.put("to", telephone);
		paramMap.put("vars", vars);
		
		HttpClientRequest requestPost = new HttpClientRequest();
		requestPost.setRequestUrl(apiUrl);
		requestPost.setRequestMehtod(HttpClientConstant.REQUEST_METHOD_POST);
		requestPost.setRequestHeaders(null);
		requestPost.setRequestBody(null);
		requestPost.setRequestParams(paramMap);
		requestPost.setContentType(HttpClientConstant.CONTENT_TYPE_FORM);
		
		HttpClientResponse responePost = HttpClientUtil.sendHttpRequest(requestPost);
		
		return responePost;
	}
	
	public static void main(String[] args) throws Exception {
		String telephone = "15853257351";
		String vars = "{\"verificationCode\":\"860811\",\"periodOfValidity\":\"一小时\"}";
		String appId = "16073";
		String appKey = "2ed39caed928feab1b53c297c802a369";
		String templateId = "2iXx03";
		String apiUrl = "https://api.mysubmail.com/message/xsend";
		
		SubmailUtil.sendSMS(telephone, vars, appId, appKey, templateId, apiUrl);
	}

}
