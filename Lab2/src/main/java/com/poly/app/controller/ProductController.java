package com.poly.app.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.app.enity.Product;

@Controller
public class ProductController {
		
	@GetMapping("formProduct")
	public String formProdcut() {
		return "formProduct";
	}
	
	@PostMapping("/formProduct")
	public String save(Model model , @RequestParam("name") String name, @RequestParam("price") double price) {
		Product p = new Product(name, price);
		model.addAttribute("name", p.name);
		model.addAttribute("price", p.price);
		return "formProduct";
	}
}
