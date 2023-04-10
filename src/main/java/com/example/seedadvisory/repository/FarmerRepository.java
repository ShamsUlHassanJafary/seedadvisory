package com.example.seedadvisory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.seedadvisory.entity.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {

}
