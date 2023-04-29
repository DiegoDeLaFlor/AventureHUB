package com.app.adventurehub.trip.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DestinationResource {

    private Long destination_id;
    private String name;
    private String description;

}
