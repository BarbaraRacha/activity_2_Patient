package ma.enset.activity__2__patient;

import ma.enset.activity__2__patient.entities.*;
import ma.enset.activity__2__patient.repositories.MedecinRepository;
import ma.enset.activity__2__patient.repositories.PatientRepository;
import ma.enset.activity__2__patient.repositories.RendezVousRepository;
import ma.enset.activity__2__patient.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class,args);
    }

    // Cette méthode permet de faire l'injection de dépendances "automatiquement"
    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository,
                            RendezVousRepository rendezVousRepository,
                            MedecinRepository medecinRepository){
        return args -> {
            Stream.of("Mohammed", "Hassan", "Ali", "Salma", "Halima").forEach(name -> {
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissanec(new Date());
                patient.setMalade(true);
                patient.setScore(25);
                hospitalService.savePatient(patient);
            });
            Stream.of("Aymane", "Najat", "Hanane").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                medecin.setEmail(name + "@gmail.com");
                hospitalService.saveMedecin(medecin);
            });

            Patient patient1 = patientRepository.findByNom("Mohammed");
            Patient patient2 = patientRepository.findById(1L).orElse(null);

            Medecin medecin1 = medecinRepository.findByNom("Hanane");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient1);
            rendezVous.setMedecin(medecin1);
            hospitalService.saveRendezVous(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de consultation ...");
            hospitalService.saveConsltation(consultation);
        };
    }
}
