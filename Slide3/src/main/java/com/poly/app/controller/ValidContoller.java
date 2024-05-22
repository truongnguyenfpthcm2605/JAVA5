package com.poly.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.app.enity.Staff3;

import jakarta.validation.Valid;

@Controller
public class ValidContoller {
		
		@GetMapping("/valid")
		public String valid(Model model) {
			Staff3 staff = new Staff3();
			model.addAttribute("staff3", staff);
			return "valid";
			
		}
		@PostMapping("/valid")
		public String save(@Valid @ModelAttribute("staff3") Staff3 staff, BindingResult result) {
		    if(result.hasErrors()) {
		        return "valid";
		    }
		    return "ok";
		}
		@ModelAttribute("hobbies")
		public List<String> getH(){
				return List.of("Trường","Khang","Nam"); 	
		}


}
