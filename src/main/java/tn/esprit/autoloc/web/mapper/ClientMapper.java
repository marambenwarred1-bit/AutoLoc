package tn.esprit.autoloc.web.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.web.dto.ClientResponseDTO;

@Component
public class ClientMapper {

    public ClientResponseDTO toDto(Client client) {
        if (client == null) {
            return null;
        }
        return ClientResponseDTO.builder()
                .id(client.getIdClient())               .nom(client.getNom())
                .prenom(client.getPrenom())
                .email(client.getEmail())
                .numPermis(client.getNumPermis())
                .build();
    }

    public Client toEntity(ClientResponseDTO dto) {
        if (dto == null) {
            return null;
        }
        Client client = new Client();
        client.setIdClient(dto.getId());       client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setEmail(dto.getEmail());
        client.setNumPermis(dto.getNumPermis());
        return client;
    }
}