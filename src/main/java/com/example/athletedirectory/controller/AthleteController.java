package com.example.athletedirectory.controller;

import com.example.athletedirectory.model.Athlete;
import com.example.athletedirectory.model.Country;
import com.example.athletedirectory.service.AthleteJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AthleteController {
    @Autowired
    private AthleteJpaService athleteJpaService;

    @GetMapping("/countries/athletes")
    public ArrayList<Athlete> getAthletes() {
        return athleteJpaService.getAthletes();
    }

    @GetMapping("/countries/athletes/{athleteId}")
    public Athlete getAthleteById(@PathVariable("athleteId") int athleteId) {
        return athleteJpaService.getAthleteById(athleteId);
    }

    @PostMapping("/countries/athletes")
    public Athlete addAthlete(@RequestBody Athlete athlete) {
        return athleteJpaService.addAthlete(athlete);
    }

    @PutMapping("/countries/athletes/{athleteId}")
    public Athlete updateAthlete(@PathVariable("athleteId") int athleteId, @RequestBody Athlete athlete) {
        return athleteJpaService.updateAthlete(athleteId, athlete);
    }

    @DeleteMapping("/countries/athletes/{athleteId}")
    public void deleteAthlete(@PathVariable("athleteId") int athleteId) {
        athleteJpaService.deleteAthlete(athleteId);
    }

    @GetMapping("/athletes/{athleteId}/country")
    public Country getAthleteCountry(@PathVariable("athleteId") int athleteId) {
        return athleteJpaService.getAthleteCountry(athleteId);
    }
}