package com.esprit.microservices.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class Reclamation {
    private int $id;
    private String $sujet;
    private String $message;
    private Date $createAt;
    private String $statut;
    private int $userId;
    private String $priorite;
    private String $departement;

    /*public Object getId() {
    }

    public Object getUserId() {
    }*/
}
