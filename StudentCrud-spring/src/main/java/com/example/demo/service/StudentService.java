package com.example.demo.service;

import com.example.demo.modal.Student;
import com.example.demo.studentRepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(String name) {
        return studentRepository.findByName(name);
    }
    public Student getDetailsById(Long id){
        return studentRepository.findById(id).get();
    }
    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudentById(Long id, Student student) {
        Student updateStudent = studentRepository.findById(id).get();
        updateStudent.setName(student.getName());
        updateStudent.setEmail(student.getEmail());
        updateStudent.setDob(student.getDob());
        updateStudent.setAge(student.getAge());
        return studentRepository.save(updateStudent);
    }
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

}
