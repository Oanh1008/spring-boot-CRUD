package com.example;

import com.example.repository.StudentRepository;
import org.hibernate.engine.transaction.jta.platform.internal.JRun4JtaPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudStudentYtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudStudentYtApplication.class, args);
	}


}
