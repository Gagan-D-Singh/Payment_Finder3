package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillingDTO {
    private Long billingId;
    private LocalDate billingDate;
    private LocalDate dueDate;
    private Double billingAmount;
    private String billingDescription;
}
