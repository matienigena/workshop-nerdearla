package com.nerdearla.workshop.payment;

import com.nerdearla.workshop.operation.PaymentOperation;
import com.nerdearla.workshop.payment.mapper.PaymentResponseMapper;
import com.nerdearla.workshop.payment.model.Payment;
import com.nerdearla.workshop.payment.service.PaymentService;
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
        return mapToResponse(process(operation));
    }

    private Payment process(PaymentOperation operation) {
        return paymentsService.processPayment(operation);
    }

    private PaymentResponse mapToResponse(Payment payment) {
        return paymentResponseMapper.map(payment);
    }
}
