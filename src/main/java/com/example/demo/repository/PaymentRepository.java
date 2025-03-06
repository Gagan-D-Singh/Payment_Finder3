package com.example.demo.repository;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
      @Query(value = "SELECT * FROM payments WHERE account_id =(SELECT account_id FROM accounts \n" +
              "\tWHERE account_number = :accountNumber) ORDER BY payment_date DESC LIMIT 5;", nativeQuery = true)
      List<Payment> findLastFiveTrasactions(@Param("accountNumber") String accountNumber);

      @Query(value = "SELECT * FROM payments WHERE account_id = (SELECT account_id FROM accounts WHERE account_number ='ACC_324') \n" +
              "AND payment_date >= CURDATE() -INTERVAL 7 DAY ORDER BY payment_date DESC;", nativeQuery = true)
      List<Payment> findLastSevenTransactions(@Param("accountNumber") String accountNumber);
}
