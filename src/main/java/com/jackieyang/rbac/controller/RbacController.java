package com.jackieyang.rbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rbac")
public class RbacController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
