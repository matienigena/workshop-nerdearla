package com.nerdearla.workshop.controller;

import com.nerdearla.workshop.dto.payment.PaymentRequest;
import com.nerdearla.workshop.dto.payment.PaymentResponse;
import com.nerdearla.workshop.mapper.PaymentResponseMapper;
import com.nerdearla.workshop.model.PaymentOperation;
import com.nerdearla.workshop.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("payments")
public class PaymentsController {

    private final PaymentService paymentsService;
    private final PaymentResponseMapper paymentResponseMapper;

    public PaymentsController(PaymentService paymentsService, PaymentResponseMapper paymentResponseMapper) {
        this.paymentsService = paymentsService;
        this.paymentResponseMapper = paymentResponseMapper;
    }

    @PostMapping
    public PaymentResponse processPayment(@Valid @RequestBody PaymentRequest paymentRequest) {
        PaymentOperation operation = new PaymentOperation(paymentRequest);
        return paymentResponseMapper.map(paymentsService.processPayment(operation));
    }
}
