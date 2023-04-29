package com.app.adventurehub.reservation.domain.model.entity;

import com.app.adventurehub.payment.domain.model.entity.Payment;
import com.app.adventurehub.trip.domain.model.entity.Trip;
import com.app.adventurehub.user.domain.model.entity.User;
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
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date reservation_date;
    private String status;
    private Integer number_of_people;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="trip_id", nullable=false)
    private Trip trip;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.PERSIST)
    private Set<Payment> payments;

}