package com.app.adventurehub.trip.domain.model.entity;

import com.app.adventurehub.trip.domain.model.enumeration.Seasons;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "season")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long season_id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Seasons name;

}
