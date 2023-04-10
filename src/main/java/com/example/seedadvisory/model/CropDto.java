package com.example.seedadvisory.model;

import lombok.Data;

@Data
public class CropDto {
    private Long id;
    private String name;
    private String scientificName;
    private String family;
    private Integer growthDuration;
    private Double idealTemperature;
    private Double idealRainfall;
    private String plantingSeason;
    private String harvestSeason;
}
