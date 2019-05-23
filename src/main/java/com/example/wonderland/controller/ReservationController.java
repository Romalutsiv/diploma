package com.example.wonderland.controller;

import com.example.wonderland.domain.ReservMessage;
import com.example.wonderland.repos.RevMesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Controller
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    RevMesRepo revMesRepo;

    @GetMapping
    public String main(){

        return "reservation";
    }

//    @PostMapping
//    public String add(){
//
//        return "redirect:/menu";
//    }

    @PostMapping("/add")
    public String addMessage(
            @RequestParam("firstname") String firstname,
            @RequestParam("secondname") String secondname,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam("message") String message,
            @RequestParam("date") String dateTime
            ){
        ReservMessage reservMessage = new ReservMessage(firstname, secondname, phone, email, message);

        reservMessage.setDate(dateTime.replace("T"," "));
        revMesRepo.save(reservMessage);
        return "thank";
    }


}
