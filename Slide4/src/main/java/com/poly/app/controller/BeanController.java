package com.poly.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.app.enity.Apple;
import com.poly.app.enity.Company;
import com.poly.app.enity.Person;
import com.poly.app.enity.Speech;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BeanController {
	@Autowired
	HttpServletRequest request;

	@Autowired
	Company company;

	@Autowired
	Apple a;

	@Autowired
	// xử lý bean bằng id
	@Qualifier("id1")
	Person p;

	@Autowired
	Speech speech;

	@GetMapping("demo1")
	public String demo1() {
		request.setAttribute("Hi", "chào các bạn");
		return "demo1";
	}

	@GetMapping("test")
	@ResponseBody
	public String test() {
		return company.getName();
	}

	@GetMapping("apple")
	@ResponseBody
	public String apple() {
		return a.getIphone();
	}

	@GetMapping("id")
	@ResponseBody
	public String person() {
		return p.getName();
	}

	@GetMapping("say")
	public void SayHello() {
		speech.sayGreeting();
	}

}