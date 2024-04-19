package com.ihfms.healthfinancehub.accountsmodule.services;

import com.ihfms.healthfinancehub.financemodule.models.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TransactionService {
    void captureTransaction(Invoice invoice);
    List<Invoice> getAllTransaction();
    List<Invoice> getAllPendingTransaction();
    List<Invoice> getNotPendingTransaction();
    int getDifferenceOfTransaction();

}
