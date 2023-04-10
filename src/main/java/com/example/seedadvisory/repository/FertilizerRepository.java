package com.example.seedadvisory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.seedadvisory.entity.Fertilizer;

@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

}
