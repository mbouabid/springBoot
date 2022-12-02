package com.mbouabid.mappingAssociation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data  @NoArgsConstructor  @AllArgsConstructor
public class Clinique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    @ManyToMany (mappedBy = "cliniques",fetch = FetchType.EAGER)
    private Collection<Medecin> medecins = new ArrayList<>();

}
