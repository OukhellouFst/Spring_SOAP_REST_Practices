package ma.dsbd.banqueservice;

import ma.dsbd.banqueservice.entities.Client;
import ma.dsbd.banqueservice.entities.Compte;
import ma.dsbd.banqueservice.entities.TypeCompte;
import ma.dsbd.banqueservice.repositories.ClientRepository;
import ma.dsbd.banqueservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class BanqueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanqueServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration repositoryRestConfiguration, ClientRepository clientRepository) {
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Compte.class);
            Client c1 = clientRepository.save(new Client(null,"hassan",null));
            Client c2 = clientRepository.save(new Client(null,"oussama",null));
            compteRepository.save(new Compte(null, Math.random()*9000,new Date(), TypeCompte.COURANT,c1));
            compteRepository.save(new Compte(null, Math.random()*9000,new Date(), TypeCompte.EPARGNE,c2));
            compteRepository.save(new Compte(null, Math.random()*9000,new Date(), TypeCompte.COURANT,c2));
            compteRepository.findAll().forEach(c -> {
                System.out.println(c.getSolde());
            });
        };
    }
}
