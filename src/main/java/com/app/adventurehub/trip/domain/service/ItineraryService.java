package com.app.adventurehub.trip.domain.service;

import com.app.adventurehub.trip.domain.model.entity.Itinerary;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItineraryService {
    List<Itinerary> getAll();
    Itinerary getById(Long itineraryId);
    Itinerary create(Itinerary itinerary);
    Itinerary update(Long id, Itinerary itinerary);
    ResponseEntity<?> delete(Long itineraryId);

    Itinerary addTripToItinerary(Long itineraryId, String tripName);
}
