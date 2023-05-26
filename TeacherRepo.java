package com.example.demo.teacher.model.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.teacher.model.TeacherInfo;

@EnableJpaRepositories
public interface TeacherRepo extends JpaRepository<TeacherInfo,Integer>{
	
	public TeacherInfo findByNameAndEmail(String name,String email);

}
