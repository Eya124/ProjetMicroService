package com.example.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    private String pname;
    private String pcategory;
    private Date pdatepost = new Date(System.currentTimeMillis());
    private String description;
    private String pcity;
    private double pcoin;
}
