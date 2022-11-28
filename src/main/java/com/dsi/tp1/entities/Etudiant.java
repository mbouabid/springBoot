package com.dsi.tp1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "ETUDIANTS")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOM")
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private int moyenne;
    private Boolean bilingue;


}
