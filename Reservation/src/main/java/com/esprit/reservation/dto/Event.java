package com.esprit.reservation.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

    private Integer id;
    private String nom_event;
    private String lieu_event;
    private String date_debut;
    private String date_fin;
}
