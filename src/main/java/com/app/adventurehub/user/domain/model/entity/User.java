package com.app.adventurehub.user.domain.model.entity;

import com.app.adventurehub.chat.domain.model.entity.Conversation;
import com.app.adventurehub.chat.domain.model.entity.Message;
import com.app.adventurehub.notification.domain.model.entity.Notification;
import com.app.adventurehub.payment.domain.model.entity.Payment;
import com.app.adventurehub.reservation.domain.model.entity.Reservation;
import com.app.adventurehub.shared.domain.model.AuditModel;
import com.app.adventurehub.trip.domain.model.entity.Rating;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Payment> payments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    @ManyToMany(mappedBy = "users")
    private Set<Conversation> conversations = new HashSet<>();
}