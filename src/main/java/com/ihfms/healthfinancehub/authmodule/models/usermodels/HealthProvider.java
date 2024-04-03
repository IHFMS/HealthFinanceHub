package com.ihfms.healthfinancehub.authmodule.models.usermodels;

import com.ihfms.healthfinancehub.financemodule.models.Invoice;
import com.ihfms.healthfinancehub.healthmodule.models.MedicalRecord;
import com.ihfms.healthfinancehub.healthmodule.models.Patient;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

// can be made controller or methods be abstracted
@Data
public class HealthProvider extends User{
    private String specialization;
    public void writeName(){
        System.out.println("From the HealthProvider class");
    }

    private MedicalRecord recordObservations(){
        return new MedicalRecord();
    }

    private Invoice generateInvoice(){
        return new Invoice();
    }

    private List<Patient> getPatientList(){
        return new ArrayList<>();
    }


}
