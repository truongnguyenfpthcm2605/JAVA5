package com.poly.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("home")
	private String index() {
		return "layout/index";
	}
	
	@GetMapping("layout/samsung")
		private String Samsung() {
			return "body/samsung";
		}
	
		@GetMapping("layout/apple")
		private String Apple() {
			return "body/Apple";
		}
}
