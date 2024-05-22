package com.poly.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieUtil {
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpServletRequest request;
	
	public Cookie create(String name,String value, int days) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(days*60*60);
		cookie.setPath("/");
		return cookie;
	}
	
	public Cookie get(String name) {
		Cookie[] cookie = request.getCookies();
		if(cookie!=null) {
			for (Cookie cookie2 : cookie) {
				if(cookie2.getName().equalsIgnoreCase(name));
				return cookie2;
			}
		}
		return null;
	}
}
