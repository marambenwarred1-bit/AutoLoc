package tn.esprit.autoloc.service;

import tn.esprit.autoloc.web.dto.VehiculeResponseDTO;
import java.util.List;

public interface IVehiculeService {
    List<VehiculeResponseDTO> retrieveAllVehicules();
    VehiculeResponseDTO retrieveVehicule(Long idVehicule);
    VehiculeResponseDTO addVehicule(VehiculeResponseDTO vehiculeDto);
    VehiculeResponseDTO updateVehicule(VehiculeResponseDTO vehiculeDto);
    void removeVehicule(Long idVehicule);
}