package com.example.demo.controller;

import com.example.demo.service.StudentService;
import com.example.demo.modal.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping() // show data
    public HttpEntity<List<Student>> getStudents(@RequestParam(value = "name",required = false) String name) {
        return new HttpEntity<>(studentService.getStudents(name));
    }

    @GetMapping("/{id}") // show data
    public HttpEntity<Student> getStudents(@PathVariable Long id) {
        return new HttpEntity<>(studentService.getDetailsById(id));
    }

    @PostMapping // tạo mới// delete,put-mapping
    public HttpEntity<Student> registerStudent(@RequestBody Student student) {
        return new HttpEntity<>(studentService.addNewStudent(student));
    }

    @PutMapping("/{id}") // thay đổi
    public HttpEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        return new HttpEntity<>(studentService.updateStudentById(id,student));
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }


}