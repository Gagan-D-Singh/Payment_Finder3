package com.example.demo.controller;

import com.example.demo.dto.AccountBalanceDTO;
import com.example.demo.dto.PaymentDTO;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/lastFiveTransactions/{accountNumber}")
    AccountBalanceDTO getLastFivePayments(@PathVariable String accountNumber){
        return paymentService.getLastFiveTransactions(accountNumber);
    }
}

