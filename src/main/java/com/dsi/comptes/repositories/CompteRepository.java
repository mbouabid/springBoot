package com.dsi.comptes.repositories;

import com.dsi.comptes.entities.Compte;
import com.dsi.comptes.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
//@RepositoryRestResource for spring data REst
public interface CompteRepository extends JpaRepository<Compte,Long> {
    @RestResource (path = "byType")
    List<Compte> findByType(@Param(value = "type") TypeCompte typeCompte);
}
