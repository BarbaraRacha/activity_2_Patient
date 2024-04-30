package ma.enset.activity__2__patient.repositories;

import ma.enset.activity__2__patient.entities.Medecin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String medecin);
    Page<Medecin> findByNomContains(String keyword, Pageable pageable); // "Pageable" obligatoire pour les fct ratournant "Page"
    List<Medecin> findAllByNomContaining(String mc);
    @Query("select p from Medecin p where p.nom like :x")
    List<Medecin> searchByQuery(@Param("x") String mc);
}
