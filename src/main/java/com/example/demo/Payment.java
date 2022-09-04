package com.example.demo;

import java.util.UUID;

public class Payment {
    String paymentId;

    public Payment(UUID randomUUID) {
        paymentId=randomUUID.toString();
    }
}
