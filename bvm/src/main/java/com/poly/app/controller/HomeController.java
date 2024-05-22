package com.poly.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.poly.app.entity.Student;
import com.poly.app.impl.StudentServiceImpl;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	StudentServiceImpl studentServiceImpl;

	@GetMapping("index")
	private String index(Model model) {
		model.addAttribute("list", studentServiceImpl.findAll());
		return "/page/index";
	}

	@GetMapping("new")
	private String news(Model model) {
		model.addAttribute("student", new Student());
		return  "form";
	}
	@PostMapping("update")
	private String create(@Valid @ModelAttribute("student") Optional<Student> user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("message", "Nhập đầy đủ thông tin");
			return "form";
		} else {
			studentServiceImpl.save(user.get());
			model.addAttribute("user", new Student());
		}
		model.addAttribute("list", studentServiceImpl.findAll());
		return "index";

	}


	@GetMapping("delete/{id}")
	private String delete(@PathVariable("id") Integer idString) {
		studentServiceImpl.deleteById(idString);
		return "redirect:/index";
	}

	@GetMapping("edit/{id}")
	private String edit(@PathVariable("id") Integer idString, Model model ) {
		Student user = studentServiceImpl.findByid(idString).get();
		model.addAttribute("student", user);
		return "form";
	}


	@PostMapping("search")
	private String reset(Model model , @RequestParam("search") Optional<String> key) {
		String keywords = key.orElse("");
		List<Student> list = studentServiceImpl.findByHotenLike("%"+keywords+"%");
		model.addAttribute("user", new Student());
		model.addAttribute("search",keywords);
		model.addAttribute("list",list);
		return "index";
	}
}
