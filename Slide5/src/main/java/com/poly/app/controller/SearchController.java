package com.poly.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.app.enity.Product;
import com.poly.app.service.ProductService;

@Controller

public class SearchController {
	
	
	@Autowired
	ProductService productService;
	@GetMapping("view")
	public String view(Model model) {
		model.addAttribute("list", productService.findAll());
		return "Search";
	}
	
	@PostMapping("view")
	public String reSearch(@RequestParam("keywords") Optional<String> key, Model model) {
			Product p =null;
			try {
				 p= productService.findByKeywords(key.get()).get(0);
			} catch (Exception e) {
				model.addAttribute("message", "Không tìm thấy sản phẩm");
			}
		
			if(p!=null) {
				
				List<Product> list = productService.findProductsByPriceRange(p.getPrice()-1000, p.getPrice()+1000);
				model.addAttribute("p", p);
				model.addAttribute("list", list);
			}else {
				model.addAttribute("message", "Không tìm thấy sản phẩm");
			}
		 	return "Search";
	}
}
