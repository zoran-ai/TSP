package com.chawran.api.framework.interceptor;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.chawran.api.framework.property.ConfigProperty;
import com.chawran.common.enumeration.EnumContentType;
import com.chawran.common.mybatis.vo.ResponseResult;
import com.chawran.core.util.DateUtil;
import com.chawran.core.util.ExceptionUtil;
import com.chawran.core.util.RSAUtil;
import com.chawran.core.util.json.JsonUtil;

@SuppressWarnings("all")
public class SecurityInterceptor implements HandlerInterceptor {
	
	private final static Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);
	
	@Resource
	private ConfigProperty configProperty;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean result = false;
		
		// 加密令牌-从请求头中获取
		String encryptToken = "";
		// 解密令牌-通过私钥解密
		String decryptToken = "";
		
		try {
			encryptToken = request.getHeader(configProperty.getTokenName());
			
			if (encryptToken != null && !"".equals(encryptToken)) {
//				decryptToken = RSAUtil.decrypt(encryptToken, configProperty.getRhaPrivateKey());
//				
//				result = validateToken(decryptToken);
				
				result = true;
			}
		} catch (Exception e) {
			logger.error("==========Token解析发生异常==========");
			logger.error(configProperty.getTokenName() + "=" + encryptToken);
			logger.error(ExceptionUtil.getExceptionMessage(e));
		}
		
		if (!result) {
			try {
				response.setStatus(HttpStatus.FORBIDDEN.value());
				response.setContentType(EnumContentType.JSON.toString());
				response.getWriter().print(JsonUtil.getJSONFromObject(new ResponseResult("N", "您没有访问权限！")));
				response.getWriter().flush();
				response.getWriter().close();
			} catch (Exception e) {
				logger.error("==========Token解析输出发生异常==========");
				logger.error(configProperty.getTokenName() + "=" + encryptToken);
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}
		}
		
		return result;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
	/**
	 * 验证令牌
	 */
	private boolean validateToken(String token) throws Exception {
		boolean flag = false;
		
		if (token != null && !"".equals(token)) {
			if (token.indexOf(".") > -1) {
				String[] tokenArr = token.split("[.]");
				if (tokenArr.length == Integer.parseInt(configProperty.getTokenSegmentSize())) {
					if (configProperty.getTokenSegmentProduct().equals(tokenArr[0])) {
						if (configProperty.getTokenSegmentType().equals(tokenArr[1])) {
							String userId = tokenArr[2];
							
							if (userId != null && !"".equals(userId)) {
								if (userId.length() == 32) {
									String time = tokenArr[3];
									
									if (time != null && !"".equals(time)) {
										if (time.length() == 14) {
											Date generateTime = DateUtil.strToDate(time, DateUtil.DATE_TIME_FORMAT_SIMPLE);
												
											flag = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return flag;
	}

}
