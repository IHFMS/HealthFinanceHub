package com.ihfms.healthfinancehub.financemodule.services;

import com.ihfms.healthfinancehub.financemodule.models.PaymentInfo;
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
    private final PaymentContext paymentContext;
    private PaymentService(PaymentRepository paymentRepository, PaymentContext paymentContext)
    {
        this.paymentRepository = paymentRepository;
        this.paymentContext = paymentContext;
    }
    public void selectPayment(@RequestBody PaymentInfo paymentInfo) throws SQLException {
        String mode = paymentInfo.getPaymentMode();

        switch(mode)
        {
            case "mobile":
                paymentContext.setPayment(new MobileMoney());
                break;
            case "card":
                paymentContext.setPayment(new Card());
                break;
            case "cash":
                paymentContext.setPayment(new Cash());
                break;
            default:
                System.out.println("Invalid Option!!");
                break;
        }

        paymentContext.MakePayment();
        ValidatePayment();
        paymentRepository.save(paymentInfo);
    }
    private void ValidatePayment()
    {
        System.out.println("Payment Successful.");
    }
}
