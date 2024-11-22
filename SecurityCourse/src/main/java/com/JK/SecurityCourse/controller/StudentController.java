package com.JK.SecurityCourse.controller;

import com.JK.SecurityCourse.models.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> studentsList = new ArrayList<>(List.of(
            new Student(1,"Jas", "Kham", 5),
            new Student(2,"Thomas", "Kevin", 4),
            new Student(3,"Harry", "Potter", 2)
    ));

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentsList;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public String createStudent(@RequestBody Student student){
        studentsList.add(student);
        return "Created!";
    }
}
