package com.example.demo.repository;

import com.example.demo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("SELECT p FROM Payment p WHERE p.user.userId = :userId")
    List<Payment> findPaymentsByUserId(@Param("userId") Long userId);

    @Query("SELECT p FROM Payment p WHERE p.user.userId = :userId order by p.paymentDate DESC LIMIT 5")
    List<Payment> findLastFivePaymentsByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM payments WHERE account_id = :accountId AND payment_status = 'pending'",
            nativeQuery = true)
    List<Payment> findPendingPaymentsForAccount(@Param("accountId") Long accountId);

    //equivalent to SELECT * FROM Payments WHERE Payments.user_id = userID;
}
