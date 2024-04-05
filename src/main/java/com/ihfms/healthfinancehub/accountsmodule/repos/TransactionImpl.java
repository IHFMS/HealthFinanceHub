package com.ihfms.healthfinancehub.accountsmodule.repos;

import com.ihfms.healthfinancehub.accountsmodule.models.accountsmodel.Invoice;
import com.ihfms.healthfinancehub.utils.SecondaryDb;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionImpl implements TransactionManager {
    private SecondaryDb db ;
    public TransactionImpl(SecondaryDb database){
        this.db = database;
    }

    @Override
    public Invoice captureTransaction(String patientId, int amount){
        String transactionId= UUID.randomUUID().toString();
        Invoice invoice=new Invoice();
        invoice.setId(transactionId);
        invoice.setAmount(amount);
        invoice.setPatientId(patientId);
        invoice.setIsPaid(false);




        return invoice;
    }

    @Override
    public List<Invoice> getAllTransaction() {
        List<Invoice> invoiceList;



        return null;
    }

    @Override
    public List<Invoice> getAllPendingTransaction() {
        return db.invoiceList;

    }

    @Override
    public List<Invoice> getNotPendingTransaction() {
        List<Invoice> notPendingTransactions = new ArrayList<>();
        for (Invoice invoice : db.invoiceList) {
            if (!invoice.getIsPaid()) {
                notPendingTransactions.add(invoice);
            }
        }
        return notPendingTransactions;
    }

    @Override
    public int getDifferenceOfTransaction(SecondaryDb db)
    {
        int pendingCount = 0;
        int notPendingCount = 0;

        for (Invoice invoice : db.invoiceList) {
            if (invoice.getIsPaid()) {
                pendingCount++;
            } else {
                notPendingCount++;
            }
        }

        return pendingCount - notPendingCount;
    }
}


