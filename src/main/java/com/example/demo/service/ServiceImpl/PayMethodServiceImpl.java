package com.example.demo.service.ServiceImpl;

import com.example.demo.repository.PaymentMethodRepository;
import com.example.demo.service.PayMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayMethodServiceImpl implements PayMethodService {

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Override
    public String getPayMethodLimit(String emailId) {
        int result = paymentMethodRepository.findPayMethodLimit(emailId);

        if(result > 3) return "You have already added the maximum no. of allowed PayMethods";
        else return "You should now be able to add new payment method";
    }
}
