package com.example.demo1.controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo1.model.Student;


@Controller
public class HomeController
{
    @GetMapping("/home")
    public String index(Model model)
    {
        return "index";
    }

    @GetMapping("/demo")
    public String demoPage( Model model) 
    {
        Student student = new Student(1, "Nguyen Van A");
        model.addAttribute("student",student);
        model.addAttribute("message","Welcome Thymleaf");
        return "demo";
    }
    
}