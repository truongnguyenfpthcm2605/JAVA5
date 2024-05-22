
package com.poly.app.model;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtils {
	// tao va lưu cookie trên client
	public  void add(String name,String pass,int hours,HttpServletResponse resp) {
		Cookie usernameCookie = new Cookie("username", name);
		usernameCookie.setMaxAge(hours*60*60);
		resp.addCookie(usernameCookie);

		Cookie passwordCookie = new Cookie("password",pass );
		passwordCookie.setMaxAge(hours*60*60);
		resp.addCookie(passwordCookie);

		
	}
	// lay  gia tri cookie gui ve client
	public  Cookie get(String name, HttpServletRequest req) {
		Cookie[] cookie = req.getCookies();
		if(cookie!=null) {
			for(Cookie c : cookie) {
				if(c.getName().equalsIgnoreCase(name)) {
					return c;
				}
			}
		}
		return null;
	}




}
