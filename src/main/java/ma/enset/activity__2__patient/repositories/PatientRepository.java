package ma.enset.activity__2__patient.repositories;

import ma.enset.activity__2__patient.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String nom);
    Page<Patient> findByNomContains(String keyword, Pageable pageable); // "Pageable" obligatoire pour les fct ratournant "Page"
    List<Patient> findAllByNomContaining(String mc);
    List<Patient> findAllByDateNaissanecGreaterThan(Date date);

    @Query("select p from Patient p where p.nom like :x")
    List<Patient> searchByQuery(@Param("x") String mc);
    @Transactional
    @Modifying
    @Query("update Patient p set p.score = :x where p.nom like :y")
    void updateScoreByName(@Param("x") int x, @Param("y") String y);
}
