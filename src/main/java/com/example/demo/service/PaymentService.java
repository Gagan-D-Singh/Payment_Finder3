package com.example.demo.service;

import com.example.demo.dto.AccountBalanceDTO;
import com.example.demo.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    AccountBalanceDTO getLastFiveTransactions(String accountNumber);
}
