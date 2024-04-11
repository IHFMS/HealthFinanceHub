package com.ihfms.healthfinancehub.financemodule.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//import java.time.LocalDate;
import java.sql.Date;

@Data
public class PaymentInfo
{
    private int paymentId;
    private String patientName;
    private int amount;
    private String payFor;
    private String paymentMode;
    private Date date;
}
