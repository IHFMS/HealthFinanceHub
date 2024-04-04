package com.ihfms.healthfinancehub.financemodule.models.paymentmodes;

public class Card implements Billing
{
    @Override
    public void ProcessPayment()
    {
        System.out.print("CardNumber:");
    }
}
