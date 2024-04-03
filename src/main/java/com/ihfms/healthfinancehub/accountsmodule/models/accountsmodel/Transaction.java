package com.ihfms.healthfinancehub.accountsmodule.models.accountsmodel;

import java.time.LocalDate;

// Transaction model class to represent individual financial transactions
public class Transaction {
    private String date;
    private String description;
    private double amount;

    public Transaction(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    // Getters and setters
    // Additional methods as needed
}