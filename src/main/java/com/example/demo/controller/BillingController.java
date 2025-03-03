package com.example.demo.controller;

import com.example.demo.dto.BillingDTO;
import com.example.demo.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    BillingService billingService;

    @GetMapping("/dueBill/{userId}")
    List<BillingDTO> getOverdueBillsByUser(@PathVariable Long userId){
        return billingService.getOverdueBillByUser(userId);
    }
}
