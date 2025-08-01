package com.fooddelivery.controller;

import com.fooddelivery.dto.UserDTO;
import com.fooddelivery.model.User;
import com.fooddelivery.service.UserService;
import com.fooddelivery.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        try {
            User user = new User();
            user.setUsername(userDTO.getUsername()); // Make sure this matches your entity
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword()); // Will be encoded in service
            user.setRole("USER");

            userService.register(user);
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
//        try {
//            User user = userService.login(userDTO.getUsername(), userDTO.getPassword());
//            String token = jwtUtil.generateToken(user.getName());
//
//            Map<String, String> response = new HashMap<>();
//            response.put("token", token);
//            response.put("message", "Login successful!");
//
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
  //  }
}
