package com.app.adventurehub.trip.mapping;


import com.app.adventurehub.shared.mapping.EnhancedModelMapper;
import com.app.adventurehub.trip.domain.model.entity.Category;
import com.app.adventurehub.trip.domain.model.entity.Destination;
import com.app.adventurehub.trip.resource.CategoryResource;
import com.app.adventurehub.trip.resource.DestinationResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class CategoryMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public List<CategoryResource> toResourceList(List<Category> modelList){
        return mapper.mapList(modelList, CategoryResource.class);
    }
}
