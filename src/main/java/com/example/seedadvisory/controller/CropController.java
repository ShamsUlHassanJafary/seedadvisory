package com.example.seedadvisory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.seedadvisory.entity.Crop;
import com.example.seedadvisory.services.CropService;

import java.util.List;

@RestController
@RequestMapping("/crops")
public class CropController {

    @Autowired
    private CropService cropService;

    @PostMapping
    public ResponseEntity<Crop> createCrop(@RequestBody Crop crop) {
        Crop createdCrop = cropService.createCrop(crop);
        return new ResponseEntity<>(createdCrop, HttpStatus.CREATED);
    }

    @PutMapping("/{name}")
    public ResponseEntity<Crop> updateCrop(@PathVariable String name, @RequestBody Crop crop) {
        Crop updatedCrop = cropService.updateCrop(name, crop);
        if (updatedCrop != null) {
            return new ResponseEntity<>(updatedCrop, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Crop> getCropByName(@PathVariable String name) {
        Crop crop = cropService.getCropByName(name);
        if (crop != null) {
            return new ResponseEntity<>(crop, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Crop>> getAllCrops() {
        List<Crop> crops = cropService.getAllCrops();
        return new ResponseEntity<>(crops, HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteCrop(@PathVariable String name) {
        cropService.deleteCrop(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
