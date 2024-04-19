package com.ihfms.healthfinancehub.healthmodule.repos;

import com.ihfms.healthfinancehub.healthmodule.models.Patient;

import java.util.List;

public interface PatientRepositoryInterface {
    List<Patient> getPatientDetails();
    void registerPatient(Patient patient);
    void addRecord(Long patientId, String diagnosis, List<String> prescriptions);
}
