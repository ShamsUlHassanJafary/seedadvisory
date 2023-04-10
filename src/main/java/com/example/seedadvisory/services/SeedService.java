package com.example.seedadvisory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.seedadvisory.entity.Seed;
import com.example.seedadvisory.repository.SeedRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SeedService {

    @Autowired
    private SeedRepository seedRepository;

    public List<Seed> getAllSeeds() {
        return seedRepository.findAll();
    }

    public Optional<Seed> getSeedById(Long id) {
        return seedRepository.findById(id);
    }

    public Seed createSeed(Seed seed) {
        return seedRepository.save(seed);
    }

    public Seed updateSeed(Seed seed) {
        return seedRepository.save(seed);
    }

    public void deleteSeed(Long id) {
        seedRepository.deleteById(id);
    }
}
