package com.example.seedadvisory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.seedadvisory.entity.SoilType;
import com.example.seedadvisory.repository.SoilTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SoilTypeService {

    @Autowired
    private SoilTypeRepository soilTypeRepository;

    public List<SoilType> getAllSoilTypes() {
        return soilTypeRepository.findAll();
    }

    public Optional<SoilType> getSoilTypeById(Long id) {
        return soilTypeRepository.findById(id);
    }

    public SoilType createSoilType(SoilType soilType) {
        return soilTypeRepository.save(soilType);
    }

    public SoilType updateSoilType(SoilType soilType) {
        return soilTypeRepository.save(soilType);
    }

    public void deleteSoilType(Long id) {
        soilTypeRepository.deleteById(id);
    }
}
