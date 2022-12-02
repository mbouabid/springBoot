package com.mbouabid.mappingAssociation.service;

import com.mbouabid.mappingAssociation.entities.RendezVous;
import com.mbouabid.mappingAssociation.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RendezVousServiceImpl implements RendezVousService{
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Override
    public void save(RendezVous rdv) {
        rendezVousRepository.save(rdv);

    }

    @Override
    public RendezVous findById(Long id) {
        return rendezVousRepository.findById(id).get();
    }
}
