package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "payment_methods")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentMethodId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String cardNumber;
    private String cardExpiry;
    private String cardCVV;
    private String bankAccountNumber;
    private String bankRoutingNumber;
}
//
//INSERT INTO payment_methods (user_id, card_number, card_expiry, cardcvv, bank_account_number, bank_routing_number) VALUES
//(38, '4111111111111111', '2026-12-31', '123', '1234567890', '001002003'),
//        (40, '4222222222222222', '2027-11-30', '234', '2345678901', '004005006');

//INSERT INTO users (username, password_hash, email, phone, address, status, reason, updated_at) VALUES
//('john_doe', 'hashed_password_123', 'john.doe@example.com', '1234567890', '123 Main St', 'ACTIVE', NULL, NOW()),
//        ('jane_smith', 'hashed_password_456', 'jane.smith@example.com', '0987654321', '456 Elm St', 'ACTIVE', NULL, NOW()),