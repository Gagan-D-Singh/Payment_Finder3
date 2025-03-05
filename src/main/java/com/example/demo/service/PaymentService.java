package com.example.demo.service;

import com.example.demo.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    List<PaymentDTO> getUserPayments(Long userId);
    List<PaymentDTO> getUserLastFivePayments(Long userId);
    List<PaymentDTO> getPendingPayments(Long accountId);
}
