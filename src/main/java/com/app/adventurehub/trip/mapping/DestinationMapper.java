package com.app.adventurehub.trip.mapping;

import com.app.adventurehub.shared.mapping.EnhancedModelMapper;
import com.app.adventurehub.trip.domain.model.entity.Destination;
import com.app.adventurehub.trip.domain.model.entity.Season;
import com.app.adventurehub.trip.resource.DestinationResource;
import com.app.adventurehub.trip.resource.SeasonResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class DestinationMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public List<DestinationResource> toResourceList(List<Destination> modelList){
        return mapper.mapList(modelList, DestinationResource.class);
    }

}
