package com.personal.dashboard.utils;

import javax.servlet.http.HttpServletRequest;


public class GenerateIp {

	public static String getClientIP(HttpServletRequest request) {

		String xfHeader = request.getHeader("X-Forwarded-For");

		if (xfHeader == null)
			return request.getRemoteAddr();

		return xfHeader.split(",")[0];
	}
}