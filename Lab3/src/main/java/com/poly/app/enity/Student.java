package com.poly.app.enity;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Student {
	@NotBlank
	String name;
	@NotBlank
	@Email
	String email;
	@NotNull
	@Min(0)
	@Max(10)
	Double marks;
	@NotNull
	Boolean gender;
	@NotBlank
	String faculty;
	@NotEmpty
	List<String> hobbies;
}
