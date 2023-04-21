package com.app.adventurehub.trip.mapping;


import com.app.adventurehub.shared.mapping.EnhancedModelMapper;
import com.app.adventurehub.trip.domain.model.entity.Trip;
import com.app.adventurehub.trip.resource.CreateTripResource;
import com.app.adventurehub.trip.resource.TripResource;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.Serializable;
import java.util.List;

public class TripMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public TripResource toResource(Trip model){
        return mapper.map(model, TripResource.class);
    }
    public Trip toModel(CreateTripResource resource){
        return mapper.map(resource, Trip.class);
    }
    public List<Trip> toResourceList(List<Trip> modelList){
        return mapper.mapList(modelList, Trip.class);
    }

}
