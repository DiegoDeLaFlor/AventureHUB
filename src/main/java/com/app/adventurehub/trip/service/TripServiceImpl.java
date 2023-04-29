package com.app.adventurehub.trip.service;

import com.app.adventurehub.shared.exception.ResourceValidationException;
import com.app.adventurehub.trip.domain.model.entity.Destination;
import com.app.adventurehub.trip.domain.model.entity.Trip;
import com.app.adventurehub.trip.domain.persistence.SeasonRepository;
import com.app.adventurehub.trip.domain.persistence.TripRepository;
import com.app.adventurehub.trip.domain.service.TripService;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class TripServiceImpl implements TripService {
    private static final String ENTITY = "Trips";
    private final TripRepository tripRepository;
    private final SeasonRepository seasonRepository;
    private final Validator validator;

    public TripServiceImpl(TripRepository tripRepository, SeasonRepository seasonRepository, Validator validator) {
        this.tripRepository = tripRepository;
        this.seasonRepository = seasonRepository;
        this.validator = validator;
    }

    @Override
    public List<Trip> GetAll() {
        return tripRepository.findAll();
    }

    @Override
    public List<Trip> getTripByPrice(Double price) {
        return tripRepository.findAllByPrice(price);
    }
    @Override
    public List<Trip> getTripBySeason(String name) {

        return tripRepository.findAllBySeason(name);
    }
    @Override
    public List<Destination> getTripByDestination(String name) {
        return tripRepository.findAllByDestination(name);
    }
    @Override
    public Trip create(Trip trip) {
        Set<ConstraintViolation<Trip>> violations = validator.validate(trip);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Trip tripWithName = tripRepository.findByName(trip.getName());

        if(tripWithName != null)
            throw new ResourceValidationException(ENTITY, "Name already exists");

        return tripRepository.save(trip);
    }
}
