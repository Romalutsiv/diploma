package com.example.wonderland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class StartController {
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "redirect:/posts";
    }
}
