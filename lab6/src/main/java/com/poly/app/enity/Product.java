package com.poly.app.enity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "products", uniqueConstraints = { @UniqueConstraint(columnNames = { "categoryid" }) })
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "Không bỏ trống name")
	private String name;
	@NotEmpty(message = "Không bỏ trống image")
	private String image;
	@NotEmpty(message = "Không bỏ trống price")
	@Min(value = 0, message = "Phải nhập price lớn hơn 0")
	private Double price;
	@Temporal(TemporalType.DATE)
	private Date createdate = new Date();
	private Boolean active;
	@ManyToOne
	@JoinColumn(name = "categoryid", referencedColumnName = "id")
	private Categories category;
	
	@OneToMany(mappedBy = "product")
	private List<OrderDetails> orderDetails;

}
