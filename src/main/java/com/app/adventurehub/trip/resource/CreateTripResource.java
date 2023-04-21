package com.app.adventurehub.trip.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateTripResource {
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String status;
    private String name;
    private String description;

    @NotNull
    @NotBlank
    private float price;
}
