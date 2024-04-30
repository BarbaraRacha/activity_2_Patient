package ma.enset.activity__2__patient.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data // concerne Getters et Setters
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV status;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // cette ligne pour résoudre le probleme de "dépendances cycliques"
    // pcq l'affcihage de la liste des patients sur le web sans ce code génère une infinité de lignes
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous", fetch = FetchType.LAZY)
    private Consultation consultation;
}
