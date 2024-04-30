package ma.enset.activity__2__patient.repositories;

import ma.enset.activity__2__patient.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

}
