package com.poly.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Controller
public class Uploadfile {

	@Autowired
	ServletContext app;
	@GetMapping("/upload")
	public String upload() {
		return "uploadfile";
	}
	
	@PostMapping("/upload")
	public String send(@RequestParam("attack") MultipartFile[] attach, Model model) throws IllegalStateException, IOException {
	    String folderPath = app.getRealPath("/img");
	    StringBuilder str= new StringBuilder();
	    File folder = new File(folderPath);
	    if (!folder.exists()) {
	        folder.mkdir();
	    }
	    List<String> fileNames = new ArrayList<>();
	    for (MultipartFile file : attach) {
	        if (!file.isEmpty()) {
	            String fileName = file.getOriginalFilename();
	            File outputFile = new File(folderPath + File.separator + fileName);
	            file.transferTo(outputFile);
	            fileNames.add(fileName);
	            str.append(fileName);
	        }
	    }
	    System.out.println(str.toString());
	   model.addAttribute("filenames", fileNames);
	    return "success";
	}

}
