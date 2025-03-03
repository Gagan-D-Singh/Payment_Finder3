package com.example.demo.service.ServiceImpl;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public List<PaymentDTO> getUserPayments(Long userId) {
        return paymentRepository.findPaymentsByUserId(userId)
                .stream()
                .map(payment -> PaymentDTO.builder()
                        .paymentId(payment.getPaymentId())
                        .paymentAmount(payment.getPaymentAmount())
                        .paymentDate(payment.getPaymentDate())
                        .paymentMethod(payment.getPaymentMethod())
                        .paymentStatus(payment.getPaymentStatus())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentDTO> getUserLastFivePayments(Long userId) {
        return paymentRepository.findLastFivePaymentsByUserId(userId)
                .stream()
                .map(payment -> PaymentDTO.builder()
                        .paymentId(payment.getPaymentId())
                        .paymentAmount(payment.getPaymentAmount())
                        .paymentDate(payment.getPaymentDate())
                        .paymentMethod(payment.getPaymentMethod())
                        .paymentStatus(payment.getPaymentStatus())
                        .build()).collect(Collectors.toList());
    }
}
