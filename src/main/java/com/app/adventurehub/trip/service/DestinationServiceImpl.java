package com.app.adventurehub.trip.service;

import com.app.adventurehub.shared.exception.ResourceValidationException;
import com.app.adventurehub.trip.domain.model.entity.Destination;
import com.app.adventurehub.trip.domain.persistence.DestinationRepository;
import com.app.adventurehub.trip.domain.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class DestinationServiceImpl implements DestinationService {
    @Autowired
    private final DestinationRepository destinationRepository;
    private final Validator validator;
    private static final String ENTITY = "Destinations";


    public DestinationServiceImpl(DestinationRepository destinationRepository, Validator validator) {
        this.destinationRepository = destinationRepository;
        this.validator = validator;
    }

    @Override
    public List<Destination> getAll() {
        return destinationRepository.findAll();
    }


    @Override
    public Destination create(Destination destination) {
        Set<ConstraintViolation<Destination>> violations = validator.validate(destination);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Destination destinationWithName = destinationRepository.findByName(destination.getName());

        if(destinationWithName != null)
            throw new ResourceValidationException(ENTITY, "Name already exists");

        return destinationRepository.save(destination);
    }


}
