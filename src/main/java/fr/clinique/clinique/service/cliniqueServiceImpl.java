package fr.clinique.clinique.service;

import fr.clinique.clinique.models.Consultation;
import fr.clinique.clinique.models.Medecin;
import fr.clinique.clinique.models.Patient;
import fr.clinique.clinique.models.RendezVous;
import fr.clinique.clinique.repositories.ConsultationRepository;
import fr.clinique.clinique.repositories.MedecinRepository;
import fr.clinique.clinique.repositories.PatientRepository;
import fr.clinique.clinique.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Transactional
@Service @AllArgsConstructor
public class cliniqueServiceImpl implements  cliniqueService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
