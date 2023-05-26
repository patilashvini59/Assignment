package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages={"com.example.demo.teacher.model.Repo", "com.example.demo.teacher.model","com.example.demo.teacher.model.controller","com.example.demo.teacher.model.service","com.example.demo.model.teacher.Exc"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AssignmemtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmemtApplication.class, args);
	}

}
