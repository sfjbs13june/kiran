package com.kiran.app.model;

import org.springframework.stereotype.Component;

@Component
public class Patient {
//
//    patientname
//            id
//    hospitalname
//            disease
    String patientname;
    String disease;
    String hospitalname;
    int id;

    public Patient() {
    }

    public Patient(String patientname, String hospitalname, int id, String disease) {
        this.patientname = patientname;
        this.hospitalname = hospitalname;
        this.id = id;
        this.disease = disease;
    }

    public String getPatientname() {
        return patientname;
    }

    public String getHospitalname() {
        return hospitalname;
    }
    public String getDisease() {
        return disease;
    }

    public int getId() {
        return id;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }
    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setId(int id) {
        this.id = id;
    }


}