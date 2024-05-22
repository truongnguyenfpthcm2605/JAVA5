package com.poly.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.app.enity.Product;

@Controller
public class ProductsController {
	List<Product> list = new ArrayList<>();
	
	@GetMapping("/products")
	public String products(Model model) {
		Product p = new Product("Nokia", 1222);
		model.addAttribute("product", p);
		return "products";	
	}
	
	@PostMapping("/products")
	public String save(@ModelAttribute("products") Product p) {
		
			 list.add(p);
		  return "redirect:/products";
		   
     //   return "redirect:/error";
    }
	
	@ModelAttribute("list")
    public List<Product> getItems() {
        return list;
    }
	
	
}
