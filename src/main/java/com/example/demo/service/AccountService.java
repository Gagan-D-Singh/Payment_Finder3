package com.example.demo.service;

import com.example.demo.dto.AccountDTO;

import java.util.List;

public interface AccountService {
    List<AccountDTO> getUserAccounts(Long userId);
}
