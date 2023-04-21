package com.app.adventurehub.trip.domain.model.entity;


import com.app.adventurehub.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trips")
public class Trip extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String status;
    private String name;
    private String description;

    @NotNull
    @DecimalMax(value = "10.2", inclusive = false)
    private Float price;

    @ManyToOne()
    @JoinColumn(name = "season_id", nullable = false)
    @JsonIgnore
    private Season season;
}
