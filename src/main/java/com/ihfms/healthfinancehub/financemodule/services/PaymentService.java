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
    private Billing billing;
    private PaymentService(PaymentRepository paymentRepository)
    {
        this.paymentRepository = paymentRepository;
    }
    public void setPayment(Billing billing)
    {
        this.billing = billing;
    }
    public void selectPayment(@RequestBody PaymentInfo paymentInfo) throws SQLException {
        String mode = paymentInfo.getPaymentMode();
        switch(mode)
        {
            case "mm":
                setPayment(new MobileMoney());
            case "card":
                setPayment(new Card());
            default:
                setPayment(new Cash());
        }

        paymentRepository.save(paymentInfo);
        MakePayment();
    }
    private void MakePayment()
    {
        billing.ProcessPayment();
    }
}
