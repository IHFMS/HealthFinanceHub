package com.ihfms.healthfinancehub.financemodule.services;

import com.ihfms.healthfinancehub.financemodule.models.PaymentInfo;
import com.ihfms.healthfinancehub.financemodule.models.paymentmodes.Billing;
import com.ihfms.healthfinancehub.financemodule.models.paymentmodes.Card;
import com.ihfms.healthfinancehub.financemodule.models.paymentmodes.Cash;
import com.ihfms.healthfinancehub.financemodule.models.paymentmodes.MobileMoney;
import com.ihfms.healthfinancehub.financemodule.repos.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;

@Service
public class PaymentService
{
    private final PaymentRepository paymentRepository;
    private Billing bill;
    private PaymentService(PaymentRepository paymentRepository)
    {
        this.paymentRepository = paymentRepository;
    }
    private void setPayment(Billing billing)
    {
        this.bill = billing;
    }
    public void selectPayment(@RequestBody PaymentInfo paymentInfo) throws SQLException {
        String mode = paymentInfo.getPaymentMode();
        switch(mode)
        {
            case "mm":
                setPayment(new MobileMoney());
                break;
            case "card":
                setPayment(new Card());
                break;
            default:
                setPayment(new Cash());
                break;
        }

        MakePayment();
        //paymentRepository.save(paymentInfo);
    }
    private void MakePayment()
    {
        bill.ProcessPayment();
    }
}
