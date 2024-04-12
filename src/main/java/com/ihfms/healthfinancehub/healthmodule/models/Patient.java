package com.ihfms.healthfinancehub.healthmodule.models;

import lombok.Data;
import java.sql.Date;

@Data
public class Patient {

    private Long patientId;
    private String name;
    private Date dateOfBirth;
    private String contact;
    private MedicalRecord medicalRecord;

//    public Patient(Long patientId, String name, Date dateOfBirth, String contact, MedicalRecord medicalRecord) {
//        this.patientId = patientId;
//        this.name = name;
//        this.dateOfBirth = dateOfBirth;
//        this.contact = contact;
//        this.medicalRecord = medicalRecord;
//    }

    public Patient(Long patientId, String name, Date dateOfBirth, String contact) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
    }

}
