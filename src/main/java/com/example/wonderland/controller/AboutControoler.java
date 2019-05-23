package com.example.wonderland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutControoler {
    @GetMapping
    public String main(){

        return "about";
    }
}
