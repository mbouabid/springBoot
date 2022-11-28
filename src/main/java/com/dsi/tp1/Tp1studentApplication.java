package com.dsi.tp1;

import com.dsi.tp1.entities.Etudiant;
import com.dsi.tp1.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp1studentApplication implements CommandLineRunner {
	@Autowired
	EtudiantRepository etudiantRepository;

	public static void main(String[] args) {
		SpringApplication.run(Tp1studentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		etudiantRepository.save(new Etudiant(null,"mohamed",new Date(),25,true));
		etudiantRepository.save(new Etudiant(null,"fatma",new Date(),35,true));
		etudiantRepository.save(new Etudiant(null,"salah",new Date(),40,false));
		System.out.println("*****************************");
		etudiantRepository.findAll().forEach(e->{
			System.out.println(e.toString());
		});
		System.out.println("*****************************");
		Etudiant etudiant=etudiantRepository.findById(1L).get();
		System.out.println(etudiant.getNom());
		System.out.println("**************Nom contains***************");
		//List<Etudiant> etudiants =etudiantRepository.findByNomContains("f");
		Page <Etudiant> etudiants =etudiantRepository.findByNomContains("a",PageRequest.of(0,2));
		etudiants.getContent().forEach(System.out::println);
		System.out.println("*****************************");
		List<Etudiant> etudiantsBilingue =etudiantRepository.findByBilingue(true);
		etudiantsBilingue.forEach(System.out::println);
		System.out.println("*****************************");
		List<Etudiant> etudiantsByNameAndBil =etudiantRepository.findByNomContainsAndBilingue("o",true);
		etudiantsByNameAndBil.forEach(System.out::println);
		System.out.println("*****************************");
		//etudiantRepository.deleteById(3L);
		System.out.println("*****************************");
		Page<Etudiant> pageEtudiants = etudiantRepository.findAll(PageRequest.of(1,2));
		System.out.println("Nombre des pages: "+pageEtudiants.getTotalPages());
		pageEtudiants.getContent().forEach(e->{
			System.out.println(e.toString());
		});

	}
}
