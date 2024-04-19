package com.ihfms.healthfinancehub.financemodule.services;

import com.ihfms.healthfinancehub.financemodule.models.paymentmodes.Billing;
import org.springframework.stereotype.Component;

@Component
public class PaymentContext
{
    private Billing bill;
    public void setPayment(Billing billing)
    {
        this.bill = billing;
    }
    public void MakePayment()
    {
        bill.ProcessPayment();
    }
}
