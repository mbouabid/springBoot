package com.dsi.comptes.services;


public interface CompteService {
    public void virement(Long codeSource,
                         Long codeDestination,
                         double montant);
}
