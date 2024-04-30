package ma.enset.activity__2__patient.service;

import ma.enset.activity__2__patient.entities.Consultation;
import ma.enset.activity__2__patient.entities.Medecin;
import ma.enset.activity__2__patient.entities.Patient;
import ma.enset.activity__2__patient.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsltation(Consultation consltation);
}
