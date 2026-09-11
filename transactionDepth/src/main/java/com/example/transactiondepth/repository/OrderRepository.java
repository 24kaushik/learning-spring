package com.example.transactiondepth.repository;

import com.example.transactiondepth.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
