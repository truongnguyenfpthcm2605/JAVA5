package com.poly.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poly.app.enity.Categories;
import com.poly.app.service.CategoriesService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("category")
public class CategoriesController {
	@Autowired
	CategoriesService categoriesService;
	@GetMapping("view")
	public String view(Model model,RedirectAttributes redirectAttributes) {
		model.addAttribute("Cartegories", new Categories());
		return "categoryManager";
	}
	
	@PostMapping("create")
	public String create(@Valid @ModelAttribute("Cartegories") Optional<Categories> category,
			BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("message","Nhập đủ thông tin !");
		}else {
			categoriesService.save(category.get());
			return "redirect:/category/view";
		}
		return "categoryManager";
		
	}
	@GetMapping("/edit/{id}")
	public String eidt(@PathVariable("id") String id, Model model) {
		Categories category = categoriesService.findById(id).get();
		if(category!=null) {
			model.addAttribute("Cartegories", category);
		}
		return "categoryManager";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id, Model model) {
		if(categoriesService.findById(id)!=null) {
			model.addAttribute("messages", "Không thể xóa dữ liệu này");
		}
		model.addAttribute("Cartegories", new Categories());
		return "categoryManager";
	}
	
	@GetMapping("reset")
	public String reset() {
		return "redirect:/category/view";
	}
	
	
	@ModelAttribute("ListCategories")
	public List<Categories> getLCategories(){
		return categoriesService.findAll();
	}
}
