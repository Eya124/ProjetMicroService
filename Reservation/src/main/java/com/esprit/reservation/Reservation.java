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
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idCentre;
    private Long idEvent;
    private Long idUser;
    private Date dateReservation;
    private String email;
    private String nomevent;
    private String lieuevent;
    private String datedebut;
    private String datefin;
    private String imageevent;




}