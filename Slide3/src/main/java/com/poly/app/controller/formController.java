package com.poly.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.app.enity.Staff;

@Controller
public class formController {
	
		@GetMapping("staff/index")
		public String index(Model model) {
			Staff  staff = new Staff();
			staff.setFullname("Nguyen Van Truong");
			staff.setGender(true);
			staff.setPostion("MAN");
			model.addAttribute("staff", staff);
			return "form";
		}
		@PostMapping("staff/save")
		public String save(@ModelAttribute("staff") Staff staff) {
			staff.setFullname(staff.getFullname().toUpperCase());
			System.out.println(staff.toString());
			return "form";
		}
}
