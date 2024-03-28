package com.ihfms.healthfinancehub.financemodule.models;

import lombok.Data;

import java.util.Date;

@Data
public class Invoice {

    private int invoiceId;
    private Double amount;
    private Date issueDate;
    private Date dueDate;

}
