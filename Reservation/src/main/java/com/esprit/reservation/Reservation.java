package com.esprit.reservation;

import com.esprit.reservation.dto.Event;
import jakarta.persistence.*;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idCentre;
    private String nom_event;
    private Long idEvent;
    private Long idUser;
    private Date dateReservation;
    private String email;


}