package com.example.demo.repository;

import com.example.demo.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
//    @Query("SELECT b FROM Billing b WHERE b.user.userId = :userId")
//    List<Billing> findBillingByUserId(@Param("userId") Long userId);
}
