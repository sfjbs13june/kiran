package com.kiran.app.controller;

import com.kiran.app.model.Hospital;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HosController {

    Map<String, Hospital> hosMap= new HashMap<String, Hospital>();

    @PostMapping("/create")
    public Hospital createStudent(@RequestBody Hospital hospital){
        hosMap.put(hospital.getHname(), hospital);
        return hospital;
    }

    @GetMapping("/read")
    public Hospital readeStudent(@RequestParam("name") String name){
        return hosMap.get(name);
    }

    @PutMapping("/update")
    public Hospital updateStudent(@RequestParam("name") String name, @RequestParam("age") int age){
        Hospital hospital = hosMap.get(name);
        hospital.setId(age);
        hosMap.put(name, hospital);
        return hospital;
    }

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam("name") String name){
        hosMap.remove(name);
    }

    @GetMapping("/read/{name}")
    public Hospital ReadNameStudent(@PathVariable String name){
        return hosMap.get(name);
    }

}
