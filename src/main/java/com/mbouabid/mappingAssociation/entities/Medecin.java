package com.mbouabid.mappingAssociation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Medecin {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String specialite;
    private String email;
    @OneToMany (mappedBy = "medecin")
    private Collection<RendezVous> rendezVous;
    @ManyToMany (fetch = FetchType.EAGER)
    private Collection<Clinique> cliniques = new ArrayList<>();
}
