package ma.enset.activity__2__patient.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;

@Entity
@Data // concerne Getters et Setters
@NoArgsConstructor @AllArgsConstructor @Builder
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    @NotEmpty
    @Size(min = 3, max =40)
        private String nom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date dateNaissanec;
        private boolean malade;
    @DecimalMin("20")
        private int score;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
        private Collection<RendezVous> rendezVous;
}
