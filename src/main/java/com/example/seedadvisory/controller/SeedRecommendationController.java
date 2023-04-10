package com.example.seedadvisory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.seedadvisory.entity.Seed;
import com.example.seedadvisory.entity.SoilType;
import com.example.seedadvisory.repository.SoilTypeRepository;
import com.example.seedadvisory.services.SeedRecommendationService;

@RestController
@RequestMapping("/api/seed-recommendations")
public class SeedRecommendationController {

    @Autowired
    private SeedRecommendationService seedRecommendationService;
    @Autowired
    private SoilTypeRepository soilTypeRepository;

    // @GetMapping
    // public ResponseEntity<List<String>> getSeedRecommendations(
    // @RequestParam String location,
    // @RequestParam String soilTypeName,
    // @RequestParam String cropName) {

    // SoilType soilType = soilTypeRepository.findByName(soilTypeName);
    // System.out.println(soilType.getName());

    // if (soilType == null) {
    // return ResponseEntity.notFound().build();
    // }

    // List<String> recommendedSeeds =
    // seedRecommendationService.recommendSeeds(location, soilType.getName(),
    // cropName);
    // return ResponseEntity.ok(recommendedSeeds);
    // }
}
