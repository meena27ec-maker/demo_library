package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.student;
import com.example.demo.repository.studentrepo;

@Controller
public class registerapplication {

    @Autowired
    private studentrepo studentRepo;

    @GetMapping("/signup")
    public String signupPage() {
        return "forward:/register.html";
    }

    @PostMapping("/signup")
    public String registerStudent(
            @RequestParam String studentname,
            @RequestParam String password,
            @RequestParam String course,
            @RequestParam int fee) {

        student s = new student();

        s.setStudentname(studentname);
        s.setPassword(password);
        s.setCourse(course);
        s.setFee(fee);

        studentRepo.save(s);//method used instead of insert

        return "redirect:/signup";
    }
}