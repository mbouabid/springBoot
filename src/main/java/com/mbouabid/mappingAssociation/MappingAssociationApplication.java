package com.mbouabid.mappingAssociation;

import com.mbouabid.mappingAssociation.entities.Patient;
import com.mbouabid.mappingAssociation.entities.RendezVous;
import com.mbouabid.mappingAssociation.service.PatientService;
import com.mbouabid.mappingAssociation.service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class MappingAssociationApplication implements CommandLineRunner {
	@Autowired PatientService patientService;
	@Autowired RendezVousService rendezVousService;

	public static void main(String[] args) {

		SpringApplication.run(MappingAssociationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Patient p = new Patient(null,"mohamed",
				"mohamed@gmail.com",new ArrayList<RendezVous>());
		RendezVous rdv = new RendezVous(null,new Date(),null,
				null,null);
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		RendezVous rdv2 = new RendezVous(null,tomorrow,null,
				null,null);
		patientService.save(p);
		rendezVousService.save(rdv);
		patientService.reserve(p,rdv);
		patientService.reserve(p,rdv2);
	}
}
