package com.astroTalk.controller;

import com.astroTalk.entity.Patient;
import com.astroTalk.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    PatientService patientService;


    @PostMapping("/patient")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient){

        Patient response  = patientService.addPatient(patient);

        return new ResponseEntity<Patient>(response,HttpStatus.OK);

    }


    @PostMapping("/hello")
    public ResponseEntity<String> sayHello( ){



        return new ResponseEntity<String>("Hello bro", HttpStatus.OK);

    }


    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> addPhoneNum(@PathVariable String pn){
        List<Patient> patients = patientService.getAllPatient();
        return new ResponseEntity<List<Patient>>(patients,HttpStatus.OK);
    }



}
