package com.ihfms.healthfinancehub.accountsmodule.repos;

import com.ihfms.healthfinancehub.accountsmodule.models.accountsmodel.Invoice;
import com.ihfms.healthfinancehub.utils.SecondaryDb;

import java.util.List;

public interface TransactionManager {
    public Invoice captureTransaction(String patientId, int amount);

    public List<Invoice> getAllTransaction();

    public List<Invoice> getAllPendingTransaction();

    public List<Invoice> getNotPendingTransaction();




   public int getDifferenceOfTransaction(SecondaryDb db);
}


