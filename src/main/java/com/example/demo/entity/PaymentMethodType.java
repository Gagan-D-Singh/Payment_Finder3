package com.example.demo.entity;

public enum PaymentMethodType {
    CREDIT_CARD,
    DEBIT_CARD,
    ACH,
    UPI,
    AUTO_DEBIT
}
//INSERT INTO billing (account_id, billing_date, due_date, billing_amount, billing_description) VALUES
//(1, '2025-03-01', '2025-03-15', 120.00, 'Electricity Bill'),
//        (2, '2025-03-02', '2025-03-16', 200.00, 'Water Bill'),
//        (1, '2025-03-03', '2025-03-17', 150.50, 'Internet Bill'),
//        (2, '2025-03-04', '2025-03-18', 180.00, 'Home Insurance'),
//        (1, '2025-03-05', '2025-03-19', 95.75, 'Gas Bill');