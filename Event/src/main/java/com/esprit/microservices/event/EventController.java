package com.esprit.microservices.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    /*@GetMapping("/nbr")
    public Integer numberReservation() {
        return eventService.numberEvent();
    }*/
    @GetMapping("/reservations/count/{idEvent}")
    public Integer getReservationCountForEvent(@PathVariable Long idEvent) {
        return eventService.numberReservationsByEvent(idEvent);
    }
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping("/nom/{nom}")
    public Event getEventBynom(@PathVariable String nom) {
        return eventService.EventByNom(nom);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Optional<Event> getEventById(@PathVariable Integer id) {
        return eventService.SearchEventById(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
        //Event createdEvent = eventService.createEvent(event);
        //return new ResponseEntity<>(createdEvent, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Integer id, @RequestBody Event updatedEvent) {
        return eventService.updateEvent(id, updatedEvent);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
    }

    @GetMapping("/events/{status}")
    public List<Event> getEventsByStatus(@PathVariable(name = "status") String status) {
        if ("Active".equals(status) || "Inactive".equals(status)) {
            return eventService.getEventsByStatus(Event.Status.valueOf(status));
        } else {
            // Handle invalid status values here, for example, return an error response.
            // You could return a 404 Not Found or a custom error message.
            // For simplicity, we return an empty list in this example.
            return Collections.emptyList();
        }
    }
}
