package com.ihfms.healthfinancehub.healthmodule.services;

import com.ihfms.healthfinancehub.healthmodule.models.Patient;
import com.ihfms.healthfinancehub.healthmodule.repos.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

public class PatientService implements PatientRepository {
    @Override
    public Patient getPatientDetails() {
        return new Patient(
                1L,
                "Marvin Nugmo",
                LocalDate.of(1989, 4, 1),
                "0709234566"
        );
    }
}
