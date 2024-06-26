package com.esprit.microservices.event.feign;

import com.esprit.microservices.event.dto.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="Reservation")
public interface EventInterface {

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations();
    @GetMapping("/reservations/events/{idEvent}")
    public List<Reservation> getReservationsByEvent(@PathVariable Long idEvent);
    @DeleteMapping("reservations/{id}")
    public void deleteReservation(@PathVariable Long id);
    /*@DeleteMapping("/reservations/events/{idEvent}")
    public void deleteReservationsByEvent(@PathVariable Long idEvent);*/

}
