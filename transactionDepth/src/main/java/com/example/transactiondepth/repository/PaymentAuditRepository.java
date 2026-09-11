package com.example.transactiondepth.repository;

import com.example.transactiondepth.entity.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentAuditRepository extends JpaRepository<PaymentAudit, Long> {
}
