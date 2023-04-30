package com.app.adventurehub.trip.service;

import com.app.adventurehub.trip.domain.model.entity.Itinerary;
import com.app.adventurehub.trip.domain.service.ItineraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItineraryServiceImpl implements ItineraryService {
    @Override
    public List<Itinerary> getAll() {
        return null;
    }

    @Override
    public Itinerary getById(Long itineraryId) {
        return null;
    }

    @Override
    public Itinerary create(Itinerary itinerary) {
        return null;
    }

    @Override
    public Itinerary update(Long id, Itinerary itinerary) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long itineraryId) {
        return null;
    }

    @Override
    public Itinerary addTripToItinerary(Long itineraryId, String tripName) {
        return null;
    }
}
