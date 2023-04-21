package com.app.adventurehub.trip.resource;

import com.app.adventurehub.trip.domain.model.entity.Season;
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
    private Float price;
    private String start_date;
    private String end_date;
    private Season season_id;
}
