package com.example.demo.controller;

import com.example.demo.service.PayMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payMethod")
public class PayMethodController {

    @Autowired
    PayMethodService payMethodService;

    //2nd Query
    @GetMapping("/checkLimit/{emailId}")
    String findPayMethodLimit(@PathVariable String emailId){
        return payMethodService.getPayMethodLimit(emailId);
    }
}
