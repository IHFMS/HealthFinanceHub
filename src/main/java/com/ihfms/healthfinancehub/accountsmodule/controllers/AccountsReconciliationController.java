package com.ihfms.healthfinancehub.accountsmodule.controllers;

import com.ihfms.healthfinancehub.accountsmodule.models.accountsmodel.Transaction;
import com.ihfms.healthfinancehub.accountsmodule.services.TransactionObservable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsReconciliationController {
    private final TransactionObservable transactionObservable;

    @Autowired
    public AccountsReconciliationController(TransactionObservable transactionObservable) {
        this.transactionObservable = transactionObservable;
    }

    @PostMapping("/recordTransaction")
    public void recordTransaction(@RequestBody Transaction transaction) {
        transactionObservable.recordTransaction(transaction);
    }
}
