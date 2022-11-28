package com.dsi.comptes;

import com.dsi.comptes.entities.Compte;
import com.dsi.comptes.enums.TypeCompte;
import com.dsi.comptes.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
/*@OpenAPIDefinition(info =
@Info(title = "Comptes API", version = "${springdoc.version}", description = "Documentation Comptes API v1.0")
)*/
public class CompteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompteApplication.class,
				args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository,
							RepositoryRestConfiguration restConfiguration){
		return args ->{
			compteRepository.save(new Compte(null,100000,new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(null,50000,new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null,10000,new Date(), TypeCompte.COURANT));
			compteRepository.findAll().forEach(cp->{
				System.out.print(cp.getType()+ " ");
				System.out.print(cp.getSolde());
				System.out.println("");
			});
			restConfiguration.exposeIdsFor(Compte.class);
		};
	}
}
