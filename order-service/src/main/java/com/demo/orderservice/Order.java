package com.demo.orderservice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class Order {
    private String item;
    private int price;
    private String requester;
    private String provider;

    public Payment toPayment() {
        return Payment.of(requester, provider, price, "EUR");
    }

    @Getter
    @RequiredArgsConstructor(staticName = "of")
    public static class Payment {
        private final String sender;
        private final String receiver;
        private final int amount;
        private final String currency;
    }
}
