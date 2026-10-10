package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.service.IVehiculeService;
import tn.esprit.autoloc.web.dto.VehiculeResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@Tag(name = "Vehicule Management", description = "Opérations CRUD avec DTO pour la gestion des véhicules")
public class VehiculeRestController {

    private final IVehiculeService vehiculeService;

    public VehiculeRestController(IVehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @Operation(summary = "Récupérer tous les véhicules (DTO)")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules récupérée avec succès")
    @GetMapping
    public List<VehiculeResponseDTO> getAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @Operation(summary = "Récupérer un véhicule par son ID (DTO)")
    @ApiResponse(responseCode = "200", description = "Véhicule trouvé")
    @GetMapping("/{id}")
    public VehiculeResponseDTO getVehiculeById(@PathVariable("id") Long id) {
        return vehiculeService.retrieveVehicule(id);
    }

    @Operation(summary = "Ajouter un nouveau véhicule (DTO)")
    @ApiResponse(responseCode = "201", description = "Véhicule créé avec succès")
    @PostMapping
    public VehiculeResponseDTO createVehicule(@RequestBody VehiculeResponseDTO vehiculeDto) {
        return vehiculeService.addVehicule(vehiculeDto);
    }

    @Operation(summary = "Mettre à jour un véhicule (DTO)")
    @ApiResponse(responseCode = "200", description = "Véhicule mis à jour avec succès")
    @PutMapping
    public VehiculeResponseDTO updateVehicule(@RequestBody VehiculeResponseDTO vehiculeDto) {
        return vehiculeService.updateVehicule(vehiculeDto);
    }

    @Operation(summary = "Supprimer un véhicule par son ID")
    @ApiResponse(responseCode = "200", description = "Véhicule supprimé avec succès")
    @DeleteMapping("/{id}")
    public void deleteVehicule(@PathVariable("id") Long id) {
        vehiculeService.removeVehicule(id);
    }
}