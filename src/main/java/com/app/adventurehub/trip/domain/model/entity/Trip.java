package com.app.adventurehub.trip.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String name;
    private String description;

    @Column(precision = 10, scale = 2)
    private Double price;

    private Date start_date;
    private Date end_date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnore
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "season_id", nullable = false)
    @JsonIgnore
    private Season season;

    @OneToOne(mappedBy = "trip", cascade = CascadeType.ALL)
    private TripDetails tripDetails;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private Set<Itinerary> itineraries;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private Set<Rating> ratings;
}
