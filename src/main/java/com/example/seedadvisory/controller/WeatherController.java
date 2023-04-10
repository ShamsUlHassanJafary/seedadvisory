package com.example.seedadvisory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.seedadvisory.entity.Weather;
import com.example.seedadvisory.services.WeatherService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public ResponseEntity<List<Weather>> getAllWeather() {
        return ResponseEntity.ok(weatherService.getAllWeather());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Weather> getWeatherById(@PathVariable Long id) {
        Optional<Weather> weather = weatherService.getWeatherById(id);
        return weather.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Weather> createWeather(@RequestBody Weather weather) {
        return ResponseEntity.ok(weatherService.createWeather(weather));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Weather> updateWeather(@PathVariable Long id, @RequestBody Weather weather) {
        weather.setId(id);
        return ResponseEntity.ok(weatherService.updateWeather(weather));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeather(@PathVariable Long id) {
        weatherService.deleteWeather(id);
        return ResponseEntity.noContent().build();
    }
}
