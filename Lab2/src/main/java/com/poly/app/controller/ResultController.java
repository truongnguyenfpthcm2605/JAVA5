package com.poly.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResultController {
		
	
	@RequestMapping("/a")
	public String m1() {
		return "a";
	}
	@RequestMapping("/b")
	public String m2(Model model) {
		model.addAttribute("message", "I come form B");
		return "a";
	}
	
	
	@RequestMapping("/c")
	public String m3(RedirectAttributes param) {
		param.addAttribute("message", "I come from C");
		return  "redirect:/a";
	}
	
	@RequestMapping("/d")
	@ResponseBody
	public String m4() {
		return "I come from d";
	}
}
