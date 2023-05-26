package com.example.demo.student.repo;


import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.student.model.Student;

@EnableJpaRepositories
public interface StudentRepo extends JpaRepository<Student, Integer> {
	List<Student> findAllStudent(Pageable pageable);
}
