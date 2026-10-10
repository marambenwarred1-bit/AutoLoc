package tn.esprit.autoloc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeResponseDTO {
    private Long id;
    private String immatriculation;
    private String marque;
    private String modele;
    private Double prixJour;
}