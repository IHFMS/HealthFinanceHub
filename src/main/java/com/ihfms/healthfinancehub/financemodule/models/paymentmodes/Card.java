package com.ihfms.healthfinancehub.financemodule.models.paymentmodes;

import java.util.Scanner;

public class Card implements Billing
{
    Scanner scan = new Scanner(System.in);
    @Override
    public void ProcessPayment()
    {
        System.out.print("you have chosen Card");
        var cardNumber = scan.nextBigInteger();
    }
}
