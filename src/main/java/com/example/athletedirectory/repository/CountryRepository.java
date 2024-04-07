package com.example.athletedirectory.repository;

import com.example.athletedirectory.model.Athlete;
import com.example.athletedirectory.model.Country;

import java.util.ArrayList;
import java.util.List;

public interface CountryRepository {
    ArrayList<Country> getCountries();
    Country getCountryById(int countryId);
    Country addCountry(Country country);
    Country updateCountry(int countryId, Country country);
    void deleteCountry(int countryId);
    List<Athlete> getCountryAthletes(int countryId);
}
