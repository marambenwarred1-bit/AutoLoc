package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;
import java.util.List;

@Service
public class ReservationService implements IReservationService {
    private final ReservationRepository reservationRepository;
    public ReservationService(ReservationRepository reservationRepository) { this.reservationRepository = reservationRepository; }

    @Override public List<Reservation> retrieveAllReservations() { return (List<Reservation>) reservationRepository.findAll(); }
    @Override public Reservation addReservation(Reservation reservation) { return reservationRepository.save(reservation); }
    @Override public Reservation updateReservation(Reservation reservation) { return reservationRepository.save(reservation); }
    @Override public Reservation retrieveReservation(Long idReservation) { return reservationRepository.findById(idReservation).orElse(null); }
    @Override public void removeReservation(Long idReservation) { reservationRepository.deleteById(idReservation); }
}