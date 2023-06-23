package fr.clinique.clinique.web;

import fr.clinique.clinique.models.Patient;
import fr.clinique.clinique.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PatientRestController {
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> patientsList(){
        return patientRepository.findAll();
    }
}
