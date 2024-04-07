package com.example.athletedirectory.repository;

import com.example.athletedirectory.model.Athlete;
import com.example.athletedirectory.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteJpaRepository extends JpaRepository<Athlete, Integer> {
    List<Athlete> findByCountry(Country country);
}