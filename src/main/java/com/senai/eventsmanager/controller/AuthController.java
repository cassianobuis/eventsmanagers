package com.senai.eventsmanager.controller;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @GetMapping
    public int index (){
        return 200;
    }
    @GetMapping("/ping")
    public String index2(){
        return "pong";
    }
    @PostMapping("/nome")
    public String index3(){
        return "cassiano";
    }
}
