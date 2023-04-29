package com.app.adventurehub.trip.resource;

import com.app.adventurehub.trip.domain.model.entity.Category;
import com.app.adventurehub.trip.domain.model.entity.Destination;
import com.app.adventurehub.trip.domain.model.enumeration.Seasons;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class TripResource {
    private Long id;
    private String status;
    private String name;
    private String description;
    private Double price;
    private Date start_date;
    private Date end_date;
    private Seasons season;
    private Destination destination;
    private Category category;
}
