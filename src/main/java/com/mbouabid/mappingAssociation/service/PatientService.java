package com.mbouabid.mappingAssociation.service;

import com.mbouabid.mappingAssociation.entities.Patient;
import com.mbouabid.mappingAssociation.entities.RendezVous;

import java.util.List;


public interface PatientService {
    void save (Patient patient);
    void reserve (Patient p, RendezVous rdv);
    List<Patient> findAll();
     Patient findById(Long id);
}
