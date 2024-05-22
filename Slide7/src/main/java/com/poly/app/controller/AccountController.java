package com.poly.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.app.enity.Account;
import com.poly.app.impl.AccountServiceImpl;
import com.poly.app.service.SessionSevice;

@Controller
public class AccountController {
	@Autowired
	AccountServiceImpl accountServiceImpl;

	@Autowired
	SessionSevice sessionSevice;
	
	@GetMapping("admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("home")
	public String home() {
		return "home";
	}
	
	@GetMapping("account/login")
	public String login() {
		return "login";
	}

	@PostMapping("account/login")
	public String login(Model model,
			@RequestParam("usersname") String username,
			@RequestParam("password") String password) {
		try {
			Account user = accountServiceImpl.findByUsername(username);
			if(!user.getPassword().equals(password)) {
				model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
			}else {
				String uri = sessionSevice.getAttribute("security-uri");
				sessionSevice.setAttribute("user",user);
				if(uri!=null) {
					return "redirect:"+uri;
				}else {
					model.addAttribute("error", "Đăng nhập thành công");
				}
			}
		} catch (Exception e) {
			model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
		}
		return "login";
	}
	
	
	
}
