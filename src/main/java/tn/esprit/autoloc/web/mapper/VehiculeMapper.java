package tn.esprit.autoloc.web.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.web.dto.VehiculeResponseDTO;

@Component
public class VehiculeMapper {

    public VehiculeResponseDTO toDto(Vehicule vehicule) {
        if (vehicule == null) {
            return null;
        }
        return VehiculeResponseDTO.builder()
                .id(vehicule.getIdVehicule())
                .immatriculation(vehicule.getImmatriculation())
                .marque(vehicule.getMarque())
                .modele(vehicule.getModele())
                .prixJour(vehicule.getTarifJournalier() != null ? vehicule.getTarifJournalier().doubleValue() : null)
                .build();
    }

    public Vehicule toEntity(VehiculeResponseDTO dto) {
        if (dto == null) {
            return null;
        }
        Vehicule vehicule = new Vehicule();
        vehicule.setIdVehicule(dto.getId());
        vehicule.setImmatriculation(dto.getImmatriculation());
        vehicule.setMarque(dto.getMarque());
        vehicule.setModele(dto.getModele());
        if (dto.getPrixJour() != null) {
            vehicule.setTarifJournalier(java.math.BigDecimal.valueOf(dto.getPrixJour()));
        }
        return vehicule;
    }
}