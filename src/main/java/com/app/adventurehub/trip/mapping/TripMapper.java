package com.app.adventurehub.trip.mapping;

import com.app.adventurehub.shared.mapping.EnhancedModelMapper;
import com.app.adventurehub.trip.domain.model.entity.Season;
import com.app.adventurehub.trip.domain.model.entity.Trip;
import com.app.adventurehub.trip.domain.persistence.SeasonRepository;
import com.app.adventurehub.trip.resource.CreateTripResource;
import com.app.adventurehub.trip.resource.TripResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TripMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    @Autowired
    SeasonRepository seasonRepository;

    public TripResource toResource(Trip model){
        TripResource resource = new TripResource();
        resource.setId(model.getId());
        resource.setName(model.getName());
        resource.setDescription(model.getDescription());
        resource.setPrice(model.getPrice());
        resource.setStatus(model.getStatus());
        resource.setStart_date(model.getStart_date());
        resource.setEnd_date(model.getEnd_date());
        resource.setSeason(model.getSeason().getName());
        return resource;
    }

    public Trip toModel(CreateTripResource resource) {
        Optional<Season> season = seasonRepository.findById(resource.getSeasonId());
        if (!season.isPresent()) {
            throw new RuntimeException("Season not found");
        }

        Trip trip = new Trip();
        trip.setName(resource.getName());
        trip.setDescription(resource.getDescription());
        trip.setPrice(resource.getPrice());
        trip.setStart_date(resource.getStart_date());
        trip.setEnd_date(resource.getEnd_date());
        trip.setSeason(season.get());
        return trip;
    }

    public List<TripResource> toResourceList(List<Trip> modelList){
        return modelList.stream().map(this::toResource).collect(Collectors.toList());
    }
}
