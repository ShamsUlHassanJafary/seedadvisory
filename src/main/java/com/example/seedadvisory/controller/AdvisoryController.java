package com.example.seedadvisory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.seedadvisory.entity.Advisory;
import com.example.seedadvisory.services.AdvisoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/advisories")
public class AdvisoryController {

    @Autowired
    private AdvisoryService advisoryService;

    @GetMapping
    public ResponseEntity<List<Advisory>> getAllAdvisories() {
        return ResponseEntity.ok(advisoryService.getAllAdvisories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advisory> getAdvisoryById(@PathVariable Long id) {
        Optional<Advisory> advisory = advisoryService.getAdvisoryById(id);
        return advisory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Advisory> createAdvisory(@RequestBody Advisory advisory) {
        return ResponseEntity.ok(advisoryService.createAdvisory(advisory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Advisory> updateAdvisory(@PathVariable Long id, @RequestBody Advisory advisory) {
        advisory.setId(id);
        return ResponseEntity.ok(advisoryService.updateAdvisory(advisory));
    }

}
