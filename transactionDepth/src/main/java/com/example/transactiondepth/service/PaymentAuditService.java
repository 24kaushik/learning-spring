package com.example.transactiondepth.service;

import com.example.transactiondepth.entity.Order;
import com.example.transactiondepth.entity.PaymentAudit;
import com.example.transactiondepth.repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {
    private final PaymentAuditRepository paymentAuditRepository;

    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository) {
        this.paymentAuditRepository = paymentAuditRepository;
    }


    @Transactional(
            propagation = Propagation.REQUIRED
    )
    public void audit(Order Order) {
        paymentAuditRepository.save(new PaymentAudit(Order.getAmount(), Order, true));
    }
}
