package fr.clinique.clinique;

import fr.clinique.clinique.models.*;
import fr.clinique.clinique.repositories.ConsultationRepository;
import fr.clinique.clinique.repositories.MedecinRepository;
import fr.clinique.clinique.repositories.PatientRepository;
import fr.clinique.clinique.repositories.RendezVousRepository;
import fr.clinique.clinique.service.cliniqueService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class CliniqueApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CliniqueApplication.class, args);
	}

	//@Bean
	CommandLineRunner start(cliniqueService cliniqueService,PatientRepository patientRepository,RendezVousRepository rendezVousRepository,MedecinRepository medecinRepository){
		return  args -> {
			Stream.of("jean","sara","ilyane").forEach(
					name ->{
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
					cliniqueService.savePatient(patient);

					}
			);
			Stream.of("dray","lavie","loukia").forEach(
					name ->{
						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@outlook.fr");
						medecin.setSpecialite(Math.random()>0.5?"cardio":"dentiste");
						cliniqueService.saveMedecin(medecin);

					});

			//creer rdv
			Patient patient = patientRepository.findByNom("jean");

			Medecin medecin = medecinRepository.findByNom("lavie");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin);
			RendezVous saveRDV = cliniqueService.saveRendezVous(rendezVous);

			//creer consultation

			RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(rendezVous1.getDate());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("rapport de consultation");
			cliniqueService.saveConsultation(consultation);




		};

	}
}
