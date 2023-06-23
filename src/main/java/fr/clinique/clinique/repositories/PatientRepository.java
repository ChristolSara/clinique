package fr.clinique.clinique.repositories;

import fr.clinique.clinique.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
