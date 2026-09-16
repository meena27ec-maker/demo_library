package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.student;
import com.example.demo.repository.studentrepo;

@Controller
public class logincontroller {

    @Autowired
    private studentrepo studentRepo;

    @GetMapping("/signin")
    public String signinPage() {
        return "forward:/login.html";
    }

    @PostMapping("/signin")
    public String loginStudent(
            @RequestParam String studentname,
            @RequestParam String password) {

        student s = studentRepo.findByStudentnameAndPassword(
                studentname, password);

        if (s != null) {
            return "redirect:/dashboard.html";
        } else {
            return "redirect:/login.html";
        }
    }
}