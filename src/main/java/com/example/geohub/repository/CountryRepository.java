package com.example.geohub.repository;

import java.util.*;
import com.example.geohub.model.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository {
    ArrayList<Country> allCountry();

    Country eachCountry(int countryId);

    Country addCountry(Country country);

    Country updateCountry(int countryId, Country country);

    void deleteCountry(int countryId);
}