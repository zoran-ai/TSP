package com.chawran.thirdparty.baidumap;

import com.chawran.core.util.http.HttpClientConstant;
import com.chawran.core.util.http.HttpClientRequest;
import com.chawran.core.util.http.HttpClientResponse;
import com.chawran.core.util.http.HttpClientUtil;
import com.chawran.core.util.json.JsonUtil;
import com.chawran.thirdparty.baidumap.geocoder.Geocoder;

public class BaiduMapUtil {

	/**
	 * 根据经纬度坐标获取地理位置信息
	 * @param ak 服务端应用秘钥
	 * @param apiUrl API地址
	 * @param coordType 坐标系
	 * @param location 经纬度坐标[纬度,经度]
	 */
	public static HttpClientResponse getAddressByCoordinate(String ak, String apiUrl,
			String coordType, String location) {
		HttpClientResponse response = new HttpClientResponse();

		try {
			String url = apiUrl;
			url += "?output=json";
			url += "&coordtype=" + coordType;
			url += "&ak=" + ak;
			url += "&location=" + location;
			url += "&latest_admin=1";

			HttpClientRequest request = new HttpClientRequest();
			request.setRequestMehtod(HttpClientConstant.REQUEST_METHOD_GET);
			request.setRequestUrl(url);
			request.setContentType(HttpClientConstant.CONTENT_TYPE_FORM);

			response = HttpClientUtil.sendHttpRequest(request);
		} catch (Exception e) {
			response.setResponseCode("N");
			response.setResponseData("根据经纬度坐标获取地理位置信息失败：" + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
	public static void main(String[] args) {
		String ak = "vkXuV8hF0YQtxeA3CBcNAN0voWHxGi4K";
		String url = "http://api.map.baidu.com/geocoder/v2/";
		String coordType = "bd09ll";
		String location = "36.073168,120.389013";
		
		HttpClientResponse response = getAddressByCoordinate(ak, url, coordType, location);
		
		System.out.println(response.getResponseData());
		
		Geocoder geocoder = (Geocoder)JsonUtil.getObjectFromJSON(response.getResponseData(), Geocoder.class);
		
		System.out.println(geocoder.getResult().getFormatted_address());
	}

}
