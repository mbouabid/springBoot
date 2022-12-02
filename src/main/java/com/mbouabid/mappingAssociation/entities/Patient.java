package com.mbouabid.mappingAssociation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    //fetch = FetchType.LAZY
    @OneToMany (mappedBy = "patient", fetch = FetchType.EAGER)
    private Collection<RendezVous> rendezVous;
}
