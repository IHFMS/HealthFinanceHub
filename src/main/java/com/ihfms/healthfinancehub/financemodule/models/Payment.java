package com.ihfms.healthfinancehub.financemodule.models;

import lombok.Data;

import java.util.Date;

@Data
public class Payment {
    private int transactionId;
    private Date paymentDate;
    private Double amount;
    private String type;

    private void processPayment(){

    }
}

