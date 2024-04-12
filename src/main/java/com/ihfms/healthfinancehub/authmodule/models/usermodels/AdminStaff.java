package com.ihfms.healthfinancehub.authmodule.models.usermodels;

import com.ihfms.healthfinancehub.entities.reportmodels.Report;
import lombok.*;

// can be made controller or methods be abstracted
@Data
public class AdminStaff extends User {

    private String adminId;
    public void writeName(){
        System.out.println("From the AdminStaff class");
    }
    private Report generateReport(String reportType){
        return new Report(); // can be abstracted
    }

}
