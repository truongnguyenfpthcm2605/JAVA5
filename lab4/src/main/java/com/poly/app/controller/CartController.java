package com.poly.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.app.dto.CartItem;
import com.poly.app.enity.Product;
import com.poly.app.service.ProductService;
import com.poly.app.service.ShoppingCartService;

import jakarta.annotation.PostConstruct;


@Controller
@RequestMapping("cart")
public class CartController {
	 	@Autowired
	    public ShoppingCartService cartService;

	    @Autowired
	    public ProductService prService;
	    
	    
		@ModelAttribute("list")
		public List<Product> getLiProducts() {
			return  prService.getAllProduct();
		}
	
		@ModelAttribute("listCart")
		public List<CartItem> getListCarts() {
				return cartService.getAllCartItem();
		}
		
		@ModelAttribute("total")
		public Double getTotal() {
				return cartService.getTotal();
		}
	
		@GetMapping("view")
		public String view(Model model) {
			return "home";
		}
	
		@GetMapping("viewcart")
		public String viewCart(Model model) {
			return "cart";
		}
		
		@GetMapping("/add/{id}")
		public String addCart(@PathVariable("id") Integer id) {
			Product p = prService.getByProduct(id);
			if(p!=null) {
				CartItem cart = new CartItem();
				cart.setId(p.getId());
				cart.setName(p.getName());
				cart.setPrice(p.getPrice());
				cart.setQty(1);
				cartService.add(cart);
			}
			return "redirect:/cart/viewcart";
		}
		@PostMapping("/update/{id}")
		public String update(@PathVariable("id") Integer id,@RequestParam("qty") int qty) {
			cartService.update(id, qty);
			return "redirect:/cart/viewcart";
		}
		
		@GetMapping("reset")
		public String reset() {
			cartService.clear();
			return "redirect:/cart/viewcart";
		}
		
		@GetMapping("delete/{id}")
		public String delete(@PathVariable("id") Integer id) {
			cartService.remove(id);
			return "redirect:/cart/viewcart";
		}
}
