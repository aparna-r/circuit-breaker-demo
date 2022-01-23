package com.demo.paymentservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    private static final String FAIL_TYPE = "fail";
    private static final String SLOW_TYPE = "slow";

    @PostMapping(
            value = "/transactions",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void execute(@RequestBody final Payment payment, @RequestParam String type) throws InterruptedException {
        switch (type) {
            case FAIL_TYPE:
                log.info("fail payment...");
                throw new RuntimeException();
            case SLOW_TYPE:
                log.info("slow payment...");
                Thread.sleep(5000);
                break;
            default:
                log.info("fast payment...");
        }
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handle() {
    }
}
