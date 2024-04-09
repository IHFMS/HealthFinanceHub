//package com.ihfms.healthfinancehub.accountsmodule.controllers;
//
//import com.ihfms.healthfinancehub.accountsmodule.repos.TransactionManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class AccountsController {
//    @Autowired
//    TransactionManager transactionmanager;
//
//
//}

package com.ihfms.healthfinancehub.accountsmodule.controllers;

import com.ihfms.healthfinancehub.accountsmodule.repos.TransactionImpl;
import com.ihfms.healthfinancehub.accountsmodule.repos.TransactionManager;
import com.ihfms.healthfinancehub.financemodule.models.Invoice;
import com.ihfms.healthfinancehub.utils.SecondaryDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionManager transactionManager = new TransactionImpl(SecondaryDb.getInstance());

    @Autowired
    public TransactionController() {

    }

    @GetMapping("/all")
    public List<Invoice> getAllTransactions() {
        return transactionManager.getAllTransaction();
    }

    @GetMapping("/pending")
    public List<Invoice> getAllPendingTransactions() {
        return transactionManager.getAllPendingTransaction();
    }

    @GetMapping("/not-pending")
    public List<Invoice> getNotPendingTransactions() {
        return transactionManager.getNotPendingTransaction();
    }

    @GetMapping("/difference")
    public int getDifferenceOfTransaction() {
        return transactionManager.getDifferenceOfTransaction(SecondaryDb.getInstance());
    }
}

