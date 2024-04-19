package com.ihfms.healthfinancehub.accountsmodule.services;

import com.ihfms.healthfinancehub.financemodule.models.Invoice;
import org.springframework.stereotype.Component;

@Component
public class TransactionLoggingDecorator extends TransactionDecorator{

    public TransactionLoggingDecorator(TransactionService transactionService) {
        super(transactionService);
    }

    @Override
    public void captureTransaction(Invoice invoice) {
        // Additional functionality - logging
        logTransaction(invoice);

        // Delegate to the wrapped transaction service
        super.captureTransaction(invoice);
    }

    // Other methods similarly overridden...

    private void logTransaction(Invoice invoice) {
        // Implement your logging logic here
        System.out.println("Logging transaction: Patient ID - " + invoice.getPatientId() + ", Amount - " + invoice.getAmount());
    }

}
