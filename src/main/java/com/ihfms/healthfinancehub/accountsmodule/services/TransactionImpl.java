package com.ihfms.healthfinancehub.accountsmodule.services;

import com.ihfms.healthfinancehub.accountsmodule.repos.AccountsRepo;
import com.ihfms.healthfinancehub.financemodule.models.Invoice;
import com.ihfms.healthfinancehub.utils.SecondaryDb;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TransactionImpl {

    private final SecondaryDb db;
    private AccountsRepo accountsRepo;

    public TransactionImpl(SecondaryDb db, AccountsRepo accountsRepo) {
        this.db = db;
        this.accountsRepo = accountsRepo;
    }

    public void captureTransaction(Long patientId, Double amount) {

        Random random = new Random();
        Date currentDate = new Date(System.currentTimeMillis());

        // Convert to java.sql.Date
        Date sqlDate = new Date(currentDate.getTime());


        long transactionId= random.nextLong(100);
        Invoice invoice=new Invoice();
        invoice.setInvoiceId(transactionId);
        invoice.setAmount(amount);
        invoice.setIssueDate(sqlDate);
        invoice.setPatientId(patientId);
        invoice.setIsPaid(false);

        accountsRepo.generateInvoice(invoice);

    }

    public List<Invoice> getAllTransaction() {
        List<Invoice> invoiceList;

        return null;
    }

    public List<Invoice> getAllPendingTransaction() {
        return accountsRepo.getAllPending();
    }

    public List<Invoice> getNotPendingTransaction() {
        List<Invoice> notPendingTransactions = new ArrayList<>();
        for (Invoice invoice : db.invoiceList) {
            if (!invoice.getIsPaid()) {
                notPendingTransactions.add(invoice);
            }
        }
        return notPendingTransactions;
    }

    public int getDifferenceOfTransaction()
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


