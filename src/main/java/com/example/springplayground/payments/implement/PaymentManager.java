package com.example.springplayground.payments.implement;

import com.example.springplayground.payments.dto.PaymentConfirmResDto;
import com.example.springplayground.payments.dto.TossConfirmResDto;
import com.example.springplayground.payments.entity.Payment;
import com.example.springplayground.payments.repository.PaymentRepository;
import com.example.springplayground.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class PaymentManager {
    private final PaymentRepository paymentRepository;


    public PaymentConfirmResDto save(User user, TossConfirmResDto tossConfirmResDto){
        if (tossConfirmResDto.getResponseCode() != 200) {
            log.error("[ERROR] Toss Payments Service - requestConfirm failed: {}", tossConfirmResDto.getMessage());
        } else {
            Payment payment = paymentRepository.save(tossConfirmResDto.toEntity(user));
            log.info("[INFO] new payment history created: {} - {}", payment.getOrderId(), payment.getOrderName());
        }
        return tossConfirmResDto.toPaymentConfirmResDto();
    }
}
