package com.app.adventurehub.trip.domain.service;

import com.app.adventurehub.trip.domain.model.entity.Itinerary;
import com.app.adventurehub.trip.domain.model.entity.Trip;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TripService {
    List<Trip> GetAll();
    List<Trip> getTripByPrice(int price);
    Trip getById(Long tripId);
    Trip create(Trip trip);
    Trip update(Long id, Trip trip);
    ResponseEntity<?> delete(Long tripId);
}
