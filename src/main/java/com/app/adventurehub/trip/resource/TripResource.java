package com.app.adventurehub.trip.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TripResource {
    private Long id;
    private String status;
    private String name;
    private String description;
    private float price;
}
