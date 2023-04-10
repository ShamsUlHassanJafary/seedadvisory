package com.example.seedadvisory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.seedadvisory.entity.Seed;

@Repository
public interface SeedRepository extends JpaRepository<Seed, Long> {
}
