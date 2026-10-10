package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;
import java.util.List;

@Service
public class EmployeService implements IEmployeService {
    private final EmployeRepository employeRepository;
    public EmployeService(EmployeRepository employeRepository) { this.employeRepository = employeRepository; }

    @Override public List<Employe> retrieveAllEmployes() { return (List<Employe>) employeRepository.findAll(); }
    @Override public Employe addEmploye(Employe employe) { return employeRepository.save(employe); }
    @Override public Employe updateEmploye(Employe employe) { return employeRepository.save(employe); }
    @Override public Employe retrieveEmploye(Long idEmploye) { return employeRepository.findById(idEmploye).orElse(null); }
    @Override public void removeEmploye(Long idEmploye) { employeRepository.deleteById(idEmploye); }
}