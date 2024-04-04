package com.ihfms.healthfinancehub.accountsmodule.repos;

import com.ihfms.healthfinancehub.accountsmodule.models.accountsmodel.Invoice;

import java.util.List;
import java.util.UUID;

public class TransactionImpl implements TransactionManager {

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
        return null;
    }

    @Override
    public List<Invoice> getNotPendingTransaction() {
        return null;
    }

    @Override
    public int getDifferenceOfTransaction() {
        return 0;
    }
}
