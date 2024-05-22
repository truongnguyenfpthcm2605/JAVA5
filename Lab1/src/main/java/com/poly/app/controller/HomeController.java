package com.poly.app.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.app.model.Users;
import com.poly.app.model.CookieUtils;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse respone;
	@Autowired
	ServletContext app;

	CookieUtils cookie = new CookieUtils();

	
	@GetMapping("/index")
	public String index(Model model) {
		Cookie UsernameCookie = cookie.get("username", request);
		Cookie PasswordCookie = cookie.get("password", request);
		if(UsernameCookie!=null && PasswordCookie!=null) {
			model.addAttribute("user", UsernameCookie.getValue());
			model.addAttribute("pass",PasswordCookie.getValue());
		}
		return "index";
	}
	
	@PostMapping("/login")
	public String login(Model model) {
		Users newUs = new Users();
		try {
			BeanUtils.populate(newUs, request.getParameterMap());
			if(newUs.isChecked()) {
				cookie.add(newUs.getUsersname(), newUs.getPassword(), 1, respone);
			}else {
				cookie.add(newUs.getUsersname(), newUs.getPassword(), 0, respone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("account", newUs);
		return "result";
	}
}
