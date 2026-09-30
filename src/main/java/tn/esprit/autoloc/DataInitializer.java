package tn.esprit.autoloc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    private final VehiculeRepository vehiculeRepository;

    public DataInitializer(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (vehiculeRepository.count() == 0) {
            Vehicule v1 = new Vehicule(
                    null,
                    "200-TUN-1234",
                    "Peugeot",
                    "208",
                    CategorieVehicule.CITADINE,
                    new BigDecimal("90.00"),
                    StatutVehicule.DISPONIBLE
            );

            Vehicule v2 = new Vehicule(
                    null,
                    "210-TUN-5678",
                    "Volkswagen",
                    "Golf 8",
                    CategorieVehicule.BERLINE,
                    new BigDecimal("150.00"),
                    StatutVehicule.LOUE
            );

            Vehicule v3 = new Vehicule(
                    null,
                    "220-TUN-9012",
                    "Hyundai",
                    "Tucson",
                    CategorieVehicule.SUV,
                    new BigDecimal("210.00"),
                    StatutVehicule.MAINTENANCE
            );

            vehiculeRepository.save(v1);
            vehiculeRepository.save(v2);
            vehiculeRepository.save(v3);

            System.out.println("Données de démonstration insérées avec succès dans la table vehicule !");
        }
    }
}