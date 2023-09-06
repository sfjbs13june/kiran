package com.kiran.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/getstudent")
    public String getStudentDetail() {
        return "student1";
    }
    @GetMapping("/updatestudent")
    public String updateStudentDetail() {
        return "Updated student1";
    }

    @GetMapping("/deletestudent")
    public String deleteStudentDetail() {
        return "student1 deleted";
    }
}
