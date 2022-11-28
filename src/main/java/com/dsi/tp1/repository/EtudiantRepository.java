package com.dsi.tp1.repository;

import com.dsi.tp1.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository  extends JpaRepository<Etudiant,Long> {
   // public List<Etudiant> findByNomContains(String nom);
   public Page<Etudiant> findByNomContains(String nom, Pageable pageable);
    public List<Etudiant> findByBilingue(boolean b);
    public List<Etudiant> findByNomContainsAndBilingue(String nom,boolean bilingue);
}
