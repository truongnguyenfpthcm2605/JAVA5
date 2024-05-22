package com.poly.app.enity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
@Entity
@Table(name = "categories")
public class Categories implements Serializable {
	@Id
	@NotEmpty(message = "Không bỏ trống categoriesId")
	@Column(columnDefinition = "char(4)")
	private String id;
	@NotEmpty(message = "Không bỏ trống name")
	private String name;
	@OneToMany(mappedBy = "category")
    private List<Product> products;
}
