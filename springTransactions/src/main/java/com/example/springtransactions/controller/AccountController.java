package com.example.springtransactions.controller;

import com.example.springtransactions.entity.Account;
import com.example.springtransactions.service.AccountService;
import com.example.springtransactions.service.TransferService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Getter
    @Setter
    private static class TransferDTO {
        long fromAccountId;
        long toAccountId;
        BigDecimal amount;
    }

    private final AccountService accountService;
    private final TransferService transferService;

    public AccountController(AccountService accountService, TransferService transferService) {
        this.accountService = accountService;
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody Account account) {
        // getting balance too for ease of testing
        System.out.println("here");
        accountService.createAccount(account);
        return ResponseEntity.ok("Account created successfully");
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferDTO transferDTO) {
        transferService.transfer(transferDTO.getFromAccountId(), transferDTO.getToAccountId(), transferDTO.getAmount());
        return ResponseEntity.ok("Transfer successful");
    }

    @GetMapping("/balance/{accountId}")
    public ResponseEntity<java.lang.String> getBalance(@PathVariable long accountId) {
        Account account = accountService.getAccount(accountId);
        if (account == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Balance: " + account.getBalance());
    }
}
