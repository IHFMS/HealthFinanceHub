package com.ihfms.healthfinancehub.financemodule.models.paymentmodes;

import java.util.Scanner;

public class MobileMoney implements Billing
{
    Scanner scan = new Scanner(System.in);
    @Override
    public void ProcessPayment()
    {
        System.out.print("yuo have choswen mm");
        var phoneNumber = scan.nextBigInteger();
    }
}
