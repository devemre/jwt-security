package com.devemre.jwtsecurity.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/management")
public class ManagementController {

    @GetMapping
    public String get() {
        return "GET:: ManagementController";
    }

    @PostMapping
    public String post() {
        return "POST:: ManagementController";
    }

    @PutMapping
    public String put() {
        return "PUT:: ManagementController";
    }

    @DeleteMapping
    public String delete() {
        return "DELETE:: ManagementController";
    }

}