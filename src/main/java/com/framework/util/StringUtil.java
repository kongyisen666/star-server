package com.framework.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

public class StringUtil {
	/**
	 * @name 转换字符串
	 * @description 将 string 类型 转换成 date 类型，返回"yyyy/M/d HH:mm:ss"格式
	 * @author
	 * @return
	 */
	public static Date parseTimestamp(String dateText) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			return sdf.parse(dateText);
		} catch (Exception e) {
		}

		sdf = new SimpleDateFormat("yyyy/M/d HH:mm:ss");
		try {
			return sdf.parse(dateText);
		} catch (Exception e) {
		}
		sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			return sdf.parse(dateText);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * @name 转换时间类型
	 * @description 将 date 类型转换成 string 类型，返回format格式"yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	private static String lastFileDate = "0";
	private static int fileIndex = 0;

	/**
	 * 得到文件名称
	 *
	 * @return
	 */
	public static String getFileNameBySysDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String curDate = sdf.format(new Date());
		if (curDate.equals(lastFileDate)) {
			fileIndex++;
		} else {
			fileIndex = 0;
		}
		lastFileDate = curDate;
		return curDate + fileIndex;
	}
	/**
	 * @name MD5加密
	 * @description MD5加密
	 * @return
	 */
	public static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * @name 判断 string 类型是否为空
	 * @description 判断 string 类型是否为空，是则返回 true ，否则返回 false
	 * @return
	 */
	public static boolean isNullOrEmpty(String text) {

		return text == null || text.isEmpty() || text.equals("null") || "".equals(text.trim());
	}



	public static Boolean isNotNullOrEmpty(String str) {
		return !isNullOrEmpty(str);
	}


	/**
	 * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
	 *
	 * @param request
	 * @return
	 */
	public final static String getIpAddress(HttpServletRequest request) {
		// 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		} else if (ip.length() > 15) {
			String[] ips = ip.split(",");
			for (int index = 0; index < ips.length; index++) {
				String strIp = ips[index];
				if (!("unknown".equalsIgnoreCase(strIp))) {
					ip = strIp;
					break;
				}
			}
		}
		return ip;
	}

}
