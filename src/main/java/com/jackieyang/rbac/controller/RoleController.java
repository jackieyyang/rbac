package com.jackieyang.rbac.controller;

import com.jackieyang.rbac.entity.pojo.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/rbac")
@RequiredArgsConstructor
public class RoleController {
    @GetMapping("/role")
    public ResponseEntity<Object> getRole() {
        return ResponseEntity.success("Hello, Role!");
    }
}
