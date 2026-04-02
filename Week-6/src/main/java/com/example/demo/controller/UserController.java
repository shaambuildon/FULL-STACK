package com.example.demo.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.example.demo.model.User;

@RestController
public class UserController {

    // SESSION 30
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user) {
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> data) {
        if (data.get("username").equals("admin") &&
            data.get("password").equals("1234")) {
            return "JWT-TOKEN";
        }
        return "Invalid Credentials";
    }
}