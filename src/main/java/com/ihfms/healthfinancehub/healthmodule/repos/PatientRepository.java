package com.ihfms.healthfinancehub.healthmodule.repos;

import com.ihfms.healthfinancehub.entities.datasource.DBConfig;
import com.ihfms.healthfinancehub.healthmodule.models.MedicalRecord;
import com.ihfms.healthfinancehub.healthmodule.models.Patient;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class PatientRepository {

    DBConfig dbConfig = DBConfig.getInstance();
    Connection conn = dbConfig.getConnection();

    public List<MedicalRecord> getMedicalRecords(){
        String sql = "Select * FROM medical_record;";
        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Long id = resultSet.getLong("record_id");
                String diagnosis = resultSet.getString("diagnosis");
                String prescription = resultSet.getString("prescriptions");

                List<String> prescriptions = new ArrayList<>();
                prescriptions.add(prescription);

                MedicalRecord record = new MedicalRecord();

                record.setRecordId(id);
                record.setDiagnosis(diagnosis);
                record.setMedicationPrescriptions(prescriptions);

                medicalRecordList.add(record);
            }
            return medicalRecordList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public MedicalRecord getMedicalRecord(Long patientId){
        String sql = "Select * FROM medical_record WHERE patient_id_fk = ?;";
        MedicalRecord record = new MedicalRecord();

        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, patientId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Long id = resultSet.getLong("record_id");
                String diagnosis = resultSet.getString("diagnosis");
                String prescription = resultSet.getString("prescriptions");

                List<String> prescriptions = new ArrayList<>();
                prescriptions.add(prescription);

                record.setRecordId(id);
                record.setDiagnosis(diagnosis);
                record.setMedicationPrescriptions(prescriptions);
            }
            return record;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Patient> getPatientDetails() {

        List<Patient> patientList = new ArrayList<>();

        String sql = "Select * FROM patient;";

        try {

            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Long id = resultSet.getLong("patient_id");
                String name = resultSet.getString("patient_name");
                Date dob = resultSet.getDate("date_of_birth");
                String contact = resultSet.getString("contact");

                Patient patient = new Patient(id, name, dob, contact);

                patientList.add(patient);
            }
            return patientList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void registerPatient(Patient patient) {
        String sql = "INSERT INTO patient (patient_id, patient_name, date_of_birth, contact) VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, patient.getPatientId());
            statement.setString(2, patient.getName());
            statement.setDate(3, patient.getDateOfBirth());
            statement.setString(4, patient.getContact());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addRecord(Long patientId, String diagnosis, List<String> prescriptions){
        String sql = "INSERT INTO medical_record (record_id, diagnosis, prescriptions, patient_id_fk) VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            Random rand = new Random();

            statement.setLong(1, rand.nextLong(100));
            statement.setLong(4, patientId);
            statement.setString(2, diagnosis);
            statement.setString(3, prescriptions.get(0));
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
