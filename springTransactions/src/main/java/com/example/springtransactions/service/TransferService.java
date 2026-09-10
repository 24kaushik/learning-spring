package com.example.springtransactions.service;

import com.example.springtransactions.entity.Account;
import com.example.springtransactions.entity.TransferRecord;
import com.example.springtransactions.repository.AccountRepository;
import com.example.springtransactions.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferService {
    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;

    public TransferService(TransferRepository transferRepository, AccountRepository accountRepository) {
        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transfer(long fromAccountId, long toAccountId, BigDecimal amount) {
        Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow(() -> new IllegalArgumentException("From account not found"));
        Account toAccount = accountRepository.findById(toAccountId).orElseThrow(() -> new IllegalArgumentException("To account not found"));

        fromAccount.debitAccount(amount);
        toAccount.creditAccount(amount);

        TransferRecord transferRecord = new TransferRecord();
        transferRecord.setFromAccount(fromAccount);
        transferRecord.setToAccount(toAccount);
        transferRecord.setAmount(amount.doubleValue());
        transferRecord.setTransferDate(java.time.LocalDate.now());

        transferRepository.save(transferRecord);
    }

}
