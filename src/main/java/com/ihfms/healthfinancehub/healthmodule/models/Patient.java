package com.ihfms.healthfinancehub.healthmodule.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Patient {

    private Long patientId;
    private String name;
    private LocalDate dateOfBirth;
    private String contact;
    private MedicalRecord medicalRecord;

    public Patient(Long patientId, String name, LocalDate dateOfBirth, String contact) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
    }

}
