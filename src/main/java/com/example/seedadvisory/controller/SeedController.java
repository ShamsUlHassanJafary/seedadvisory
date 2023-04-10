package com.example.seedadvisory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.seedadvisory.entity.Seed;
import com.example.seedadvisory.model.SeedDto;
import com.example.seedadvisory.services.PdfGenerator;
import com.example.seedadvisory.services.SeedService;
import com.example.seedadvisory.services.TestService;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seeds")
public class SeedController {

    @Autowired
    private SeedService seedService;

    @Autowired
    private TestService service;

    @Autowired
    private PdfGenerator pdfGenerator;

    @GetMapping
    public ResponseEntity<List<Seed>> getAllSeeds() {
        return ResponseEntity.ok(seedService.getAllSeeds());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seed> getSeedById(@PathVariable Long id) {
        Optional<Seed> seed = seedService.getSeedById(id);
        return seed.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Seed> createSeed(@RequestBody Seed seed) {
        return ResponseEntity.ok(seedService.createSeed(seed));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seed> updateSeed(@PathVariable Long id, @RequestBody Seed seed) {
        seed.setId(id);
        return ResponseEntity.ok(seedService.updateSeed(seed));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeed(@PathVariable Long id) {
        seedService.deleteSeed(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/seeds/{location}/{soilType}/{cropName}/report")
    public ResponseEntity<InputStreamResource> generateSeedReport(
            @PathVariable String location,
            @PathVariable String soilType,
            @PathVariable String cropName) {

        List<SeedDto> seeds = service.recommendSeeds(location, soilType, cropName);

        ByteArrayInputStream bis = pdfGenerator.generateSeedReport(seeds);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=seed-report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
