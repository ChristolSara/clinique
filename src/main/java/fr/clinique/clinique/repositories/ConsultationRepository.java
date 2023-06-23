package fr.clinique.clinique.repositories;

import fr.clinique.clinique.models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
