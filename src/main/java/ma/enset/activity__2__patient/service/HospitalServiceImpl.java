package ma.enset.activity__2__patient.service;

import jakarta.transaction.Transactional;
import ma.enset.activity__2__patient.entities.Consultation;
import ma.enset.activity__2__patient.entities.Medecin;
import ma.enset.activity__2__patient.entities.Patient;
import ma.enset.activity__2__patient.entities.RendezVous;
import ma.enset.activity__2__patient.repositories.ConsultationRepository;
import ma.enset.activity__2__patient.repositories.MedecinRepository;
import ma.enset.activity__2__patient.repositories.PatientRepository;
import ma.enset.activity__2__patient.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository,
                               MedecinRepository medecinRepository,
                               RendezVousRepository rendezVousRepository,
                               ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

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
       // rendezVous.setId(UUID.randomUUID().toString()); => ce code est ajouté si ID est de type "STRING"
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsltation(Consultation consltation) {
        return consultationRepository.save(consltation);
    }
}
