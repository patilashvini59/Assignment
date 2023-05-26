package com.example.demo.student.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.model.Student;
import com.example.demo.student.service.StudentService;
import com.example.demo.teacher.model.Exc.TeacherE;

@RestController
public class StudentController {

	private StudentService studentService;

	@PostMapping("/student")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<>("Sucessfully", HttpStatus.OK);
	}

	@PutMapping("/student/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		studentService.saveData(student);
		return new ResponseEntity<>("Sucessfully Updated", HttpStatus.OK);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@GetMapping("/student/{page}/{size}")
	public ResponseEntity<Page<Student>> getStudentWithPagination(@PathVariable("page") Integer page,
			@PathVariable("size") Integer size) {
		Page<Student> student = studentService.getStudentWithPagination(page, size);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
}
