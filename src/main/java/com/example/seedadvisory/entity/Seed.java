package com.example.seedadvisory.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "seeds")
@Data
public class Seed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_name", referencedColumnName = "name")
    private Crop crop;

    private String brand;
    private Double germination_rate;
    private Double seed_rate;
    private Integer maturity_duration;
    private String disease_resistance;
    private String special_features;
    private String suitableLocations;
    private String suitableSoilTypes;

    // Getters and setters
    // ...
}
