package com.ihfms.healthfinancehub.financemodule.controllers;

import com.ihfms.healthfinancehub.financemodule.models.PaymentInfo;
import com.ihfms.healthfinancehub.financemodule.services.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("health-hub/makePayment")
public class PaymentController
{
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService)
    {
        this.paymentService = paymentService;
    }

    @PostMapping
    public void RegisterPayment(@RequestBody PaymentInfo paymentInfo) throws SQLException {
        System.out.println(paymentInfo);
        paymentService.selectPayment(paymentInfo);
    }

    @GetMapping("/test")
    public String test(){
        return "Hello test";
    }
}
