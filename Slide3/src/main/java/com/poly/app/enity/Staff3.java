package com.poly.app.enity;

import java.util.List;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class Staff3 {
	@NotNull
	@Positive(message = "id phải là số nguyên dương")
	@Digits(integer = 10, fraction = 0, message = "id phải là một số nguyên dương")
		public Integer id;
	@NotBlank
		public String fullname;
	@NotNull(message = "Không được bỏ trống gender")
		public Boolean gender;
	@NotEmpty
	@Email(message = "Chưa đúng định dạng email")
		public String email;
	@NotNull(message = "Không được bỏ trống salary")
	@Min(value = 1000, message = "Salary phải lớn hơn 1000")
		public Double salary;
	@NotEmpty(message = "Không được bỏ trống position")
		public String position;
	@NotEmpty(message = "Không được bỏ trống hobbies")
		public List<String> hobbies;
}
