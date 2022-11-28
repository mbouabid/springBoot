package com.dsi.comptes.web;

import com.dsi.comptes.dto.VirementDto;
import com.dsi.comptes.entities.Compte;
import com.dsi.comptes.repositories.CompteRepository;
import com.dsi.comptes.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompteRestController {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    CompteService compteService;

    @GetMapping(path = "/comptes")
    public List<Compte> listeCompte(){
        return compteRepository.findAll();
    }

    @GetMapping(path = "/comptes/{id}")
    public Compte getCompte(@PathVariable Long id){
        return compteRepository.findById(id).get();
    }

    @PostMapping(path = "/comptes")
    public Compte save (@RequestBody Compte compte){
        return  compteRepository.save(compte);}
    @PutMapping(path = "/comptes/{id}")
    public Compte update (@PathVariable Long id, @RequestBody Compte compte){
        compte.setCode(id);
        return  compteRepository.save(compte);
    }
    @DeleteMapping(path = "/comptes/{id}")
    public void delete(@PathVariable Long id){
        compteRepository.deleteById(id);
    }
    @PutMapping(path = "/comptes/virement")
    public void virement(@RequestBody VirementDto virementDto){
        compteService.virement(virementDto.getCodeEmetteur(),
                virementDto.getCodeBenificiare(),
                virementDto.getMontant());
    }
}
