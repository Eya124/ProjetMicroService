package com.esprit.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservationService {



        @Autowired
        private ReservationRepository reservationRepository;

        public Reservation createReservation(Reservation reservation) {
            return reservationRepository.save(reservation);
        }

        public Reservation getReservationById(Long id) {
            return reservationRepository.findById(id.intValue()).orElse(null);
        }

        public List<Reservation> getAllReservations() {
            return reservationRepository.findAll();
        }

        public List<Reservation> getReservationsByCentre(Long idCentre) {
            return reservationRepository.findByIdCentre(idCentre);
        }

        public List<Reservation> getReservationsByEvent(Long idEvent) {
            return reservationRepository.findByIdEvent(idEvent);
        }

        public List<Reservation> getReservationsByUser(Long idUser) {
            return reservationRepository.findByIdUser(idUser);
        }

        public Reservation updateReservation(Reservation reservation) {
            return reservationRepository.save(reservation);
        }

        public void deleteReservation(Long id) {
            reservationRepository.deleteById(id.intValue());
        }
    }

