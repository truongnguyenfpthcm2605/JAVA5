package com.poly.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
		@GetMapping("home/index")
		public String index() {
			return "index";
		}
		@GetMapping("home/about")
		public String about() {
			return "index";
		}
		@GetMapping("assets")
		public String asest() {
			return "index";
		}
}
