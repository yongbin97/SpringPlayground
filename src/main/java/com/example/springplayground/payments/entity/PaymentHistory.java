package com.example.springplayground.payments.entity;

import com.example.springplayground.user.entity.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Enumerated
    private PaymentType paymentType;

    private int price;

    @CreationTimestamp
    private Timestamp paymentTimestamp;
}
