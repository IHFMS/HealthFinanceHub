package com.ihfms.healthfinancehub.healthmodule.models;

import lombok.Data;

import java.util.Date;

@Data
public class Patient {

    private Long patientId;
    private String name;
    private Date dateOfBirth;
    private String contact;
    private MedicalRecord medicalRecord;

}
