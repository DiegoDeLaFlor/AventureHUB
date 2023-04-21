package com.app.adventurehub.trip.mapping;

import com.app.adventurehub.shared.mapping.EnhancedModelMapper;
import com.app.adventurehub.trip.domain.model.entity.Season;
import com.app.adventurehub.trip.domain.model.enumeration.Seasons;
import com.app.adventurehub.trip.resource.SeasonResource;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class SeasonMapper {
    @Autowired
    EnhancedModelMapper mapper;

    Converter<Seasons, String> roleToString = new AbstractConverter<Seasons, String>() {
        @Override
        protected String convert(Seasons role) {
            return role == null ? null : role.name();
        }
    };

    public SeasonResource toResource(Season model) {
        mapper.addConverter(roleToString);
        return mapper.map(model, SeasonResource.class);
    }

    public Page<SeasonResource> modelListToPage(List<Season> modelList, Pageable pageable) {
        mapper.addConverter(roleToString);
        return new PageImpl<>(mapper.mapList(modelList, SeasonResource.class), pageable, modelList.size());
    }
}
