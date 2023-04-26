package com.company.company.service;

import com.company.company.service.entities.Medecin;
import com.company.company.service.entities.Patient;
import com.company.company.service.repositories.MedecinRepository;
import com.company.company.service.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class CompanyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyServiceApplication.class, args);
    }

    // methode qui s'execute au demmarage
    @Bean
    CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository)
    {
        return args -> {
            //patientRepository.save(new Patient(null,"Mecene", new Date(), false,null));
            Stream.of("Mecene Phrygien", "Guest House", "Ninja Hacking").forEach(name->{
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);

                patientRepository.save(patient);
            });

            // création medecin
            Stream.of("Medecin 01", "Medecin 02", "Medecin 03").forEach(name->{
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setSpecialite(Math.random()>0.5 ? "Cardio":"Dentiste");
                medecin.setEmail("email.medecin@spring.dev");
                medecinRepository.save(medecin);
            });
        };
    }

}
