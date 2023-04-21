package com.app.adventurehub.trip.mapping;


import com.app.adventurehub.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.Serializable;


public class TripMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;


}
