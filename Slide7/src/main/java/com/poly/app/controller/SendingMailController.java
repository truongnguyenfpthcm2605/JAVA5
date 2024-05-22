package com.poly.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.poly.app.dto.MailModel;
import com.poly.app.impl.MailerServiceImpl;
import com.poly.app.service.ParamService;

import jakarta.mail.MessagingException;
import jakarta.servlet.ServletContext;
@Controller
@RequestMapping("mail")
public class SendingMailController {
	
	@Autowired
	MailerServiceImpl mailerServiceImpl;

	@Autowired
	ServletContext app;
	
	@Autowired
	ParamService paramService;
	
	@GetMapping("demo")
	@ResponseBody
	public ResponseEntity<String> demo(Model model) {
		for (int i = 0; i < 10; i++) {
			try {
				mailerServiceImpl.queue("truongnvps24083@fpt.edu.vn", "Subject", "Xin Chào");
				
			} catch (Exception e) {
				e.printStackTrace();
				return  new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<>("Xong 10 Mail", HttpStatus.OK);
	}
	
	
	@GetMapping("send")
	public String send() {
		return "sendmail";
	}
	
	@PostMapping("send")
	public String sendSuccess(Model model,
			@RequestParam("to") String to,
			@RequestParam("cc") String[] cc,
			@RequestParam("bcc") String[] bcc,
			@RequestParam("subject") String subject,
			@RequestParam("body") String content,
			@RequestParam("files") MultipartFile[] flies
			) throws MessagingException, IllegalStateException, IOException {
	
		List<File> listFiles = paramService.saveFiles(flies, "images");
		MailModel mail = new MailModel();
		mail.setTo(to);
		mail.setCc(cc);
		mail.setBcc(bcc);
		mail.setSubject(subject);
		mail.setFiles(listFiles);
		mail.setBody(content+"<p>\r\n"
				+ "               <br> <h5>Email: HtMobile@gmail.com</h5> \r\n"
				+ "                <h5>Phone : 0999999</h5>\r\n"
				+ "               \r\n"
				+ "            </p>");
		
		mailerServiceImpl.queue(mail);
		model.addAttribute("message", "Success");
		return "sendmail";
	}
	

	
}
