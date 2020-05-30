package org.wso2.sample.domain;

import java.util.UUID;

public class MedicalRecord {

    private String id;
    private String medicineCode;
    private String doctorId;
    private int amount;
    private String date;

    public MedicalRecord(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {

        return id;
    }

    public String getMedicineCode() {

        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {

        this.medicineCode = medicineCode;
    }

    public String getDoctorId() {

        return doctorId;
    }

    public void setDoctorId(String doctorId) {

        this.doctorId = doctorId;
    }

    public int getAmount() {

        return amount;
    }

    public void setAmount(int amount) {

        this.amount = amount;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }
}
