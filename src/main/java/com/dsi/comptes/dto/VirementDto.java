package com.dsi.comptes.dto;

import lombok.Data;

@Data
public class VirementDto {
    private Long codeEmetteur;
    private  Long codeBenificiare;
    private double montant;
}
