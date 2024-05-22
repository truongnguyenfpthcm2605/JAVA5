package com.poly.app.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	private String usersname;
	private String password;
	private boolean checked;

	
	
}
