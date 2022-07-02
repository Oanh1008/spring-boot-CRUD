package com.example.demo.studentRepository;
import com.example.demo.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {
    @Query(value = "select s from Student s where (:name is null or s.name like %:name%) ")
    public List<Student> findByName(String name);
}
