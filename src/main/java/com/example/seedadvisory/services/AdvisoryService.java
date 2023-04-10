package com.example.seedadvisory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.seedadvisory.entity.Advisory;
import com.example.seedadvisory.repository.AdvisoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdvisoryService {

    @Autowired
    private AdvisoryRepository advisoryRepository;

    public List<Advisory> getAllAdvisories() {
        return advisoryRepository.findAll();
    }

    public Optional<Advisory> getAdvisoryById(Long id) {
        return advisoryRepository.findById(id);
    }

    public Advisory createAdvisory(Advisory advisory) {
        return advisoryRepository.save(advisory);
    }

    public Advisory updateAdvisory(Advisory advisory) {
        return advisoryRepository.save(advisory);
    }

}
