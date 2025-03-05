package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Object[] getUserBlockedReasonStatus(String email);
    String getLastAccUpdated(String email);
}
