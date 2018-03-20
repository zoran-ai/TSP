package com.chawran.core.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.chawran.core.util.json.JsonUtil;

@SuppressWarnings("all")
public class ExceptionUtil {

	// public static final int EXCEPTION_MESSAGE_LENGTH = 1000;

	public static final String MESSAGE_TYPE_HTML = "HTML";
	public static final String MESSAGE_TYPE_XML = "XML";
	public static final String MESSAGE_TYPE_JSON = "JSON";
	public static final String MESSAGE_TYPE_TEXT = "TEXT";

	/**
	 * 获取异常信息
	 * @param exception 异常对象
	 */
	public static String getExceptionMessage(Exception exception) {
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			exception.printStackTrace(pw);
			pw.flush();
			sw.flush();
		} finally {
			if (sw != null) {
				try {
					sw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (pw != null) {
				pw.close();
			}
		}
		return sw.toString();
	}
	
	/**
	 * 获取异常信息
	 * @param exception 异常对象
	 * @param type 异常类型
	 */
	public static String getExceptionMessage(Exception exception, String type) {
		String content = exception.getLocalizedMessage();

		// if (content.length() > EXCEPTION_MESSAGE_LENGTH) {
		// content = content.substring(0, EXCEPTION_MESSAGE_LENGTH);
		// }

		StackTraceElement[] stackTrace = exception.getStackTrace();

		String message = new String("");

		if (MESSAGE_TYPE_HTML.equals(type)) {
			message += "<table style=\"width:100%;margin:0px;border:0px;line-height:25px;word-break:break-all; word-wrap:break-all;\">";

			message += "<tr>";
			message += "<td style=\"text-align:right;width:50px;\">";
			message += "异常：";
			message += "</td>";
			message += "<td style=\"text-align:left;font-weight:500;\">";
			message += exception.getClass().getName() + ":" + content;
			message += "</td>";
			message += "</tr>";

			if (stackTrace != null && stackTrace.length > 0) {
				message += "<tr>";
				message += "<td style=\"text-align:right;\">";
				message += "类：";
				message += "</td>";
				message += "<td style=\"text-align:left;font-weight:500;\">";
				message += stackTrace[0].getClassName();
				message += "</td>";
				message += "</tr>";

				message += "<tr>";
				message += "<td style=\"text-align:right;\">";
				message += "方法：";
				message += "</td>";
				message += "<td style=\"text-align:left;font-weight:500;\">";
				message += stackTrace[0].getMethodName();
				message += "</td>";
				message += "</tr>";

				message += "<tr>";
				message += "<td style=\"text-align:right;\">";
				message += "行号：";
				message += "</td>";
				message += "<td style=\"text-align:left;font-weight:500;\">";
				message += stackTrace[0].getLineNumber();
				message += "</td>";
				message += "</tr>";
			}

			message += "</table>";
		} else if (MESSAGE_TYPE_XML.equals(type)) {
			message += "<exception>";
			message += exception.getClass().getName() + ":" + content;
			message += "</exception>";

			if (stackTrace != null && stackTrace.length > 0) {
				message += "<className>" + stackTrace[0].getClassName() + "</className>";
				message += "<methodName>" + stackTrace[0].getMethodName() + "</methodName>";
				message += "<lineNumber>" + stackTrace[0].getLineNumber() + "</lineNumber>";
			}
		} else if (MESSAGE_TYPE_JSON.equals(type)) {
			Map<String, String> map = new HashMap<String, String>();

			map.put("message", content);

			if (stackTrace != null && stackTrace.length > 0) {
				map.put("className", stackTrace[0].getClassName());
				map.put("methodName", stackTrace[0].getMethodName());
				map.put("lineNumber", String.valueOf(stackTrace[0].getLineNumber()));
			}

			message = JsonUtil.getJSONFromMap(map);
		} else if (MESSAGE_TYPE_TEXT.equals(type)) {
			message += "异常：";
			message += exception.getClass().getName() + ":" + content + ";";

			if (stackTrace != null && stackTrace.length > 0) {
				message += "类：";
				message += stackTrace[0].getClassName() + ";";
				message += "方法：";
				message += stackTrace[0].getMethodName() + ";";
				message += "行号：";
				message += stackTrace[0].getLineNumber() + ";";
			}
		}

		return message;
	}

}
