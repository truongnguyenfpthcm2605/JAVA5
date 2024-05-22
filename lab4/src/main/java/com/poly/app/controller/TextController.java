package com.poly.app.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.poly.app.service.ParamService;

@Controller
public class TextController {
	@Autowired
	ParamService paService;
	@PostMapping("up")
	@ResponseBody
	public String up(@RequestParam("up") MultipartFile file, String folder) {
		
		return paService.save(file,folder)!=null?file.getOriginalFilename():null;
	}
}
