package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;
import tn.esprit.autoloc.web.dto.ClientResponseDTO;
import tn.esprit.autoloc.web.mapper.ClientMapper;
import java.util.List;

@Service
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientResponseDTO> retrieveAllClients() {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::toDto)
                .toList();
    }

    @Override
    public ClientResponseDTO addClient(ClientResponseDTO clientDto) {
        Client client = clientMapper.toEntity(clientDto);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toDto(savedClient);
    }

    @Override
    public ClientResponseDTO updateClient(ClientResponseDTO clientDto) {
        Client client = clientMapper.toEntity(clientDto);
        Client updatedClient = clientRepository.save(client);
        return clientMapper.toDto(updatedClient);
    }

    @Override
    public ClientResponseDTO retrieveClient(Long idClient) {
        Client client = clientRepository.findById(idClient).orElse(null);
        return clientMapper.toDto(client);
    }

    @Override
    public void removeClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }

    @Override
    public List<ClientResponseDTO> addClients(List<ClientResponseDTO> clientDtos) {
        List<Client> clients = clientDtos.stream()
                .map(clientMapper::toEntity)
                .toList();
        List<Client> savedClients = (List<Client>) clientRepository.saveAll(clients);
        return savedClients.stream()
                .map(clientMapper::toDto)
                .toList();
    }
}