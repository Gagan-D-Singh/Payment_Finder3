package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    // Below is the equivalent query of the above statement.
    // So instead if userid, it now searches for email.
    //SELECT * FROM users WHERE email = 'alice@mail.com' LIMIT 1;
}
