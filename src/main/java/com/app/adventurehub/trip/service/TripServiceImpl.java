package com.app.adventurehub.trip.service;

import com.app.adventurehub.shared.exception.ResourceValidationException;
import com.app.adventurehub.trip.domain.model.entity.Trip;
import com.app.adventurehub.trip.domain.persistence.TripRepository;
import com.app.adventurehub.trip.domain.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Service
public class TripServiceImpl implements TripService {

    private static final String ENTITY = "Trips";
    private final TripRepository tripRepository;

    private final Validator validator;

    public TripServiceImpl(TripRepository tripRepository, Validator validator) {
        this.tripRepository = tripRepository;
        this.validator = validator;
    }

    @Override
    public List<Trip> GetAll() {
        return tripRepository.findAll();
    }

    @Override
    public List<Trip> getTripByPrice(int price) {
        return tripRepository.findAllByPrice(price);
    }

    @Override
    public Trip getById(Long tripId) {
        return null;
    }

    @Override
    public Trip create(Trip trip) {
        Set<ConstraintViolation<Trip>> violations = validator.validate(trip);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Trip tripWithName = tripRepository.findByName(trip.getName());

        if(tripWithName != null)
            throw new ResourceValidationException(ENTITY, "Name already exists");

        trip.setCreatedAt(new Date());
        trip.setUpdatedAt(new Date());

        return tripRepository.save(trip);

    }

    @Override
    public Trip update(Long id, Trip trip) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long tripId) {
        return null;
    }
}
