package com.example.geohub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.geohub.model.Country;
import com.example.geohub.service.CountryJpaService;

// Write your code here

@RestController
public class CountryController {

    @Autowired
    private CountryJpaService cjs;

    @GetMapping("/countries")
    public ArrayList<Country> allCountry() {
        return cjs.allCountry();
    }

    @GetMapping("/countries/{countryId}")
    public Country eachCountry(@PathVariable("countryId") int countryId) {
        return cjs.eachCountry(countryId);
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {
        return cjs.addCountry(country);
    }

    @PutMapping("/countries/{countryId}")
    public Country updateCountry(@PathVariable("countryId") int countryId, @RequestBody Country country) {
        return cjs.updateCountry(countryId, country);
    }

    @DeleteMapping("/countries/{countryId}")
    public void deleteCountry(@PathVariable("countryId") int countryId) {
        cjs.deleteCountry(countryId);
    }
}