package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;
import tn.esprit.autoloc.web.dto.VehiculeResponseDTO;
import tn.esprit.autoloc.web.mapper.VehiculeMapper;

import java.util.List;

@Service
public class VehiculeService implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;

    public VehiculeService(VehiculeRepository vehiculeRepository, VehiculeMapper vehiculeMapper) {
        this.vehiculeRepository = vehiculeRepository;
        this.vehiculeMapper = vehiculeMapper;
    }

    @Override
    public List<VehiculeResponseDTO> retrieveAllVehicules() {
        List<Vehicule> vehicules = (List<Vehicule>) vehiculeRepository.findAll();
        return vehicules.stream()
                .map(vehiculeMapper::toDto)
                .toList();
    }

    @Override
    public VehiculeResponseDTO retrieveVehicule(Long idVehicule) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
        return vehiculeMapper.toDto(vehicule);
    }

    @Override
    public VehiculeResponseDTO addVehicule(VehiculeResponseDTO vehiculeDto) {
        Vehicule vehicule = vehiculeMapper.toEntity(vehiculeDto);
        Vehicule saved = vehiculeRepository.save(vehicule);
        return vehiculeMapper.toDto(saved);
    }

    @Override
    public VehiculeResponseDTO updateVehicule(VehiculeResponseDTO vehiculeDto) {
        Vehicule vehicule = vehiculeMapper.toEntity(vehiculeDto);
        Vehicule updated = vehiculeRepository.save(vehicule);
        return vehiculeMapper.toDto(updated);
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }
}