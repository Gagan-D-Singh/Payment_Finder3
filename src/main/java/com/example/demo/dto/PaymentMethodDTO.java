package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodDTO {
    private Long paymentMethodId;
    private String cardNumber;  // Masked card number for security
    private String cardExpiry;
    private String bankAccountNumber; // Masked for security
    private String bankRoutingNumber;
}
