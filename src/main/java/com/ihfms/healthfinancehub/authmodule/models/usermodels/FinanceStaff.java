package com.ihfms.healthfinancehub.authmodule.models.usermodels;

import com.ihfms.healthfinancehub.entities.reportmodels.Report;

// can be made controller or methods be abstracted
public class FinanceStaff extends User{
    public void writeName(){
        System.out.println("From the FinanceStaff class");
    }

    private void displayAccounts(){}


    private Report generateReport(){
        return new Report(); // can be abstracted
    }

}
