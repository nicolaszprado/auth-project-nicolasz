package com.example.auth_project_nicolasz.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @GetMapping
    public ResponseEntity<String> getUser () {
        return ResponseEntity.ok("Teste deu bom!!!");
    }
}
