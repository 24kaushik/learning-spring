package org.example;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    void pay(){
        System.out.println("Payment processed.");
    }
}
