package com.poly.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.app.enity.Product;
import com.poly.app.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	private static final Integer pageSize = 8;
	
	@GetMapping("view")
	public String view(Model model) {
		model.addAttribute("page", getPage(0));
		return "product";
	}
	

	@GetMapping("/sort")
	public String sort(@RequestParam("field") Optional<String> field, Model model, @RequestParam("p") Optional<Integer> p) {
	    Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
	    Pageable pageable = PageRequest.of(p.orElse(0),pageSize,sort); 
	    Page<Product> page = productService.findAllPage(pageable);
	    model.addAttribute("page", page);
	    return "product";
	}
	
	@GetMapping("/page")
	public String Page(Model model,@RequestParam("p") Optional<Integer> p) {
		model.addAttribute("page", getPage(p.orElse(0)));
		return "product";
		
	}
	
	public Page<Product> getPage(Integer number){
		Pageable pageable = PageRequest.of(number, pageSize);
		Page<Product> page = productService.findAllPage(pageable);
		return page;
	}
	
	
	
	
	
	
	
	
	
//	@GetMapping("/sort")
//	public String sort(@RequestParam("field") Optional<String> field, Model model) {
//		Sort sort = Sort.by(Direction.DESC,field.orElse("price"));
//		List<Product> list = productService.findAllSort(sort);
//		model.addAttribute("page", list);
//		return "product";
//	}
//	
}
