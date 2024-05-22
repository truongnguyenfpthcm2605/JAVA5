package com.poly.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/bai1")
public class OkController {
	
		
	@PostMapping("/ok")
	public String ok1(Model model) {
		model.addAttribute("ok", "Ok1");
		return "ok";
	}
	
	@GetMapping("/ok")
	public String ok2(Model model) {
		model.addAttribute("ok", "Ok2");
		return "ok";
	}
	
	@RequestMapping(path = "/ok3", method = RequestMethod.POST)
	public String ok3(Model model,@RequestParam("x") int x ) {
		model.addAttribute("ok", x + "ok3");
		return "ok";
	}
	
	
}
