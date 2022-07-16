package com.example.controller;


import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // handler method to handle list students and return model and view
    @GetMapping("/students")
    public String listStudents(Model model,
                               @RequestParam(name = "text",defaultValue = "") String text) {
        List<Student> students = studentService.getAllStudents();
        if(!text.isEmpty()){
            students = studentService.getAllStudents()
                          .stream()
                          .filter(st -> st.getFirstName().toLowerCase().contains(text))
                         .collect(Collectors.toList());
        }
        model.addAttribute("students",students);
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        // create student to hold student from data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") Student student , BindingResult binding, Model model) {
        if(binding.hasErrors()){
            return "redirect:/students/new";
        }
        studentService.saveStudent(student);
        model.addAttribute("student",student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

        // Get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        // save it
        studentService.saveStudent(existingStudent);

        return "redirect:/students";
    }
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable  Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
