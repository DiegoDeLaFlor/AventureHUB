package com.app.adventurehub.trip.domain.persistence;


import com.app.adventurehub.trip.domain.model.entity.Season;
import com.app.adventurehub.trip.domain.model.entity.Trip;
import com.app.adventurehub.trip.domain.model.enumeration.Seasons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findAllByPrice(Double price);
    Trip findByName(String name);
    List<Trip> findAllBySeasonName(Seasons name);
    List<Trip> findAllByDestinationName(String name);
}
