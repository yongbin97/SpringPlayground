package com.example.springplayground.payments.entity;

import com.example.springplayground.common.entity.BaseTimeEntity;
import com.example.springplayground.user.entity.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Payment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String orderId;
    private String orderName;
    private String paymentKey;
    private int amount;
    private String method;
    private LocalDateTime requestAt;
    private LocalDateTime approvedAt;
}
