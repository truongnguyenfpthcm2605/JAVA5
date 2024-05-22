package com.poly.app.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
		public Integer id;
		public String name;
		public String img;
		public double price;
		
		
}
