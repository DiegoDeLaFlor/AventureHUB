package com.app.adventurehub.payment.domain.model.entity;

import com.app.adventurehub.reservation.domain.model.entity.Reservation;
import com.app.adventurehub.user.domain.model.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String paymentMethod;

    private Double amount;

    private Date paymentDate;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="reservation_id", nullable=false)
    private Reservation reservation;

}