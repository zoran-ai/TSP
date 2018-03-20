package com.chawran.api.module.test.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chawran.api.framework.property.QiniuProperty;
import com.chawran.api.framework.property.SubmailProperty;
import com.chawran.api.module.test.dao.TestDao;
import com.chawran.core.util.RandomUtil;
import com.chawran.core.util.ThumbnailatorUtil;
import com.chawran.core.util.http.HttpClientResponse;
import com.chawran.core.util.json.JsonUtil;
import com.chawran.thirdparty.qiniu.QiniuUtil;
import com.chawran.thirdparty.submail.SubmailUtil;

@Service
@SuppressWarnings("all")
public class TestService {

	@Resource
	private QiniuProperty qiniuProperty;
	
	@Resource
	private SubmailProperty submailProperty;
	
	@Resource
	private TestDao testDao;
	
	/**
	 * 获取当前时间
	 */
	public String getCurrentTime() throws Exception {
		return testDao.getCurrentTime();
	}
	
	/**
	 * 上传图片
	 * @param imageFile 图片文件
	 */
	public String uploadImage(MultipartFile imageFile) throws Exception {
		String accessKey = qiniuProperty.getAccessKey();
		String secretKey = qiniuProperty.getSecretKey();
		String bucket = qiniuProperty.getBucket();
		String zone = qiniuProperty.getZone();
		String protocol = qiniuProperty.getProtocol();
		String host = qiniuProperty.getHost();
		String port = qiniuProperty.getPort();
		
		String token = QiniuUtil.getUpToken(accessKey, secretKey, bucket);
		
		String fileKey = "image/test/interface/" + imageFile.getOriginalFilename();
		
		QiniuUtil.uploadDataStream(token, fileKey, imageFile.getInputStream());
		
		return QiniuUtil.getAccessLink(protocol, host, port, fileKey);
	}
	
	/**
	 * 上传压缩图片
	 * @param imageFile 图片文件
	 */
	public String uploadCompressImage(MultipartFile imageFile) throws Exception {
		String accessKey = qiniuProperty.getAccessKey();
		String secretKey = qiniuProperty.getSecretKey();
		String bucket = qiniuProperty.getBucket();
		String zone = qiniuProperty.getZone();
		String protocol = qiniuProperty.getProtocol();
		String host = qiniuProperty.getHost();
		String port = qiniuProperty.getPort();
		
		String rootPath = "C:\\tsp\\imgs\\";
		
		File originalFile = new File("C:\\tsp\\imgs\\original\\" + imageFile.getOriginalFilename());
		imageFile.transferTo(originalFile);
		
		ThumbnailatorUtil.zoomImageByQuality(originalFile.getAbsolutePath(), "C:\\tsp\\imgs\\compress\\"+imageFile.getOriginalFilename(), 0.5);
		
		String token = QiniuUtil.getUpToken(accessKey, secretKey, bucket);
		
		String fileKey = "image/test/interface/compress/" + imageFile.getOriginalFilename();
		
		QiniuUtil.uploadLocalFile(token, fileKey, "C:\\tsp\\imgs\\compress\\"+imageFile.getOriginalFilename());
		
		return QiniuUtil.getAccessLink(protocol, host, port, fileKey);
	}
	
	/**
	 * 获取短信验证码
	 * @param telephone 收件人手机号
	 */
	public HttpClientResponse getVerificationCode(String telephone) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("verificationCode", RandomUtil.generateRandomCode("number", 6));
		map.put("periodOfValidity", "一小时");

		return SubmailUtil.sendSMS(telephone, JsonUtil.getJSONFromMap(map),
				submailProperty.getAppId(), submailProperty.getAppKey(),
				submailProperty.getVerificationCodeTemplate(), submailProperty.getApiUrl());
	}
	
	
}
