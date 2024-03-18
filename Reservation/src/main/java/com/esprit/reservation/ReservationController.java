package com.esprit.reservation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/centres/{idCentre}")
    public List<Reservation> getReservationsByCentre(@PathVariable Long idCentre) {
        return reservationService.getReservationsByCentre(idCentre);
    }

    @GetMapping("/events/{idEvent}")
    public List<Reservation> getReservationsByEvent(@PathVariable Long idEvent) {
        return reservationService.getReservationsByEvent(idEvent);
    }

    @GetMapping("/users/{idUser}")
    public List<Reservation> getReservationsByUser(@PathVariable Long idUser) {
        return reservationService.getReservationsByUser(idUser);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservation.setId(id);
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
