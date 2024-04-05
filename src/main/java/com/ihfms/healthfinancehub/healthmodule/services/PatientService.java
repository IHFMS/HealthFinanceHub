package com.ihfms.healthfinancehub.healthmodule.services;

import com.ihfms.healthfinancehub.healthmodule.models.Patient;
import com.ihfms.healthfinancehub.healthmodule.repos.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService{

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void addPatient(Patient patient){
        patientRepository.registerPatient(patient);
    }

    public List<Patient> getPatientList(){
        return patientRepository.getPatientDetails();
    }

    public void addPatientRecord(Long patientId, String diagnosis, List<String> prescriptions){
        patientRepository.addRecord(patientId, diagnosis, prescriptions);
    }


}
