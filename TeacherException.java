package com.example.demo.teacher.model.Exc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TeacherException {
	
	@ExceptionHandler(value = TeacherE.class)
	public ResponseEntity<Object> teacheExceptionMethod(TeacherE teacher) {
		  return new ResponseEntity<>("Teacher Already Exist",HttpStatus.CONFLICT);
	}

}
