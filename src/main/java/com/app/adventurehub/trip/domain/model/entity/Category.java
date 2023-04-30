package com.app.adventurehub.trip.domain.model.entity;

import com.app.adventurehub.trip.domain.model.enumeration.Categories;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Categories name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Trip> trips = new ArrayList<>();
}
