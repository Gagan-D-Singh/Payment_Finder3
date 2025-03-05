package com.example.demo.controller;

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

    @GetMapping("/user/{userId}")
    public List<PaymentDTO> getUserPayments(@PathVariable Long userId) {
        return paymentService.getUserPayments(userId);
    }

    @GetMapping("/user/last5payments/{userId}")
    public List<PaymentDTO> getUserLastFivePayments(@PathVariable Long userId) {
        return paymentService.getUserLastFivePayments(userId);
    }

    @GetMapping("/account/pending/{accountId}")
    public List<PaymentDTO> getPendingPaymentsByAccount(@PathVariable Long accountId){
        return paymentService.getPendingPayments(accountId);
    }
}

