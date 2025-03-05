package com.example.demo.repository;

import com.example.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a WHERE a.user.userId = :userId")
    List<Account> findAccountByUserId(@Param("userId") Long userId);


    @Query(value = "SELECT account_balance FROM accounts WHERE account_number = :accountNumber;")
    Double findAccountBalance(@Param("accountNumber") String accountNumber);
}
