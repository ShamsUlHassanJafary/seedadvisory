package com.example.seedadvisory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.seedadvisory.entity.Crop;
import com.example.seedadvisory.repository.CropRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    public Crop createCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public Crop updateCrop(String name, Crop crop) {
        Crop existingCrop = cropRepository.findById(name).orElse(null);
        if (existingCrop != null) {
            existingCrop.setScientific_name(crop.getScientific_name());
            existingCrop.setFamily(crop.getFamily());
            existingCrop.setGrowth_duration(crop.getGrowth_duration());
            existingCrop.setIdeal_temperature(crop.getIdeal_temperature());
            existingCrop.setIdeal_rainfall(crop.getIdeal_rainfall());
            existingCrop.setPlanting_season(crop.getPlanting_season());
            existingCrop.setHarvest_season(crop.getHarvest_season());
            return cropRepository.save(existingCrop);
        }
        return null;
    }

    public Crop getCropByName(String name) {
        return cropRepository.findById(name).orElse(null);
    }

    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    public void deleteCrop(String name) {
        cropRepository.deleteById(name);
    }
}
