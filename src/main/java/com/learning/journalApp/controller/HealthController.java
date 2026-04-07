package com.learning.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health-Check")
    public String healthCheck(){
        return "ok";
    }
}
