package com.ihfms.healthfinancehub.financemodule.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Payment {

    private int transactionId;
    private LocalDate paymentDate;
    private Double amount;
    private String type;

    private void processPayment(){

    }
}

