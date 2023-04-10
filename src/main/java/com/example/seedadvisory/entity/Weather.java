package com.example.seedadvisory.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "weather")
@Data
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String location;
    private Double temperature;
    private Double rainfall;
    private Double humidity;
    private Double wind_speed;
    private String cloud_coverage;

    // Getters and setters
    // ...
}
