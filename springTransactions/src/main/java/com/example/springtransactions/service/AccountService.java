package com.example.springtransactions.service;

import com.example.springtransactions.entity.Account;
import com.example.springtransactions.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccount(long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    public void addBalance(long accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.creditAccount(amount);
        accountRepository.save(account);
    }
}
