package com.example.seedadvisory.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "soil_types")
@Data
public class SoilType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String texture;
    private String ph_range;
    private String nutrients;
    private String drainage_rate;

    // Getters and setters
    // ...
}
