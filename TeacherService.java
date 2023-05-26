package com.example.demo.teacher.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.teacher.model.TeacherInfo;
import com.example.demo.teacher.model.Exc.TeacherE;
import com.example.demo.teacher.model.Repo.TeacherRepo;

@Service
public class TeacherService implements TeacherInterface{
	
	@Autowired
	private TeacherRepo teacherRepo; 

	@Autowired
    private PasswordEncoderData passwordEncoder;
	
	@Override
	public String saveData(TeacherInfo teacher) {
		String encodedPassword = passwordEncoder.encode(teacher.getPassword());
        teacher.setPassword(encodedPassword);
		List<TeacherInfo> list = teacherRepo.findAll();
		list.stream().forEach(p->{
			if(p.getEmail().contains(teacher.getEmail())) {
				throw new TeacherE("Teacher is already exist");
			}else {
				teacher.setPassword(encodedPassword);
				teacherRepo.save(teacher);
			}
		});
		return "Save Data Sucessfully";
	}

	@Override
	public String login(String name, String email) {
		String response="Invalid Credentials";
		 TeacherInfo data = teacherRepo.findByNameAndEmail(name, email);
		 if(data==null) {
			 throw new TeacherE("Invalid Credentials");
		 }else {
			 response = "Login Sucessfully";
		 }
		return response;
	}
}
