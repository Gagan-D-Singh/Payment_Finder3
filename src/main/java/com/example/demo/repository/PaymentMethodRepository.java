package com.example.demo.repository;

import com.example.demo.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    @Query(value = "SELECT COUNT(*) FROM payment_methods WHERE \n" +
            "user_id =(SELECT user_id FROM users WHERE email ='diana.prince@example.com');", nativeQuery = true)
    int findPayMethodLimit(String emailId);
}
