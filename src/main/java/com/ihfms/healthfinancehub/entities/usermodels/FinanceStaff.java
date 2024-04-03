package com.ihfms.healthfinancehub.entities.usermodels;

import com.ihfms.healthfinancehub.entities.reportmodels.Report;
import lombok.Data;

// can be made controller or methods be abstracted
@Data
public class FinanceStaff extends User{
    public void writeName(){
        System.out.println("From the FinanceStaff class");
    }
    private void displayAccounts(){

    }

    private Report generateReport(){
        return new Report(); // can be abstracted
    }
}
