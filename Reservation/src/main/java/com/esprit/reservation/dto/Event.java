package com.esprit.reservation.dto;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private String nomevent;
    private String lieuevent;
    private String datedebut;
    private String datefin;
    private String imageevent;

    @Enumerated(EnumType.STRING)
    private Status isActive;

    public enum Status {
        Active,
        Inactive
    }
}
