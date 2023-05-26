package com.example.demo.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.student.model.Student;
import com.example.demo.student.repo.StudentRepo;
import com.example.demo.teacher.model.Exc.TeacherE;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	public String saveData(Student student) {
		List<Student> list = studentRepo.findAll();
		list.stream().forEach(p -> {
			if (p.getRollNo() == student.getRollNo()) {
				throw new TeacherE("student already exist");
			} else {
				studentRepo.save(student);
			}
		});
				return "Sucessfully Save";

	}


	public Student getStudentById(Integer id) {
		return studentRepo.findById(id).get();
	}

	public Page<Student> getStudentWithPagination(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Student> student = studentRepo.findAll(pageable);
		return student;
	}

}
