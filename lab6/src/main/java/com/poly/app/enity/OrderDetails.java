package com.poly.app.enity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "orderdetails", uniqueConstraints = { @UniqueConstraint(columnNames = { "orderid","productid" }) 
})
public class OrderDetails  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	@NotEmpty(message = "Không bỏ trống price")
	@Min(value = 0, message = "Phải nhập price lớn hơn 0")
		private Double price;
	@NotEmpty(message = "Không bỏ trống qunity")
	@Min(value = 0, message = "Phải nhập quanity lớn hơn 0")
	@Max(value = 10, message = "Phải nhập quanity lớn hơn 10")
		private Integer quanity;
		
		@ManyToOne @JoinColumn(name = "orderid", referencedColumnName = "id")
		private Orders orders;
		
		@ManyToOne @JoinColumn(name = "productid", referencedColumnName = "id")
		private Product product;
}
