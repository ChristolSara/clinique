package fr.clinique.clinique.service;

import fr.clinique.clinique.models.Consultation;
import fr.clinique.clinique.models.Medecin;
import fr.clinique.clinique.models.Patient;
import fr.clinique.clinique.models.RendezVous;

public interface cliniqueService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
