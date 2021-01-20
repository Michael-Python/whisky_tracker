package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value="/whiskys/{id}")
    public ResponseEntity getWhisky(@PathVariable Long id){
        return new ResponseEntity(whiskyRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskys")
    public ResponseEntity<List<Whisky>> findByYear(@RequestParam(name = "year", required = false) Long year) {
        if (year != null) {
            return new ResponseEntity<>(whiskyRepository.findByYearEquals(Math.toIntExact(year)), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskyAgeLocale")
    public ResponseEntity<List<Whisky>> findByAgeAndDistillery(@RequestParam(name = "age", required = false) Long age, @RequestParam(name = "dist", required = false) Distillery distillery) {
        if (age != null && distillery != null) {
            return new ResponseEntity<>(whiskyRepository.findByAgeAndDistilleryEquals(Math.toIntExact(age), distillery), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value="/whiskys")
    public ResponseEntity<Whisky> createWhisky(@RequestBody Whisky whisky){
        whiskyRepository.save(whisky);
        return new ResponseEntity<>(whisky, HttpStatus.CREATED);
    }

    @GetMapping(value = "/age")
    public ResponseEntity<List<Whisky>> findByAge(@RequestParam(name = "age", required = true) Long age) {
        if (age == 12) {
            return new ResponseEntity(whiskyRepository.findByAgeEquals(Math.toIntExact(age)), HttpStatus.OK);
        }
        return null;
    }

}
