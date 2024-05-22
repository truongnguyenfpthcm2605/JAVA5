package com.poly.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.app.service.CookieService;
import com.poly.app.service.ParamService;
import com.poly.app.service.SessionSevice;

import jakarta.servlet.http.Cookie;

@Controller
@RequestMapping("account")
public class AccountController {
	
			@Autowired
			CookieService cookie;
			@Autowired
			ParamService param;
			@Autowired
			SessionSevice session;
			
			
			@GetMapping("login")
			public String login(Model model) {
				Cookie cookies = cookie.get("username");
				if(cookies!=null) {
					model.addAttribute("username", cookies.getValue());
					model.addAttribute("password", "123");
				}
				return "login";
			}
			
			@PostMapping("login")
			public String submit(Model model, 
					@RequestParam("usersname") String user,
					@RequestParam("password") String pass,
					@RequestParam(name = "remember", required  = false) Boolean remember) {
				String us = param.getString(user, "None");	
				String pw = param.getString(pass, "None");
				  boolean rememberMe = remember != null ? remember : false;
				if(us.equalsIgnoreCase("poly") && pw.equalsIgnoreCase("123")) {
					session.setAttribute("username", us);
					model.addAttribute("message", "Đăng Nhập Thành Công");
	
					if(rememberMe) {
						cookie.add("username", us, 10);
					}else {
						cookie.remove(us);
					}
				}else {
					model.addAttribute("message", "Đăng Nhập Thất Bại");
				}
				return "login";
			}
			
			
}
