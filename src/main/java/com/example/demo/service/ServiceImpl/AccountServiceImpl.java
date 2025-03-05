package com.example.demo.service.ServiceImpl;

import com.example.demo.dto.AccountDTO;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<AccountDTO> getUserAccounts(Long userId) {
        return accountRepository.findAccountByUserId(userId)
                .stream()
                .map(account -> AccountDTO.builder()
                        .accountId(account.getAccountId())
                        .accountNumber(account.getAccountNumber())
                        .accountBalance(account.getAccountBalance())
//                        .accountType(account.getAccountType())
                        .build())
                .collect(Collectors.toList());
    }
}
