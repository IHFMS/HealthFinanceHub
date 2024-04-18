package com.ihfms.healthfinancehub.accountsmodule.services;

public class TransactionLoggingDecorator extends TransactionDecorator{
    public TransactionLoggingDecorator(TransactionService transactionService) {
        super(transactionService);
    }

    @Override
    public void captureTransaction(Long patientId, Double amount) {
        // Additional functionality - logging
        logTransaction(patientId, amount);

        // Delegate to the wrapped transaction service
        super.captureTransaction(patientId, amount);
    }

    // Other methods similarly overridden...

    private void logTransaction(Long patientId, Double amount) {
        // Implement your logging logic here
        System.out.println("Logging transaction: Patient ID - " + patientId + ", Amount - " + amount);
    }

}
