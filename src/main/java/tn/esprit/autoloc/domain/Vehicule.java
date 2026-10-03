package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "vehicule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    @Column(nullable = false, unique = true, length = 20)
    private String immatriculation;

    @Column(nullable = false, length = 50)
    private String marque;

    @Column(nullable = false, length = 50)
    private String modele;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CategorieVehicule categorie;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutVehicule statut;

    // Association *-1 avec Agence : Plusieurs véhicules appartiennent à une agence
    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

    // Association 1-* avec Maintenance : Un véhicule subit plusieurs maintenances
    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    private List<Maintenance> maintenances;

    // Association *-* avec Equipement : Un véhicule possède plusieurs équipements (Génère la table de jointure)
    @ManyToMany
    @JoinTable(
            name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "vehicule_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    private List<Equipement> equipements;

    // Association 1-* avec Reservation : Un véhicule fait l'objet de plusieurs réservations
    @OneToMany(mappedBy = "vehicule")
    private List<Reservation> reservations;
}