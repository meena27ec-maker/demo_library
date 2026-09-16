package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.student;

public interface studentrepo extends JpaRepository<student, Long> {

    student findByStudentnameAndPassword(String studentname, String password);
}