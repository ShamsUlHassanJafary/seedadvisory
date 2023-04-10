package com.example.seedadvisory.model;

import com.example.seedadvisory.entity.Crop;
import com.example.seedadvisory.entity.Seed;

import lombok.Data;

@Data
public class SeedDto {
    private Long id;
    private String name;
    private String suitableLocations;
    private String suitableSoilTypes;
    private CropDto cropDto;

    // constructors, getters, and setters

    public static SeedDto fromSeed(Seed seed) {
        SeedDto seedDto = new SeedDto();
        seedDto.setId(seed.getId());
        seedDto.setName(seed.getName());
        seedDto.setSuitableLocations(seed.getSuitableLocations());
        seedDto.setSuitableSoilTypes(seed.getSuitableSoilTypes());

        // populate the cropDto property
        Crop crop = seed.getCrop();
        if (crop != null) {
            CropDto cropDto = new CropDto();
            cropDto.setName(crop.getName());
            cropDto.setScientificName(crop.getScientific_name());
            cropDto.setFamily(crop.getFamily());
            cropDto.setGrowthDuration(crop.getGrowth_duration());
            cropDto.setIdealTemperature(crop.getIdeal_temperature());
            cropDto.setIdealRainfall(crop.getIdeal_rainfall());
            cropDto.setPlantingSeason(crop.getPlanting_season());
            cropDto.setHarvestSeason(crop.getHarvest_season());
            seedDto.setCropDto(cropDto);
        }

        return seedDto;
    }
}
