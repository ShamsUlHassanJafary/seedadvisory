package com.example.seedadvisory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.seedadvisory.entity.Crop;
import com.example.seedadvisory.entity.Seed;
import com.example.seedadvisory.entity.SoilType;
import com.example.seedadvisory.repository.SeedRepository;
import com.example.seedadvisory.repository.SoilTypeRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeedRecommendationService {

    @Autowired
    private SeedRepository seedRepository;

    @Autowired
    private SoilTypeRepository soilTypeRepository;

    // public List<String> recommendSeeds(String location, String soilType, String
    // cropName) {
    // // Get all the suitable seeds for the given location and crop
    // List<Seed> suitableSeeds = seedRepository.findAll()
    // .stream()
    // .filter(seed -> isSuitableForLocation(seed, location))
    // .filter(seed -> seed.getCrop() != null &&
    // seed.getCrop().getName().equals(cropName))
    // .filter(seed -> isSuitableForSoilType(seed,
    // soilTypeRepository.findByName(soilType)))
    // .collect(Collectors.toList());

    // // Map the seed names to a list of strings
    // return suitableSeeds.stream()
    // .map(Seed::getName)
    // .collect(Collectors.toList());
    // }

    private boolean isSuitableForLocation(Seed seed, String location) {
        // Get the suitable locations for the seed from the database
        String suitableLocations = seed.getSuitableLocations();

        // If the suitableLocations field is empty or not specified, return true (do not
        // filter out the seed)
        if (suitableLocations == null || suitableLocations.isEmpty()) {
            return true;
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
            return true;
        }

        // Split the suitable soil types into a list and check if the provided soil type
        // ID is in the list
        List<String> suitableSoilTypesList = Arrays.asList(suitableSoilTypes.split(","));
        return suitableSoilTypesList.stream()
                .anyMatch(suitableSoilTypeId -> Long.parseLong(suitableSoilTypeId.trim()) == soilType.getId());
    }

    private Map<String, SoilType> soilTypeCache = new HashMap<>();

    // private boolean isSuitableForSoilType(Seed seed, String soilTypeName) {
    // SoilType soilType = soilTypeCache.computeIfAbsent(soilTypeName,
    // soilTypeRepository::findByName);
    // return seed.getSuitableSoilTypes().equals(soilType);
    // }

}
