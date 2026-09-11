package com.example.transactiondepth.service;

import com.example.transactiondepth.entity.Order;
import com.example.transactiondepth.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentAuditService paymentAuditService;

    public OrderService(OrderRepository orderRepository, PaymentAuditService paymentAuditService) {
        this.orderRepository = orderRepository;
        this.paymentAuditService = paymentAuditService;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void createOrder(Order order) {
        orderRepository.save(order);
        paymentAuditService.audit(order);
    }
}
