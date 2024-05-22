package com.poly.app.enity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Data
@Entity
@Table(name = "accounts")
public class Account implements Serializable {
	@Id
	@NotEmpty(message = "Không bỏ trống Username")
	private String username;
	@NotEmpty(message = "Không bỏ trống password")
	private String password;
	@NotEmpty(message = "Không bỏ trống Fullname")
	private String fullname;
	@NotEmpty(message = "Không bỏ trống Email")
	@Email
	private String email;
	private String photo ;
	private Boolean active;
	private Boolean admin;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private List<Orders> orders;
}
