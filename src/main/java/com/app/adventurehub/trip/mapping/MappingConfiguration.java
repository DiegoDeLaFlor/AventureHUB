package com.app.adventurehub.trip.mapping;

import com.app.adventurehub.trip.resource.CategoryResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("tripMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TripMapper tripMapper() {
        return new TripMapper();
    }

    @Bean
    public SeasonMapper seasonMapper(){ return new SeasonMapper();}

    @Bean
    public DestinationMapper destinationMapper(){
        return new DestinationMapper();
    }

    @Bean
    public CategoryMapper categoryMapper(){
        return new CategoryMapper();
    }
}
