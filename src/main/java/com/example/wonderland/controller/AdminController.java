package com.example.wonderland.controller;

import com.example.wonderland.domain.ReservMessage;
import com.example.wonderland.repos.RevMesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    RevMesRepo revMesRepo;
    @GetMapping("/createpost")
    public String createPost(){
        return "createpost";
    }

    @GetMapping("/createdish")
    public String createDish(){
        return "createdish";
    }

    @GetMapping("/createreport")
    public String createReport(){return "createphotorep";}

    @GetMapping("/messages")
    public String messages(Model model, @PageableDefault(sort = { "id"}, direction = Sort.Direction.DESC) Pageable pageable){
        Page<ReservMessage> messages = revMesRepo.findAll(pageable);
        model.addAttribute("messages" , messages);
        model.addAttribute("url", "/messages");
        return "messages";
    }

    @GetMapping("/messages/{message}")
    public String oneMessage(
            @PathVariable ReservMessage message,
            Model model
    ){
        message.unActive();
        revMesRepo.save(message);
        model.addAttribute("message", message);
        return "message";
    }
}
