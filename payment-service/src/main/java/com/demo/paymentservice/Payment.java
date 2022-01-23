package com.demo.paymentservice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Payment {
    String sender;
    String receiver;
    int amount;
    String currency;
}
