package com.example.demo.repository;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT status, reason FROM users WHERE email = :emailId", nativeQuery = true)
    Object[] findBlockedSuspendedReasonStatus(@Param("emailId") String emailId);

    @Query(value = "SELECT updated_at FROM users WHERE email = :emailId;", nativeQuery = true)
    LocalDateTime findLastUpdated(@Param("emailId") String emailId);
}
