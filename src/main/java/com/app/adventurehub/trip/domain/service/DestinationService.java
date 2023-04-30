package com.app.adventurehub.trip.domain.service;

import com.app.adventurehub.trip.domain.model.entity.Destination;

import java.util.List;

public interface DestinationService {
    List<Destination> getAll();
    Destination create(Destination destination);

}
