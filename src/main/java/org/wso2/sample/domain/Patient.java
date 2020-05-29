package org.wso2.sample.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Patient {

    public static final String DATE_FORMAT = "MM/dd/yyyy";
    private String id;
    private String name;
    private String dateOfBirth;
    private Map<String, MedicalRecord> medicalRecords;

    public Patient(){
        this.id = UUID.randomUUID().toString();
        this.medicalRecords = new HashMap<>();
    }

    public Patient(String name) {
        super();
        this.name = name;
    }

    public String getId() {

        return id;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDateOfBirth() {

        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {

       this.dateOfBirth = dateOfBirth;
    }


    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.put(medicalRecord.getId(), medicalRecord);
    }

    public void removeMedicalRecord(String recordId) {

        medicalRecords.remove(recordId);
    }
}
