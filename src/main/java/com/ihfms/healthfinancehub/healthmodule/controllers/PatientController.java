package com.ihfms.healthfinancehub.healthmodule.controllers;

import com.ihfms.healthfinancehub.healthmodule.models.MedicalRecord;
import com.ihfms.healthfinancehub.healthmodule.models.Patient;
import com.ihfms.healthfinancehub.healthmodule.services.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("health-hub/patients")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {

    private final PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/add-patient")
    public void addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
    }

    @GetMapping("/get-patients")
    public List<Patient> getPatients(){
        return patientService.getPatientList();
    }




}
