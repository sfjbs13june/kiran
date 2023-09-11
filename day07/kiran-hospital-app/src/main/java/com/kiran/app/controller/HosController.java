package com.kiran.app.controller;

import com.kiran.app.model.Hospital;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HosController {

    Map<String, Hospital> hosMap= new HashMap<String, Hospital>();


    @PostMapping("/savepatient")
    public Hospital createPatient(@RequestBody Hospital hospital){
        hosMap.put(hospital.getHname(), hospital);
        return hospital;
    }

    @GetMapping("/patientname")
    public Hospital readepatient(@RequestParam("name") String name){
        return hosMap.get(name);
//    post save/patient
    }

    @PutMapping("/update/hospital")
    public Hospital updateHospital(@RequestParam("address") String address){
        Hospital hospital = hosMap.get(address);
        hospital.setId(address);
        hosMap.put(address, hospital);
        return hospital;
    }

    @DeleteMapping("/delete/patient")
    public void deleteHospita(@RequestParam("name") String name){
        hosMap.remove(name);
    }

    @GetMapping("/read/{name}")
    public Hospital ReadName(@PathVariable String name){
        return hosMap.get(name);
    }

}
