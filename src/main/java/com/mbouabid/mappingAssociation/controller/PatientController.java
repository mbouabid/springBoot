package com.mbouabid.mappingAssociation.controller;

import com.mbouabid.mappingAssociation.entities.Patient;
import com.mbouabid.mappingAssociation.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping(path = "/patients")
    public List<Patient> getAll(){
        return patientService.findAll();
    }
}
