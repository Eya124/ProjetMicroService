package com.esprit.microservices.event;

import com.esprit.microservices.event.dto.Reservation;
import com.esprit.microservices.event.feign.EventInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    private EventInterface eventInterface;
    /*public Integer numberEvent() {
        return eventInterface.getAllReservations().size();
    }*/
    public Integer numberReservationsByEvent(Long idEvent) {
        List<Reservation> reservations = eventInterface.getReservationsByEvent(idEvent);
        return reservations.size();
    }

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public Event EventByNom(String nom) {
        return eventRepository.findByNomevent(nom);
    }
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> SearchEventById(Integer id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Integer id, Event updatedEvent) {
        if (eventRepository.existsById(id)) {
            updatedEvent.setId(id);
            return eventRepository.save(updatedEvent);
        }
        return null; // Handle not found error
    }

    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getEventsByStatus(Event.Status status) {
        return eventRepository.findByIsActive(status);
    }

    public void deleteReservationsByEvent(Long idEvent) {
        // Récupérer les réservations associées à l'événement
        List<Reservation> reservations = eventInterface.getReservationsByEvent(idEvent);

        // Supprimer les réservations récupérées
        for (Reservation reservation : reservations) {
            // Utiliser l'interface Feign pour supprimer chaque réservation individuellement
            eventInterface.deleteReservation(reservation.getId());
        }

        eventRepository.deleteById(Math.toIntExact(idEvent));
    }


}
