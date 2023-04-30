package com.app.adventurehub.trip.resource;

import com.app.adventurehub.trip.domain.model.entity.Season;
import lombok.*;

import javax.print.attribute.standard.Destination;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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
    private Double price;

    private Date start_date;
    private Date end_date;
    private Long seasonId;
    private Long destinationId;
    private Long categoryId;
}
