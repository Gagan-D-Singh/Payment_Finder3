package com.example.demo.service.ServiceImpl;

import com.example.demo.dto.BillingDTO;
import com.example.demo.repository.BillingRepository;
import com.example.demo.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    BillingRepository billingRepository;

}
