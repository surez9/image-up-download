package com.simplysoft.jpa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.simplysoft.jpa.model.Student;
import com.simplysoft.jpa.service.ImportService;

@RestController
public class ImportController {

	@Autowired
	private ImportService iservice;
	
//	@GetMapping("/index")
//	public String openPage(){
//		return "index";
//	}
//	
	
	
	@PostMapping("/uploadFile")
	public void uploadDetail(@RequestParam("file") MultipartFile file) {
		iservice.saveDetail(file);

	}
	
	@GetMapping("/getData")
	public List<Student> getAllStudent(){
		return iservice.getAllStudent();
	}
	
}
