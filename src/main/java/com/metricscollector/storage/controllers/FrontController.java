package com.metricscollector.storage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {
    @GetMapping("/")
    public String get() {
        return "redirect:/swagger-ui.html";
    }
}
