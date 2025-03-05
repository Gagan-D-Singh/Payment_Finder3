package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Long paymentId;
    private Double paymentAmount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String paymentStatus;
    private String failureReason;
    private LocalDateTime nextRetryDate;
}
