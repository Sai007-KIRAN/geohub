package com.example.geohub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.geohub.model.Country;

// Write your code here

@Repository
public interface CountryJpaRepository extends JpaRepository<Country, Integer> {

}