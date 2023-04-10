package com.example.seedadvisory.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.seedadvisory.entity.Crop;
import com.example.seedadvisory.entity.Seed;
import com.example.seedadvisory.entity.SoilType;
import com.example.seedadvisory.model.SeedDto;
import com.example.seedadvisory.repository.CropRepository;
import com.example.seedadvisory.repository.SeedRepository;
import com.example.seedadvisory.repository.SoilTypeRepository;

@Service
public class TestService {

    @Autowired
    private SeedRepository seedRepository;

    @Autowired
    private SoilTypeRepository soilTypeRepository;

    @Autowired
    private CropRepository cropRepository;

    public Crop getCropById(String name) {
        return cropRepository.findById(name).get();
    }

    public Optional<SoilType> findSoilByName(String name) {
        return soilTypeRepository.findByName(name);
    }

    public List<SeedDto> recommendSeeds(String location, String soilType, String cropName) {
        List<Seed> suitableSeeds = seedRepository.findAll()
                .stream()
                .filter(seed -> isSuitableForLocation(seed, location))
                .filter(seed -> seed.getCrop() != null &&
                        seed.getCrop().getName().equals(cropName))
                .filter(seed -> isSuitableForSoilType(seed,
                        soilTypeRepository.findByName(soilType).get()))
                .collect(Collectors.toList());

        return suitableSeeds.stream()
                .map(SeedDto::fromSeed)
                .collect(Collectors.toList());
    }

    private boolean isSuitableForLocation(Seed seed, String location) {

        String suitableLocations = seed.getSuitableLocations();

        // If the suitableLocations field is empty or not specified, return true (do not
        // filter out the seed)
        if (suitableLocations == null || suitableLocations.isEmpty()) {
            return false;
        }

        // Split the suitable locations into a list and check if the provided location
        // is in the list
        List<String> suitableLocationsList = Arrays.asList(suitableLocations.split(","));
        return suitableLocationsList.stream()
                .anyMatch(suitableLocation -> suitableLocation.trim().equalsIgnoreCase(location));
    }

    private boolean isSuitableForSoilType(Seed seed, SoilType soilType) {
        // Get the suitable soil types for the seed from the database
        String suitableSoilTypes = seed.getSuitableSoilTypes();

        // If the suitableSoilTypes field is empty or not specified, return true (do not
        // filter out the seed)
        if (suitableSoilTypes == null || suitableSoilTypes.isEmpty()) {
            return false;
        }

        // Split the suitable soil types into a list and check if the provided soil type
        // ID is in the list
        List<String> suitableSoilTypesList = Arrays.asList(suitableSoilTypes.split(","));
        return suitableSoilTypesList.stream()
                .anyMatch(suitableSoilTypeId -> suitableSoilTypeId.trim().equalsIgnoreCase(soilType.getName()));
    }

    public List<Seed> allSeeds() {
        return seedRepository.findAll();
    }

}
