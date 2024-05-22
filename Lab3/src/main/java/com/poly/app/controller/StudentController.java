package com.poly.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.app.enity.Student;

import jakarta.validation.Valid;

@Controller
public class StudentController {
	List<String> hobbies = new ArrayList<>();

	@RequestMapping("/student/form")
	public String form(@ModelAttribute("sv") Student sv) {
		return "form";
	}

	@RequestMapping("/student/save")
	public String save(@Valid @ModelAttribute("sv") Optional<Student> sv,
			BindingResult result,Model model) {
			if(result.hasErrors()) {
				model.addAttribute("message", "Vui lòng Điền thông tin hợp lệ");
			}else {
				model.addAttribute("message", "Thành Công");
			}
		return "form";
	}

	@ModelAttribute("genders")
	public Map<Boolean, String> getGenders() {
		Map<Boolean, String> map = new HashMap<>();
		map.put(true, "Male");
		map.put(false, "Female");
		return map;
	}

	@ModelAttribute("faculties")
	public List<String> getFaculties() {
		return Arrays.asList("CNTT", "DLNHKS", "QTDN");
	}

	@ModelAttribute("hobbies")
	public Map<String, String> getHobbies() {
		Map<String, String> map = new HashMap<>();
		map.put("T", "Travelling");
		map.put("M", "Music");
		map.put("F", "Food");
		map.put("O", "Other");
		return map;
	}

}
