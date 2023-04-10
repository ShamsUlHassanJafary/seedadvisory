package com.example.seedadvisory.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "farmers")
@Data
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact_number;
    private String email;
    private String location;
    private Double farm_size;
    private Date join_date;

    // Getters and setters
    // ...
}
