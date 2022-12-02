package com.mbouabid.mappingAssociation;

import com.mbouabid.mappingAssociation.entities.Clinique;
import com.mbouabid.mappingAssociation.entities.Medecin;
import com.mbouabid.mappingAssociation.entities.Patient;
import com.mbouabid.mappingAssociation.entities.RendezVous;
import com.mbouabid.mappingAssociation.service.CliniqueService;
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
	@Autowired
	private PatientService patientService;
	@Autowired
	private RendezVousService rendezVousService;
	@Autowired
	private CliniqueService cliniqueService;

	public static void main(String[] args) {

		SpringApplication.run(MappingAssociationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// cas de many to one, one to many patients-rendezvous
		/*Patient p = new Patient(null,"mohamed",
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
		patientService.reserve(p,rdv2);*/

		// cas de many to many medecins-cliniques
		cliniqueService.ajouterMedecin(new Medecin(null,"mohamed","gastro","mohamed@gmail.com",null,null));
		cliniqueService.ajouterMedecin(new Medecin(null,"ali","dermato","ali@gmail.com",null,null));
		cliniqueService.ajouterClinique(new Clinique(null,"chifaa","Medenine",null));
		cliniqueService.ajouterClinique(new Clinique(null,"asalaam","Medenine",null));
		cliniqueService.ajouterClinique(new Clinique(null,"oulysse","Medenine",null));
		cliniqueService.affecterMedecinClinique("mohamed","chifaa");
		cliniqueService.affecterMedecinClinique("mohamed","asalaam");
		cliniqueService.affecterMedecinClinique("ali","oulysse");
		Medecin medecin =cliniqueService.findByNom("mohamed");
		System.out.println(medecin.getNom()+ " "
				+medecin.getEmail());
		medecin.getCliniques().forEach(c->{
			System.out.println(c.getNom()+ " à "+ c.getAdresse());

		});


	}
}
