package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(nullable = false)
    private Double paymentAmount;

    @Column(nullable = false)
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethodType paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    private String failureReason;

    private LocalDateTime nextRetryData;
}


//INSERT INTO payments (
//        user_id,
//        account_id,
//        payment_amount,
//        payment_date,
//        payment_method,
//        payment_status,
//        failure_reason,
//        next_retry_data
//        ) VALUES (
//        40, -- User ID
//    2, -- Account ID
//    1782.00, -- Payment Amount
//NOW(), -- Payment Date
//    'DEBIT_CARD', -- Payment Method
//
//    'COMPLETED', -- Payment Status
//NULL, -- Failure Reason
//NOW()+1 -- Next Retry Date
//);
