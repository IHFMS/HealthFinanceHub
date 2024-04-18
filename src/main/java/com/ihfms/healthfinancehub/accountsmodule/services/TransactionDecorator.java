package com.ihfms.healthfinancehub.accountsmodule.services;

import com.ihfms.healthfinancehub.financemodule.models.Invoice;

import java.util.List;

public class TransactionDecorator implements TransactionService{
    protected TransactionService transactionService;

    public TransactionDecorator(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public void captureTransaction(Long patientId, Double amount) {
        transactionService.captureTransaction(patientId, amount);
    }

    @Override
    public List<Invoice> getAllTransaction() {
        return transactionService.getAllTransaction();
    }

    @Override
    public List<Invoice> getAllPendingTransaction() {
        return transactionService.getAllPendingTransaction();
    }

    @Override
    public List<Invoice> getNotPendingTransaction() {
        return transactionService.getNotPendingTransaction();
    }

    @Override
    public int getDifferenceOfTransaction() {
        return transactionService.getDifferenceOfTransaction();
    }

}
