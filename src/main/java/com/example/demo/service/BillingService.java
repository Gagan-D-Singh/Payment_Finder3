package com.example.demo.service;

import com.example.demo.dto.BillingDTO;

import java.util.List;

public interface BillingService {
    List<BillingDTO> getOverdueBillByUser(Long userId);
}
