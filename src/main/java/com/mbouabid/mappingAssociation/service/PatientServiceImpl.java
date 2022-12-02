package com.mbouabid.mappingAssociation.service;

import com.mbouabid.mappingAssociation.entities.Patient;
import com.mbouabid.mappingAssociation.entities.RendezVous;
import com.mbouabid.mappingAssociation.repository.PatientRepository;
import com.mbouabid.mappingAssociation.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServiceImpl implements  PatientService{
    @Autowired private PatientRepository patientRepository;
    @Autowired private RendezVousRepository rendezVousRepository;
    @Override
    public void save(Patient patient) {
        this.patientRepository.save(patient);
    }
    @Override
    public void reserve(Patient p, RendezVous rdv) {
        p.getRendezVous().add(rdv);
        rdv.setPatient(p);
        patientRepository.save(p);
        rendezVousRepository.save(rdv);
    }
    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(Long id) {
        return null;
    }
}
