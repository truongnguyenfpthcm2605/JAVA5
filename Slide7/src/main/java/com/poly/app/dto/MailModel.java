package com.poly.app.dto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MailModel {
	private String form = "Hello";
	@NotNull(message = "Không bỏ trống to")
	@Email(message = "Email sai định dạng")
	private String to;
	@NotNull(message = "Không bỏ trống Subject")
	private String subject;
	@NotNull(message = "Không bỏ trống body")
	private String body;
	@NotEmpty(message = "Không bỏ trống CC")
	String[] cc ;
	@NotEmpty(message = "Không bỏ trống BCC")
	String[] bcc;
	List<File> files = new ArrayList<>();
	
	public MailModel(String to, String subject, String body) {
		super();
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
	
	
}
