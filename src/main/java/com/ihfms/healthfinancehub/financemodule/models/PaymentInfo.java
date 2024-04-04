package com.ihfms.healthfinancehub.financemodule.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class PaymentInfo
{
    @Getter
    private int paymentId;
    @Getter
    private String patientName;
    @Getter
    private int amount;
    @Getter
    private String payFor;
    @Setter
    private String paymentMode;
    @Getter
    private LocalDate date;
}
