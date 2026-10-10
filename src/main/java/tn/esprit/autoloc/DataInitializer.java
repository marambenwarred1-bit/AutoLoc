package tn.esprit.autoloc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);
    private final VehiculeRepository vehiculeRepository;

    public DataInitializer(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (vehiculeRepository.count() == 0) {
            Vehicule v1 = Vehicule.builder()
                    .immatriculation("200-TUN-1234")
                    .marque("Peugeot")
                    .modele("208")
                    .categorie(CategorieVehicule.CITADINE)
                    .tarifJournalier(new BigDecimal("90.00"))
                    .statut(StatutVehicule.DISPONIBLE)
                    .build();

            Vehicule v2 = Vehicule.builder()
                    .immatriculation("210-TUN-5678")
                    .marque("Volkswagen")
                    .modele("Golf 8")
                    .categorie(CategorieVehicule.BERLINE)
                    .tarifJournalier(new BigDecimal("150.00"))
                    .statut(StatutVehicule.LOUE)
                    .build();

            Vehicule v3 = Vehicule.builder()
                    .immatriculation("220-TUN-9012")
                    .marque("Hyundai")
                    .modele("Tucson")
                    .categorie(CategorieVehicule.SUV)
                    .tarifJournalier(new BigDecimal("210.00"))
                    .statut(StatutVehicule.MAINTENANCE)
                    .build();

            vehiculeRepository.save(v1);
            vehiculeRepository.save(v2);
            vehiculeRepository.save(v3);

            log.info("Données de démonstration insérées avec succès dans la table vehicule !");
        }
    }
}