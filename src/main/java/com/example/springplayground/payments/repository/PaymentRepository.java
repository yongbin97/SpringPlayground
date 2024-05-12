package com.example.springplayground.payments.repository;

import com.example.springplayground.payments.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
