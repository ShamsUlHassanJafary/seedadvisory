package com.example.seedadvisory.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "fertilizers")
@Data
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String nutrient_content;
    private String application_rate;
    private String method_of_application;

    // Getters and setters
    // ...
}
