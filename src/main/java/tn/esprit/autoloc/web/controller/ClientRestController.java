package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.service.IClientService;
import tn.esprit.autoloc.web.dto.ClientResponseDTO;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Client Management", description = "Opérations CRUD avec DTO pour la gestion des clients")
public class ClientRestController {

    private final IClientService clientService;

    public ClientRestController(IClientService clientService) {
        this.clientService = clientService;
    }

    @Operation(summary = "Récupérer tous les clients (DTO)")
    @ApiResponse(responseCode = "200", description = "Liste des clients récupérée avec succès")
    @GetMapping
    public List<ClientResponseDTO> getAllClients() {
        return clientService.retrieveAllClients();
    }

    @Operation(summary = "Récupérer un client par son ID (DTO)")
    @ApiResponse(responseCode = "200", description = "Client trouvé")
    @ApiResponse(responseCode = "404", description = "Client non trouvé")
    @GetMapping("/{id}")
    public ClientResponseDTO getClientById(@PathVariable("id") Long id) {
        return clientService.retrieveClient(id);
    }

    @Operation(summary = "Ajouter un nouveau client (DTO)")
    @ApiResponse(responseCode = "201", description = "Client créé avec succès")
    @PostMapping
    public ClientResponseDTO createClient(@RequestBody ClientResponseDTO clientDto) {
        return clientService.addClient(clientDto);
    }

    @Operation(summary = "Mettre à jour un client existant (DTO)")
    @ApiResponse(responseCode = "200", description = "Client mis à jour avec succès")
    @PutMapping
    public ClientResponseDTO updateClient(@RequestBody ClientResponseDTO clientDto) {
        return clientService.updateClient(clientDto);
    }

    @Operation(summary = "Supprimer un client par son ID")
    @ApiResponse(responseCode = "200", description = "Client supprimé avec succès")
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.removeClient(id);
    }
}