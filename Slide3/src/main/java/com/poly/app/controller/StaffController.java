package com.poly.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.app.enity.Country;
import com.poly.app.enity.Staff2;

@Controller
public class StaffController {
		@GetMapping("/staff2/index")
		public String index(Model model) {
			Staff2 staff2 = new Staff2();
			staff2.setPosition("EMP");
			staff2.setHobbies(new String[] {"Travelling"});
			model.addAttribute("staff2", staff2);
			return "datafill";
		}
		@PostMapping("staff2/save")
		public String save(@ModelAttribute("staff2") Staff2 staff2) {
			return "datafill";
		}
		
		@ModelAttribute("hobbies")
		public String[] getHobbies() {
			return new String[] {"Travelling","Mucsic","Reading","Others"};
		}
		
		@ModelAttribute("positions")
		public Map<String, String> getPositions(){
			Map<String, String> map = new HashMap<>();
			map.put("CEO","TruongNguyen");
			map.put("DIR","Director");
			map.put("MAN","Manager");
			map.put("EMP","Employee");
			return map;
		}
		
		@ModelAttribute("nationalities")
		public List<Country> getNationalities(){
			List<Country> list = new ArrayList<>();
			list.add(new Country("VN","Việt Nam"));
			list.add(new Country("USD","America"));
			list.add(new Country("RUS","RUSSIA"));
			return list;
		}
}
