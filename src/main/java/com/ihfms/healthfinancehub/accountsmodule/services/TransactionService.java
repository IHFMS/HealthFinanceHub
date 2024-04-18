package com.ihfms.healthfinancehub.accountsmodule.services;

import com.ihfms.healthfinancehub.financemodule.models.Invoice;

import java.util.List;

public interface TransactionService {
    void captureTransaction(Long patientId, Double amount);
    List<Invoice> getAllTransaction();
    List<Invoice> getAllPendingTransaction();
    List<Invoice> getNotPendingTransaction();
    int getDifferenceOfTransaction();

}
