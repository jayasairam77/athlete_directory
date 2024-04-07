package com.example.athletedirectory.service;

import com.example.athletedirectory.model.Athlete;
import com.example.athletedirectory.model.Country;
import com.example.athletedirectory.repository.AthleteRepository;
import com.example.athletedirectory.repository.AthleteJpaRepository;
import com.example.athletedirectory.repository.CountryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AthleteJpaService implements AthleteRepository {

    @Autowired
    private AthleteJpaRepository athleteJpaRepository;

    @Autowired
    private CountryJpaRepository countryJpaRepository;

    @Override
    public ArrayList<Athlete> getAthletes() {
        List<Athlete> athleteList = athleteJpaRepository.findAll();
        ArrayList<Athlete> athletes = new ArrayList<>(athleteList);
        return athletes;
    }

    @Override
    public Athlete getAthleteById(int athleteId) {
        try {
            return athleteJpaRepository.findById(athleteId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Athlete addAthlete(Athlete athlete) {
        try {
            int countryId = athlete.getCountry().getCountryId();
            Country country = countryJpaRepository.findById(countryId).get();
            athlete.setCountry(country);
            return athleteJpaRepository.save(athlete);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Athlete updateAthlete(int athleteId, Athlete athlete) {
        try {
            Athlete newAthlete = athleteJpaRepository.findById(athleteId).get();
            if (athlete.getAthleteName() != null) {
                newAthlete.setAthleteName(athlete.getAthleteName());
            }
            if (athlete.getSport() != null) {
                newAthlete.setSport(athlete.getSport());
            }
            if (athlete.getCountry() != null) {
                int countryId = athlete.getCountry().getCountryId();
                Country country = countryJpaRepository.findById(countryId).get();
                athlete.setCountry(country);
            }
            return athleteJpaRepository.save(newAthlete);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteAthlete(int athleteId) {
        try {
            athleteJpaRepository.deleteById(athleteId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Country getAthleteCountry(int athleteId) {
        try {
            return athleteJpaRepository.findById(athleteId).get().getCountry();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}