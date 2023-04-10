package com.example.seedadvisory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.seedadvisory.entity.Weather;
import com.example.seedadvisory.repository.WeatherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    public List<Weather> getAllWeather() {
        return weatherRepository.findAll();
    }

    public Optional<Weather> getWeatherById(Long id) {
        return weatherRepository.findById(id);
    }

    public Weather createWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    public Weather updateWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    public void deleteWeather(Long id) {
        weatherRepository.deleteById(id);
    }
}
