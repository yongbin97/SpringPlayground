package com.example.springplayground.home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public String healthCheck(){
        return "Hello World!";
    }
}
