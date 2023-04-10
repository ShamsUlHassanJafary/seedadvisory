package com.example.seedadvisory.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "advisories")
@Data
public class Advisory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    @ManyToOne
    @JoinColumn(name = "seed_id")
    private Seed seed;

    @ManyToOne
    @JoinColumn(name = "soil_type_id")
    private SoilType soilType;

    private Date planting_date;
    private String recommended_fertilizers;
    private String pest_control_measures;
    private String irrigation_schedule;
    private String tips;

    // Getters and setters
    // ...
}
