package com.example.geohub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.geohub.model.Country;
import com.example.geohub.model.City;
import com.example.geohub.service.CityJpaService;
// Write your code here

@RestController
public class CityController {

    @Autowired
    private CityJpaService mcjs;

    @GetMapping("/countries/cities")
    public ArrayList<City> allCity() {
        return mcjs.allCity();
    }

    @GetMapping("/countries/cities/{cityId}")
    public City eachCity(@PathVariable("cityId") int cityId) {
        return mcjs.eachCity(cityId);
    }

    @PostMapping("/countries/cities")
    public City addCity(@RequestBody City city) {
        return mcjs.addCity(city);
    }

    @PutMapping("/countries/cities/{cityId}")
    public City updateCity(@PathVariable("cityId") int cityId, @RequestBody City city) {
        return mcjs.updateCity(cityId, city);
    }

    @DeleteMapping("/countries/cities/{cityId}")
    public void deleteCity(@PathVariable("cityId") int cityId) {
        mcjs.deleteCity(cityId);
    }

    @GetMapping("/cities/{cityId}/country")
    public Country getCountry(@PathVariable("cityId") int cityId) {
        return mcjs.getCountry(cityId);
    }
}