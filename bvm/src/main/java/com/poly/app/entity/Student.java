package com.poly.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Student {
	@Id
	@NotEmpty(message = "Không được bỏ trống id")
	private String id;
	@NotEmpty(message = "Không được bỏ trống mật khẩu")
	private String password;
	@NotEmpty(message = "Không được bỏ trống họ va tên")
	private String fullname;
	@Email(message = "Email sai định dạng")
	private String email;
	@NotNull(message = "Không được bỏ trống role")
	private Boolean admin;

}
