package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;
import java.util.List;

@Service
public class PaiementService implements IPaiementService {
    private final PaiementRepository paiementRepository;
    public PaiementService(PaiementRepository paiementRepository) { this.paiementRepository = paiementRepository; }

    @Override public List<Paiement> retrieveAllPaiements() { return (List<Paiement>) paiementRepository.findAll(); }
    @Override public Paiement addPaiement(Paiement paiement) { return paiementRepository.save(paiement); }
    @Override public Paiement updatePaiement(Paiement paiement) { return paiementRepository.save(paiement); }
    @Override public Paiement retrievePaiement(Long idPaiement) { return paiementRepository.findById(idPaiement).orElse(null); }
    @Override public void removePaiement(Long idPaiement) { paiementRepository.deleteById(idPaiement); }
}