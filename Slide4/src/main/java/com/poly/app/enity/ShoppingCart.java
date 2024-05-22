package com.poly.app.enity;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Data
@SessionScope
@Service("cart")
public class ShoppingCart {
	private String id;
}
