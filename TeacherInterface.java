package com.example.demo.teacher.model.service;

import com.example.demo.teacher.model.TeacherInfo;

public interface TeacherInterface {
	
	public String saveData(TeacherInfo teacher);
	public String login(String name,String email);
}
