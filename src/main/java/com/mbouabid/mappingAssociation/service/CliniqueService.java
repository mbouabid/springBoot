package com.mbouabid.mappingAssociation.service;

import com.mbouabid.mappingAssociation.entities.Clinique;
import com.mbouabid.mappingAssociation.entities.Medecin;
import org.springframework.stereotype.Service;


public interface CliniqueService {

    Medecin  findByNom(String nom);

    public Clinique ajouterClinique (Clinique clinique);
    public Medecin ajouterMedecin (Medecin medecin);
    public  void affecterMedecinClinique(String nomMedecin,String nomClient);

}
