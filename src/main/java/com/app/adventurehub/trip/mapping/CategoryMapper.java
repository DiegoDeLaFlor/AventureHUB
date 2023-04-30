package com.app.adventurehub.trip.mapping;


import com.app.adventurehub.shared.mapping.EnhancedModelMapper;
import com.app.adventurehub.trip.domain.model.entity.Category;
import com.app.adventurehub.trip.domain.model.enumeration.Categories;
import com.app.adventurehub.trip.resource.CategoryResource;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class CategoryMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    Converter<Categories, String> roleToString = new AbstractConverter<Categories, String>() {
        @Override
        protected String convert(Categories role) {
            return role == null ? null : role.name();
        }
    };

    public CategoryResource toResource(Category model) {
        mapper.addConverter(roleToString);
        return mapper.map(model, CategoryResource.class);
    }

    public Page<CategoryResource> modelListToPage(List<Category> modelList, Pageable pageable) {
        mapper.addConverter(roleToString);
        return new PageImpl<>(mapper.mapList(modelList, CategoryResource.class), pageable, modelList.size());
    }
    public List<CategoryResource> toResourceList(List<Category> modelList){
        return mapper.mapList(modelList, CategoryResource.class);
    }
}
