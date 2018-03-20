package com.chawran.api.module.test.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chawran.api.framework.property.ConfigProperty;
import com.chawran.api.module.test.service.TestService;
import com.chawran.common.mybatis.vo.ResponseResult;
import com.chawran.common.mybatis.vo.TestVO;
import com.chawran.core.util.ExceptionUtil;
import com.chawran.core.util.http.HttpClientResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "测试")
@SuppressWarnings("all")
public class TestController {

	private final static Logger logger = LoggerFactory.getLogger(TestController.class);

	@Resource
	private ConfigProperty configProperty;

	@Resource
	private TestService testService;

	@ApiOperation(value = "测试请求头访问令牌")
//	@ApiImplicitParams({ @ApiImplicitParam(name = "TSPSSOTOken", paramType = "header", required = true) })
	@RequestMapping(value = "/api/private/test/testToken", method = RequestMethod.GET)
	public String testToken(@RequestHeader(value = "TSPSSOTOken") String token) {
		return token;
	}
	
	@ApiOperation(value = "测试查询参数")
//	@ApiImplicitParams({ @ApiImplicitParam(name = "name", required = true, paramType = "query") })
	@RequestMapping(value = "/api/public/test/testQueryParameter", method = RequestMethod.GET)
	public String testQueryParameter(@RequestParam(value = "name") String name) {
		return name;
	}

	@ApiOperation(value = "测试路径参数")
//	@ApiImplicitParams({ @ApiImplicitParam(name = "name", required = true, paramType = "path") })
	@RequestMapping(value = "/api/public/test/testPathVariable/{name}", method = RequestMethod.GET)
	public String testPathVariable(@PathVariable(value = "name") String name) {
		return name;
	}

	@ApiOperation(value = "测试请求体")
//	@ApiImplicitParams({ @ApiImplicitParam(name = "TestVO", required = true, paramType = "body") })
	@RequestMapping(value = "/api/public/test/testRequestBody", method = RequestMethod.POST)
	public @ResponseBody ResponseResult<TestVO> testRequestBody(@RequestBody TestVO vo) {
		return new ResponseResult("Y", vo);
	}
	
	@ApiOperation(value = "测试响应体")
//	@ApiImplicitParams({ @ApiImplicitParam(name = "data", required = true, paramType = "query") })
	@RequestMapping(value = "/api/public/test/testResponseBody", method = RequestMethod.GET)
	public @ResponseBody ResponseResult<String> testResponseBody(
			@RequestParam(value = "data") String data) {
		return new ResponseResult("Y", data);
	}
	
	@ApiOperation(value = "测试API版本")
	@ApiImplicitParams({ @ApiImplicitParam(name = "TSPAPIVersion", paramType = "header", required = true) })
	@RequestMapping(value = "/api/public/test/testApiVersion", method = RequestMethod.GET, headers = "TSPAPIVersion=v1")
	public String testApiVersion1() {
		return "v1";
	}
	
	@ApiOperation(value = "测试API版本")
	@ApiImplicitParams({ @ApiImplicitParam(name = "TSPAPIVersion", paramType = "header", required = true) })
	@RequestMapping(value = "/api/public/test/testApiVersion", method = RequestMethod.GET, headers = "TSPAPIVersion=v2")
	public String testApiVersion2() {
		return "v2";
	}
	
	@ApiOperation(value = "测试API版本")
	@ApiImplicitParams({ @ApiImplicitParam(name = "TSPAPIVersion", paramType = "header", required = true) })
	@RequestMapping(value = "/api/public/test/testApiVersion", method = RequestMethod.GET, headers = "TSPAPIVersion=v3")
	public String testApiVersion3() {
		return "v3";
	}
	
	@ApiOperation(value = "测试从数据库中查询数据")
	@RequestMapping(value = "/api/public/test/testSelectDataFromDB", method = RequestMethod.GET)
	public @ResponseBody ResponseResult<String> testSelectDataFromDB() {
		try {
			return new ResponseResult("Y", testService.getCurrentTime());
		} catch (Exception e) {
			logger.error(ExceptionUtil.getExceptionMessage(e));
			return new ResponseResult("N", "获取当前系统时间失败！");
		}
	}
	
	@ApiOperation(value = "上传图片")
	@RequestMapping(value = "/api/public/test/testUploadImage", method = RequestMethod.POST)
	public @ResponseBody ResponseResult<String> testUploadImage(
			@RequestParam("imageFile") MultipartFile imageFile) {
		try {
			String link = testService.uploadImage(imageFile);
			return new ResponseResult("Y", link);
		} catch (Exception e) {
			logger.error(ExceptionUtil.getExceptionMessage(e));
			return new ResponseResult("N", "上传图片失败！");
		}
	}
	
	@ApiOperation(value = "上传压缩图片")
	@RequestMapping(value = "/api/public/test/testUploadCompressImage", method = RequestMethod.POST)
	public @ResponseBody ResponseResult<String> testUploadCompressImage(
			@RequestParam("imageFile") MultipartFile imageFile) {
		try {
			String link = testService.uploadCompressImage(imageFile);
			return new ResponseResult("Y", link);
		} catch (Exception e) {
			logger.error(ExceptionUtil.getExceptionMessage(e));
			return new ResponseResult("N", "上传压缩图片失败！");
		}
	}
	
	@ApiOperation(value = "测试短信验证码")
	@ApiImplicitParams({ @ApiImplicitParam(name = "telephone", paramType = "query", required = true) })
	@RequestMapping(value = "/api/public/test/testSMS", method = RequestMethod.GET)
	public @ResponseBody ResponseResult<String> testSMS(@RequestParam(value = "telephone") String telephone) {
		try {
			HttpClientResponse result = testService.getVerificationCode(telephone);
			return new ResponseResult("Y", result);
		} catch (Exception e) {
			logger.error(ExceptionUtil.getExceptionMessage(e));
			return new ResponseResult("N", "获取短信验证码失败！");
		}
	}

}
