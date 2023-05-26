package com.example.demo.teacher.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.teacher.model.TeacherInfo;
import com.example.demo.teacher.model.service.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@PostMapping("/teacher")
	public ResponseEntity<String> saveTeacher(@RequestBody TeacherInfo teacher) {
		teacherService.saveData(teacher);
		return new ResponseEntity<>("Sucessfully", HttpStatus.OK);
	}
	
	//Teacher Login details
	@GetMapping("/login/{userName}/{email}")
	public ResponseEntity<String> saveTeacher(@PathVariable("userName") String userName,@PathVariable("email") String email) {
		String res = teacherService.login(userName,email);
		return new ResponseEntity<>(res,null);
	}

}
