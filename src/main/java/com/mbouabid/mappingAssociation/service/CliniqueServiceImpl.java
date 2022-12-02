package com.mbouabid.mappingAssociation.service;

import com.mbouabid.mappingAssociation.entities.Clinique;
import com.mbouabid.mappingAssociation.entities.Medecin;
import com.mbouabid.mappingAssociation.repository.CliniqueRepository;
import com.mbouabid.mappingAssociation.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CliniqueServiceImpl implements CliniqueService{
    @Autowired
    private CliniqueRepository cliniqueRepository;
    @Autowired
    private MedecinRepository medecinRepository;

    @Override
    public Medecin findByNom(String nom) {
        return medecinRepository.findByNom(nom);
    }

    @Override
    public Clinique ajouterClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

    @Override
    public Medecin ajouterMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    @Transactional
    public void affecterMedecinClinique(String nomMedecin, String nomClient) {
        Medecin  medecin = medecinRepository.findByNom(nomMedecin);
        Clinique clinique = cliniqueRepository.findByNom(nomClient);
        medecin.getCliniques().add(clinique);
        clinique.getMedecins().add(medecin);



    }


}
