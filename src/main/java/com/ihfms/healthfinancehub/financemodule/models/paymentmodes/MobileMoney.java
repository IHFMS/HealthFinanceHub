package com.ihfms.healthfinancehub.financemodule.models.paymentmodes;

import com.ihfms.healthfinancehub.financemodule.models.paymentmodes.Billing;

public class MobileMoney implements Billing
{
    @Override
    public void ProcessPayment()
    {
        System.out.print("PhoneNumber:");
    }
}
