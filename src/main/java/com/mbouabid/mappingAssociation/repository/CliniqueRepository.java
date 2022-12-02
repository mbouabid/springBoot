package com.mbouabid.mappingAssociation.repository;

import com.mbouabid.mappingAssociation.entities.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CliniqueRepository extends JpaRepository<Clinique,Long> {
    public Clinique findByNom(String nom);
}
