package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;
import java.util.List;

@Service
public class VehiculeService implements IVehiculeService {
    private final VehiculeRepository vehiculeRepository;
    public VehiculeService(VehiculeRepository vehiculeRepository) { this.vehiculeRepository = vehiculeRepository; }

    @Override public List<Vehicule> retrieveAllVehicules() { return (List<Vehicule>) vehiculeRepository.findAll(); }
    @Override public Vehicule addVehicule(Vehicule vehicule) { return vehiculeRepository.save(vehicule); }
    @Override public Vehicule updateVehicule(Vehicule vehicule) { return vehiculeRepository.save(vehicule); }
    @Override public Vehicule retrieveVehicule(Long idVehicule) { return vehiculeRepository.findById(idVehicule).orElse(null); }
    @Override public void removeVehicule(Long idVehicule) { vehiculeRepository.deleteById(idVehicule); }
}