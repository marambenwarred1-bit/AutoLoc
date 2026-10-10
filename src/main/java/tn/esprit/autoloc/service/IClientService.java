package tn.esprit.autoloc.service;

import tn.esprit.autoloc.web.dto.ClientResponseDTO;
import java.util.List;

public interface IClientService {
    List<ClientResponseDTO> retrieveAllClients();
    ClientResponseDTO retrieveClient(Long idClient);
    ClientResponseDTO addClient(ClientResponseDTO clientDto);
    ClientResponseDTO updateClient(ClientResponseDTO clientDto);
    void removeClient(Long idClient);
    List<ClientResponseDTO> addClients(List<ClientResponseDTO> clientDtos);
}