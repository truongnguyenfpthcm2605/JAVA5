package com.poly.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.annotation.SessionScope;

import com.poly.app.enity.Apple;
import com.poly.app.enity.Person;
import com.poly.app.enity.ShoppingCart;

@Configuration
public class BeanConfig {
    @Bean
    Apple getApple() {
		Apple a = new Apple();
		a.setIphone("Iphone XS MAX");
		return a;
	}
    
    // primary sẽ ưu tiên thực hiện Bean đầu tiên
    @Primary @Bean 
    Apple getIphone() {
		Apple a = new Apple();
		a.setIphone("Iphone XS ");
		return a;
	}
    
    
    // bean duyệt theo id
    @Bean("id1")
    Person getPerson() {
    	Person p = new Person();
    	p.setName("Truong");
    	return p;
    }
    
    @Bean("id2")
    Person getPerson2() {
    	Person p = new Person();
    	p.setName("Nam");
    	return p;
    }
    
    @SessionScope
    @Bean("cart")
    ShoppingCart getCart() {
    	return new ShoppingCart();
    }
}
