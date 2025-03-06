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

    //1st Query
    @GetMapping("/status/{emailId}")
    public Object[] getUserBlockedReasonStatus(@PathVariable String emailId){
        return userService.getUserBlockedReasonStatus(emailId);
    }

    //3rd Query
    @GetMapping("/lastUpdated/{emailId}")
    public String getLastAccUpdated(@PathVariable String emailId){
        return userService.getLastAccUpdated(emailId);
    }

    //6th Query
    @GetMapping("/declineReason/{emailId}")
    public Object[] getDeclineReason(@PathVariable String emailId){
        return userService.getUserBlockedReasonStatus(emailId);
    }

}

