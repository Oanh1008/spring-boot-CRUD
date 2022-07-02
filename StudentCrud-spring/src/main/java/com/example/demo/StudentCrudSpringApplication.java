package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

@SpringBootApplication
public class StudentCrudSpringApplication  {

    public static void main(String[] args)  {
        SpringApplication.run(StudentCrudSpringApplication.class, args);
    }




}
