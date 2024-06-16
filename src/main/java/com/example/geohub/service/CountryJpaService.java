package com.example.geohub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import com.example.geohub.model.Country;
import com.example.geohub.repository.CountryJpaRepository;
import com.example.geohub.repository.CountryRepository;
// Write your code here

@Service
public class CountryJpaService implements CountryRepository {

    @Autowired
    private CountryJpaRepository cjr;

    @Override
    public ArrayList<Country> allCountry() {
        List<Country> allList = cjr.findAll();
        ArrayList<Country> all = new ArrayList<>(allList);
        return all;
    }

    @Override
    public Country eachCountry(int countryId) {
        try {
            Country each = cjr.findById(countryId).get();
            return each;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Country addCountry(Country country) {
        cjr.save(country);
        return country;
    }

    @Override
    public Country updateCountry(int countryId, Country country) {
        try {
            Country update = cjr.findById(countryId).get();
            if (country.getCountryName() != null) {
                update.setCountryName(country.getCountryName());
            }
            if (country.getCurrency() != null) {
                update.setCurrency(country.getCurrency());
            }
            if (country.getPopulation() >= 0) {
                update.setPopulation(country.getPopulation());
            }
            if (country.getLatitude() != null) {
                update.setLatitude(country.getLatitude());
            }
            if (country.getLongitude() != null) {
                update.setLongitude(country.getLongitude());
            }
            cjr.save(update);
            return update;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCountry(int countryId) {
        try {
            cjr.deleteById(countryId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}