package com.app.adventurehub.trip.domain.model.entity;

import com.app.adventurehub.trip.domain.model.enumeration.Seasons;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Seasons name;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
    private List<Trip> trips;
}
