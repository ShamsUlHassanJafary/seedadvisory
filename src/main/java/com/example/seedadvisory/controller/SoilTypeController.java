package com.example.seedadvisory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.seedadvisory.entity.SoilType;
import com.example.seedadvisory.services.SoilTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/soil-types")
public class SoilTypeController {

    @Autowired
    private SoilTypeService soilTypeService;

    @GetMapping
    public ResponseEntity<List<SoilType>> getAllSoilTypes() {
        return ResponseEntity.ok(soilTypeService.getAllSoilTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoilType> getSoilTypeById(@PathVariable Long id) {
        Optional<SoilType> soilType = soilTypeService.getSoilTypeById(id);
        return soilType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SoilType> createSoilType(@RequestBody SoilType soilType) {
        return ResponseEntity.ok(soilTypeService.createSoilType(soilType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SoilType> updateSoilType(@PathVariable Long id, @RequestBody SoilType soilType) {
        soilType.setId(id);
        return ResponseEntity.ok(soilTypeService.updateSoilType(soilType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSoilType(@PathVariable Long id) {
        soilTypeService.deleteSoilType(id);
        return ResponseEntity.noContent().build();
    }
}
