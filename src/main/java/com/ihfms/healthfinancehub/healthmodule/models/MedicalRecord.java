package com.ihfms.healthfinancehub.healthmodule.models;

import lombok.Data;

import java.util.List;

@Data
public class MedicalRecord {

    private Long recordId;
    private String diagnosis;
    private List<String> medicationPrescriptions;

}
