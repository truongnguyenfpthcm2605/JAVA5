package com.poly.app.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.app.Impl.ProductServiceImpl;
import com.poly.app.Impl.ShoppingCartServiceImpl;
import com.poly.app.Impl.VoucherServiceImpl;
import com.poly.app.dto.CartItem;
import com.poly.app.enity.Product;
import com.poly.app.enity.Voucher;
import com.poly.app.service.SessionSevice;
import com.poly.app.util.Keyword;
import java.util.Date;

@Controller
@RequestMapping("cart")
public class Cartcontroller {

	@Autowired
	ShoppingCartServiceImpl shoppingCartServiceImpl;

	@Autowired
	ProductServiceImpl productServiceImpl;

	@Autowired
	VoucherServiceImpl voucherServiceImpl;

	@Autowired
	SessionSevice sessionSevice;

	private double discout = 1;

	@GetMapping("views")
	private String getAllCart(Model model) {
		List<CartItem> getCarts = shoppingCartServiceImpl.getAllCartItem();
		model.addAttribute("cart", getCarts);
		return "cart";
	}

	@GetMapping("add/{id}")
	@ResponseBody
	private ResponseEntity<String> addCart(@PathVariable("id") Optional<Integer> id) {
		Product p = productServiceImpl.findById(id.orElse(1)).get();
		if (p != null) {
			getCartItem(p);
		}
		return ResponseEntity.ok("Đã thêm sản phẩm vào giỏ hàng");
	}

	@GetMapping("viewcart/{id}")
	private String viewsCart(@PathVariable("id") Optional<Integer> id) {
		Product p = productServiceImpl.findById(id.orElse(1)).get();
		if (p != null) {
			getCartItem(p);
		}
		return "redirect:/cart/views";
	}

	@PostMapping("update")
	public String update(@RequestParam("id") Optional<Integer> id, @RequestParam("qty") Optional<Integer> qty) {
		if (qty.get() == 0) {
			shoppingCartServiceImpl.remove(id.get());
		} else {
			shoppingCartServiceImpl.update(id.orElse(1), qty.orElse(1));
		}
		return "redirect:/cart/views";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		shoppingCartServiceImpl.remove(id);
		return "redirect:/cart/views";
	}

	@GetMapping("reset")
	private String reset() {
		shoppingCartServiceImpl.clear();
		return "redirect:/cart/views";
	}

	@PostMapping("voucher")
	public String voucher(Model model, @RequestParam("voucher") Optional<String> keyVoucher) {
		Voucher voucher = null;
		try {
			 voucher = voucherServiceImpl.findByVoucher(keyVoucher.orElse("None"), new Date(), true).get();
		} catch (Exception e) {
		}
		if (voucher != null) {
			discout = voucher.getDiscount();
			sessionSevice.setAttribute(Keyword.voucher, voucher);
			model.addAttribute("valueVoucher", voucher.getId());
		} else {
			sessionSevice.removeAttribute(Keyword.voucher);
		}
		return "redirect:/cart/views";
	}

	@ModelAttribute("numberCartItem")
	public int getnumberCartItem() {
		return shoppingCartServiceImpl.getCount() != 0 ? shoppingCartServiceImpl.getCount() : 0;
	}

	@ModelAttribute("discount")
	private Double getDiscount() {
		return shoppingCartServiceImpl.getTotal()*(discout/100);
	}

	@ModelAttribute("total")
	private Double getTotal() {
		return shoppingCartServiceImpl.getTotal();
	}

	@ModelAttribute("totalProduct")
	private Double geTotalProduct() {
		if (discout > 1) {
			double root = shoppingCartServiceImpl.getTotal();
			double dis = root * (discout / 100);
			return root - dis;
		}
		return shoppingCartServiceImpl.getTotal();
	}

	private CartItem getCartItem(Product p) {
		CartItem cart = new CartItem();
		cart.setId(p.getId());
		cart.setName(p.getTitle());
		cart.setImg(p.getImgproduct());
		cart.setPrice(p.getPrice());
		cart.setQty(1);
		shoppingCartServiceImpl.add(cart);
		return cart;
	}
}
