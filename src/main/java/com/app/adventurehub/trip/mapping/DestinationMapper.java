package com.app.adventurehub.trip.mapping;

import com.app.adventurehub.shared.mapping.EnhancedModelMapper;
import com.app.adventurehub.trip.domain.model.entity.Destination;
import com.app.adventurehub.trip.domain.persistence.DestinationRepository;
import com.app.adventurehub.trip.resource.DestinationResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class DestinationMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    @Autowired
    DestinationRepository destinationRepository;

    public List<DestinationResource> toResourceList(List<Destination> modelList) {
        return mapper.mapList(modelList, DestinationResource.class);
    }

    public DestinationResource toResource(Destination model) {
        DestinationResource resource = new DestinationResource();
        resource.setDestination_id(model.getId());
        resource.setName(model.getName());
        resource.setDescription(model.getDescription());
        return resource;
    }


    public Destination toModel(DestinationResource resource) {
        return mapper.map(resource, Destination.class);
    }
}
