package com.poly.app.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
	public String id;
	public String fullname;
	public String email;
	public Double salary;
	public Boolean gender;
	public String postion;
	
	
	
}
