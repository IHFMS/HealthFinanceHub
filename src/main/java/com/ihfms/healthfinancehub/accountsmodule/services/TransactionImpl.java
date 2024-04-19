package com.ihfms.healthfinancehub.accountsmodule.services;

import com.ihfms.healthfinancehub.accountsmodule.repos.AccountsRepo;
import com.ihfms.healthfinancehub.financemodule.models.Invoice;
import com.ihfms.healthfinancehub.utils.SecondaryDb;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Random;

@Service
public class TransactionImpl implements TransactionService {

    private final SecondaryDb db;
    private final AccountsRepo accountsRepo;

    public TransactionImpl(SecondaryDb db, AccountsRepo accountsRepo) {
        this.db = db;
        this.accountsRepo = accountsRepo;
    }

    public void captureTransaction(Invoice invoice) {

        Random random = new Random();
        Date currentDate = new Date(System.currentTimeMillis());

        // Convert to java.sql.Date
        Date sqlDate = new Date(currentDate.getTime());

        long transactionId= random.nextLong(100);
        invoice.setInvoiceId(transactionId);
        invoice.setIssueDate(sqlDate);
        invoice.setIsPaid(false);

        accountsRepo.generateInvoice(invoice);

    }

    public List<Invoice> getAllTransaction() {
        return accountsRepo.getAllTransactions();
    }

    public List<Invoice> getAllPendingTransaction() {
        List<Invoice> pendingTransactions = accountsRepo.getAllPending();
        for (Invoice invoice : pendingTransactions) {
            if (!invoice.getIsPaid()) {
                db.invoiceList.add(invoice);
            }
        }
        System.out.println("From getPending" + db.invoiceList);
        return pendingTransactions;
    }

    public List<Invoice> getNotPendingTransaction() {
        List<Invoice> notPendingTransactions = accountsRepo.getNotPending();
        for (Invoice invoice : notPendingTransactions) {
            if (invoice.getIsPaid()) {
                db.invoiceList.add(invoice);
            }
        }
        System.out.println("From getNotPending" + db.invoiceList);
        return notPendingTransactions;
    }

    public int getDifferenceOfTransaction()
    {
        int pendingCount = 0;
        int notPendingCount = 0;

        for (Invoice invoice : db.invoiceList) {
            if (!invoice.getIsPaid()) {
                pendingCount++;
            } else {
                notPendingCount++;
            }
        }

        return pendingCount - notPendingCount;
    }
}


