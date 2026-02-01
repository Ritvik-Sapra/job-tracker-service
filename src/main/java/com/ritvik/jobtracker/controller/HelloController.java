package com.ritvik.jobtracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String home() {
        return "Job Tracker backend is alive 🚀 and CI/CD implemented" ;
    }
}