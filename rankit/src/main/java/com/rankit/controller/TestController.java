package com.rankit.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @GetMapping("/test")
    public String testEndpoint() {
        return "Hello, world!";
    }
}
