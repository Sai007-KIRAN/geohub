package com.example.geohub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import com.example.geohub.model.Country;
import com.example.geohub.model.City;
import com.example.geohub.repository.CityJpaRepository;
import com.example.geohub.repository.CityRepository;
import com.example.geohub.repository.CountryJpaRepository;
// Write your code here

@Service
public class CityJpaService implements CityRepository {

    @Autowired
    private CityJpaRepository mcjr;

    @Autowired
    private CountryJpaRepository cjr;

    @Override
    public ArrayList<City> allCity() {
        List<City> allList = mcjr.findAll();
        ArrayList<City> all = new ArrayList<>(allList);
        return all;
    }

    @Override
    public City eachCity(int cityId) {
        try {
            City each = mcjr.findById(cityId).get();
            return each;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public City addCity(City city) {
        Country cou = city.getCountry();
        int pId = cou.getCountryId();
        try {
            Country complete = cjr.findById(pId).get();
            city.setCountry(complete);
            mcjr.save(city);
            return city;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public City updateCity(int cityId, City city) {
        try {
            City update = mcjr.findById(cityId).get();
            if (city.getCityName() != null) {
                update.setCityName(city.getCityName());
            }
            if (city.getPopulation() >= 0) {
                update.setPopulation(city.getPopulation());
            }
            if (city.getLatitude() != null) {
                update.setLatitude(city.getLatitude());
            }
            if (city.getLongitude() != null) {
                update.setLongitude(city.getLongitude());
            }
            if (city.getCountry() != null) {
                Country cou = city.getCountry();
                int pId = cou.getCountryId();
                Country complete = cjr.findById(pId).get();
                city.setCountry(complete);
            }
            mcjr.save(update);
            return update;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCity(int cityId) {
        try {
            mcjr.deleteById(cityId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Country getCountry(int cityId) {
        try {
            City view = mcjr.findById(cityId).get();
            return view.getCountry();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}