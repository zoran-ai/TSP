package com.chawran.thirdparty.qiniu;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * 七牛云工具类
 */
@SuppressWarnings("all")
public class QiniuUtil {

	/**
	 * 获取上传凭证
	 * @param accessKey 访问秘钥
	 * @param secretKey 安全秘钥
	 * @param bucket 存储空间
	 */
	public static String getUpToken(String accessKey, String secretKey, String bucket)
			throws Exception {
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		return upToken;
	}
	
	/**
	 * 上传本地文件
	 * @param upToken 上传凭证
	 * @param key 上传后的相对路径
	 * @param localFilePath 本地文件路径
	 */
	public static DefaultPutRet uploadLocalFile(String upToken, String key, String localFilePath)
			throws Exception {
		// 构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		// 初始化上传管理器
		UploadManager uploadManager = new UploadManager(cfg);

		Response response = uploadManager.put(localFilePath, key, upToken);
		DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

		return putRet;
	}
	
	/**
	 * 上传二进制数据
	 * @param upToken 上传凭证
	 * @param key 上传后的相对路径
	 * @param uploadBytes 二进制数据
	 */
	public static DefaultPutRet uploadDataBytes(String upToken, String key, byte[] uploadBytes)
			throws Exception {
		// 构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		// 初始化上传管理器
		UploadManager uploadManager = new UploadManager(cfg);

		Response response = uploadManager.put(uploadBytes, key, upToken);
		DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

		return putRet;
	}
	
	/**
	 * 上传流数据
	 * @param upToken 上传凭证
	 * @param key 上传后的相对路径
	 * @param uploadStream 流数据
	 */
	public static DefaultPutRet uploadDataStream(String upToken, String key,
			InputStream uploadStream) throws Exception {
		// 构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		// 初始化上传管理器
		UploadManager uploadManager = new UploadManager(cfg);

		Response response = uploadManager.put(uploadStream, key, upToken, null, null);
		DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

		return putRet;
	}
	
	/**
	 * 获取访问链接
	 * @param protocol 协议
	 * @param host 主机
	 * @param port 端口
	 * @param path 路径
	 */
	public static String getAccessLink(String protocol, String host, String port, String path)
			throws Exception {
		StringBuffer link = new StringBuffer("");
		link.append(protocol);
		link.append("://");
		link.append(host);
		if (port != null && !"".equals(port) && !"80".equals(port)) {
			link.append(":");
			link.append(port);
		}
		link.append("/");
		link.append(path);
		return link.toString();
	}
	
	public static void main(String[] args) throws Exception {
		String accessKey = "jVH7n_v7Pl_h8Ly_fE6dfiMx3vlR6FvxQ8H49coB";
		String secretKey = "EQPQzoK-f2mfCwFNPfW1ZW2uFsF91Ge3kP85EUGZ";
		String bucket = "chawran-tsp";
		String zone = "zone0";
		
		String upToken = getUpToken(accessKey, secretKey, bucket);
		
		System.out.println(upToken);
		
		String key1 = "image/test/qcode.jpg";
		uploadLocalFile(upToken, key1, "C:\\Users\\ai\\Desktop\\Document\\效果图\\二维码.jpg");
		
		String key2 = "image/test/DataByte";
		uploadDataBytes(upToken, key2, "DataByte".getBytes("utf-8"));
		
		String key3 = "image/test/DataStream";
		uploadDataStream(upToken, key3, new ByteArrayInputStream("DataStream".getBytes("utf-8")));
	}

}
