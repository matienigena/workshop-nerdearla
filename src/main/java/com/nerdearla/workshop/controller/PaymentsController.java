package com.nerdearla.workshop.controller;

import com.nerdearla.workshop.dto.payment.PaymentRequest;
import com.nerdearla.workshop.dto.payment.PaymentResponse;
import com.nerdearla.workshop.model.PaymentOperation;
import com.nerdearla.workshop.service.PaymentsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("payments")
public class PaymentsController {

    private final PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }


    @PostMapping
    public PaymentResponse processPayment(@Valid @RequestBody PaymentRequest paymentRequest) {

        return paymentsService.processPayment(paymentRequest);
    }
}
