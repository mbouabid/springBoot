package com.mbouabid.mappingAssociation.repository;

import com.mbouabid.mappingAssociation.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
