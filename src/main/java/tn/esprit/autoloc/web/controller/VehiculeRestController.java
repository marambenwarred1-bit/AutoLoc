package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@Tag(name = "Vehicule Management", description = "Opérations CRUD pour la gestion des véhicules")
public class VehiculeRestController {

    private final IVehiculeService vehiculeService;

    public VehiculeRestController(IVehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @Operation(summary = "Récupérer tous les véhicules")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules récupérée avec succès")
    @GetMapping
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @Operation(summary = "Récupérer un véhicule par son ID")
    @ApiResponse(responseCode = "200", description = "Véhicule trouvé")
    @ApiResponse(responseCode = "404", description = "Véhicule non trouvé")
    @GetMapping("/{id}")
    public Vehicule getVehiculeById(@PathVariable("id") Long id) {
        return vehiculeService.retrieveVehicule(id);
    }

    @Operation(summary = "Ajouter un nouveau véhicule")
    @ApiResponse(responseCode = "201", description = "Véhicule créé avec succès")
    @PostMapping
    public Vehicule createVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @Operation(summary = "Mettre à jour un véhicule existant")
    @ApiResponse(responseCode = "200", description = "Véhicule mis à jour avec succès")
    @PutMapping
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.updateVehicule(vehicule);
    }

    @Operation(summary = "Supprimer un véhicule par son ID")
    @ApiResponse(responseCode = "200", description = "Véhicule supprimé avec succès")
    @DeleteMapping("/{id}")
    public void deleteVehicule(@PathVariable("id") Long id) {
        vehiculeService.removeVehicule(id);
    }
}