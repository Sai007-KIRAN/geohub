package com.example.geohub.repository;

import java.util.*;
import com.example.geohub.model.City;
import org.springframework.stereotype.Repository;

import com.example.geohub.model.Country;

@Repository
public interface CityRepository {
    ArrayList<City> allCity();

    City eachCity(int cityId);

    City addCity(City city);

    City updateCity(int cityId, City city);

    void deleteCity(int cityId);

    Country getCountry(int cityId);
}