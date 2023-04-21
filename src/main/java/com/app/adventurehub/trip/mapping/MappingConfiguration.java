package com.app.adventurehub.trip.mapping;

import com.app.adventurehub.trip.domain.model.enumeration.Seasons;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TripMapper tripMapper() {
        return new TripMapper();
    }

    @Bean
    public CategoryMapper categoryMapper() {
        return new CategoryMapper();
    }

    @Bean
    public SeasonMapper seasonMapper(){return new SeasonMapper();}

}
