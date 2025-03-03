package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    public Optional<UserDTO> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
}

