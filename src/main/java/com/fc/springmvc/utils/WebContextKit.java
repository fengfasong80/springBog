package com.fc.springmvc.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;

public class WebContextKit {

	/**
	 * 向前端浏览器返回json数据
	 * @param response
	 * @param result
	 * @throws IOException
	 */
	public static void renderJson(HttpServletResponse response, Object result) throws IOException {
		PrintWriter writer = null;
		try {
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("application/json; charset=UTF-8");
			writer = response.getWriter();
			if (result != null && String.class.equals(result.getClass())) {
				writer.write((String)result);
			} else {
				writer.write(JSON.toJSONString(result));
			}
		} catch (IOException e) {
			throw e;
		}
		finally {
			writer.flush();
			writer.close();
		}
	}
	
	private static void doSetCookie(HttpServletResponse response, String name, String value, int maxAgeInSeconds, String path, String domain, Boolean isHttpOnly) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAgeInSeconds);
		if (path == null) {
			path = "/";
		}
		cookie.setPath(path);
		
		if (domain != null) {
			cookie.setDomain(domain);
		}
		if (isHttpOnly != null) {
			cookie.setHttpOnly(isHttpOnly);
		}
		response.addCookie(cookie);
	}
	
	public  static void setCookie(HttpServletResponse response, String name, String value, int maxAgeInSeconds, boolean isHttpOnly) {
		doSetCookie(response, name, value, maxAgeInSeconds, null, null, isHttpOnly);
	}
	
	public static String getCookie(HttpServletRequest request, String name) {
		return getCookie(request, name, null);
	}
	
	public static String getCookie(HttpServletRequest request, String name, String defaultValue) {
		Cookie cookie = getCookieObject(request, name);
		return cookie != null ? cookie.getValue() : defaultValue;
	}
	
	public static Cookie getCookieObject(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equals(name))
					return cookie;
		return null;
	}
}
