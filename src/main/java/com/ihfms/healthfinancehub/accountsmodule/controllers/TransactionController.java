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

import com.ihfms.healthfinancehub.accountsmodule.services.TransactionImpl;
import com.ihfms.healthfinancehub.financemodule.models.Invoice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("health-hub/transactions")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {

    private final TransactionImpl transaction;

    public TransactionController(TransactionImpl transaction) {
        this.transaction = transaction;
    }

    @PostMapping("/capture-invoice")
    public void captureInvoice(
            @RequestParam Long patientId,
            @RequestParam Double amount
    ){
        transaction.captureTransaction(patientId, amount);
    }

    @GetMapping("/all")
    public List<Invoice> getAllTransactions() {
        return transaction.getAllTransaction();
    }

    @GetMapping("/pending")
    public List<Invoice> getAllPendingTransactions() {
        return transaction.getAllPendingTransaction();
    }

    @GetMapping("/not-pending")
    public List<Invoice> getNotPendingTransactions() {
        return transaction.getNotPendingTransaction();
    }

    @GetMapping("/difference")
    public int getDifferenceOfTransaction() {
        return transaction.getDifferenceOfTransaction();
    }
}

