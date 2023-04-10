package com.example.seedadvisory.testseed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.seedadvisory.entity.Crop;
import com.example.seedadvisory.entity.Seed;
import com.example.seedadvisory.entity.SoilType;
import com.example.seedadvisory.model.SeedDto;
import com.example.seedadvisory.services.TestService;

@RestController
public class testController {

    @Autowired
    private TestService testService;

    @GetMapping("soiltype/{name}")
    public SoilType getSoilTypeWithName(@PathVariable String name) {
        return testService.findSoilByName(name).get();
    }

    @GetMapping("recomended")
    public List<SeedDto> recommendSeeds(@RequestParam String location, @RequestParam String soilType,
            @RequestParam String cropName) {
        return testService.recommendSeeds(location, soilType, cropName);
    }

    @GetMapping("crop")
    public Crop getCrop(@RequestParam String name) {
        return testService.getCropById(name);
    }

    @GetMapping("allseeds")
    public List<Seed> getllSeeds() {
        return testService.allSeeds();
    }
}
