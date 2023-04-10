package com.example.seedadvisory.entity;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "crops")
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Crop {

    @Id
    private String name;

    @NaturalId
    @Column(nullable = false)
    private String scientific_name;

    private String family;
    private Integer growth_duration;
    private Double ideal_temperature;
    private Double ideal_rainfall;
    private String planting_season;
    private String harvest_season;

    // Getters and setters
    // ...
}
