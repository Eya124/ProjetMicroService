package com.esprit.reservation.feign;
import com.esprit.reservation.dto.Event;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name ="EVENTSERVICE")
public interface ReservationInterface {

    @GetMapping("/events")
    public List<Event> getAllEvents();
    @GetMapping("/events/nom/{nom}")
    public Event getEventBynom(@PathVariable String nom);
    @GetMapping("/events/{id}")
    public Optional<Event> getEventById(@PathVariable Integer id) ;

}
