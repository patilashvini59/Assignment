package com.example.demo.teacher.model.service;

import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderData {
	@Bean
    public PasswordEncoderData passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public String encode(String passWord) {
        // TODO Auto-generated method stub
        return null;
    }
}
