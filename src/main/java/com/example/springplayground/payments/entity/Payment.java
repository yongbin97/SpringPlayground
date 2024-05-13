package com.example.springplayground.payments.entity;

import com.example.springplayground.common.entity.BaseTimeEntity;
import com.example.springplayground.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Payment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String orderId;
    private String orderName;
    private String paymentKey;
    private Long amount;
    private String method;
    private LocalDateTime requestAt;
    private LocalDateTime approvedAt;
}
