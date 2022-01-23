package com.demo.orderservice;

import com.demo.orderservice.Order.Payment;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("ALL")
@Component
public class PaymentClient {
    @Value("${payment-service-url}")
    private String paymentServiceUrl;
    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "payment-service")
    public void makePayment(final Payment payment, final String type) {
        restTemplate.postForObject(paymentServiceUrl + "?type=" + type, payment, String.class);
    }
}
