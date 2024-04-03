package com.ihfms.healthfinancehub.entities.usermodels;

import com.ihfms.healthfinancehub.entities.reportmodels.Report;
import com.ihfms.healthfinancehub.healthmodule.models.Patient;
import lombok.*;

// can be made controller or methods be abstracted
@Data
public class AdminStaff extends User {

    private Long adminId;

    public void writeName(){
        System.out.println("From the AdminStaff class");
    }

    private void registerPatient(Patient patient){

    }

    private Report generateReport(String reportType){
        return new Report(); // can be abstracted
    }

}
