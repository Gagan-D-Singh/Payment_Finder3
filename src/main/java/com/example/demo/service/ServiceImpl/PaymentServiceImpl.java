package com.example.demo.service.ServiceImpl;

import com.example.demo.dto.AccountBalanceDTO;
import com.example.demo.dto.PaymentDTO;
import com.example.demo.entity.Payment;
import com.example.demo.repository.AccountRepository;
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

    @Autowired
    AccountRepository accountRepository;


    @Override
    public AccountBalanceDTO getLastFiveTransactions(String accountNumber) {
        Double amount = accountRepository.findAccountBalance(accountNumber);

        List<PaymentDTO> lastFiveTransaction = paymentRepository.findLastFiveTrasactions(accountNumber).stream().map(payment -> PaymentDTO.builder()
                .paymentId(payment.getPaymentId())
                .paymentDate(payment.getPaymentDate())
                .paymentAmount(payment.getPaymentAmount())
                .paymentMethod(payment.getPaymentMethod().name())
                .paymentStatus(payment.getPaymentStatus().name())
                .failureReason(payment.getFailureReason())
                .nextRetryDate(payment.getNextRetryData())
                .build()).collect(Collectors.toList());

        return new AccountBalanceDTO(amount, lastFiveTransaction);
    }
}
