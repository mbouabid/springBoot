package com.mbouabid.mappingAssociation.repository;

import com.mbouabid.mappingAssociation.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
