package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {

    List<Distillery> findByRegionEquals(String region);

    List<Distillery> findWhiskyByRegionEquals(String region);

//    List<Distillery> findByNameEquals(String name);

//    List<Distillery> findWhiskyByDistilleryLocationAndAge(Whisky whisky);
}
