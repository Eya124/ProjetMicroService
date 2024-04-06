package com.esprit.microservices.event.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {

    private Long id;
    private Long idCentre;
    private Long idEvent;
    private Long idUser;
    private Date dateReservation;
    private String email;
}
