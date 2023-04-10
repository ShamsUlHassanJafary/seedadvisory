package com.example.seedadvisory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.seedadvisory.entity.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

}
