package com.poly.app.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import jakarta.servlet.ServletContext;


@Service
public class UploadFile {
		@Autowired
		ServletContext app;
		public File save(MultipartFile file , String folder) {
			File dir = new File(app.getRealPath(folder));
			if(!dir.exists()) dir.mkdirs();
			try {
				File svaefile = new File(dir,file.getOriginalFilename());
				file.transferTo(svaefile);
				return svaefile;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
}
