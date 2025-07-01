package com.stdlib.StudentLib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/student")
    public String studentForm() {
        return "student";
    }

    @GetMapping("/admin")
    public String adminHome() {
        return "admin";
    }
}

