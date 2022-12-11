package com.employees.employees.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employees.employees.service.AwsS3Service;
@RestController
public class DocumentControll {
	
	@Autowired
	AwsS3Service s3Service;
	
	@PostMapping("upload")
	public String uploadFile(@RequestParam("fileName") String fileName, @RequestBody MultipartFile file ) {		
		String fileNameUrl = s3Service.uploadFileContentAsFile(fileName, file);
		return fileNameUrl;
	}
}
