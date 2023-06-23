package fr.clinique.clinique;

import fr.clinique.clinique.models.Patient;
import fr.clinique.clinique.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CliniqueApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CliniqueApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PatientRepository patientRepository){
		return  args -> {

			patientRepository.save(new Patient(null,"hassan",new Date(),false,null));
		};

	}
}
