package com.example.seedadvisory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.seedadvisory.entity.SoilType;

@Repository
public interface SoilTypeRepository extends JpaRepository<SoilType, Long> {

    Optional<SoilType> findByName(String soilName);

}
