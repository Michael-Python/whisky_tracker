package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.springframework.data.jpa.repository.JpaRepository;
import sun.util.resources.cldr.dyo.LocaleNames_dyo;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findByYearEquals(int year);

    List<Whisky> findByAgeAndDistilleryEquals(int age, Distillery distillery );

    List<Whisky> findByAgeEquals(int age);
}
