package com.ihfms.healthfinancehub.financemodule.models.paymentmodes;

public class MobileMoney implements Billing
{
    @Override
    public void ProcessPayment()
    {
        System.out.print("PhoneNumber:");
    }
}
