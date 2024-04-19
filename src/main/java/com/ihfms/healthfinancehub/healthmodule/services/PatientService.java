package com.ihfms.healthfinancehub.healthmodule.services;

import com.ihfms.healthfinancehub.healthmodule.models.Patient;
import com.ihfms.healthfinancehub.healthmodule.repos.PatientRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepositoryInterface patientRepository;

    public PatientService(PatientRepositoryInterface patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void addPatient(Patient patient) {
        patientRepository.registerPatient(patient);
    }

    public List<Patient> getPatientList() {
        return patientRepository.getPatientDetails();
    }


}
