package fr.clinique.clinique.repositories;

import fr.clinique.clinique.models.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
