package com.mbouabid.mappingAssociation.service;

import com.mbouabid.mappingAssociation.entities.RendezVous;


public interface RendezVousService {
    void save (RendezVous rdv);
    RendezVous findById(Long id);
}
