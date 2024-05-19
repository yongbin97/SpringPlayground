package com.example.springplayground.payments.service;

import com.example.springplayground.payments.dto.PaymentConfirmResDto;
import com.example.springplayground.payments.dto.TossConfirmResDto;
import com.example.springplayground.payments.entity.Payment;
import com.example.springplayground.payments.repository.PaymentRepository;
import com.example.springplayground.user.entity.User;
import com.example.springplayground.user.implement.UserReader;
import com.example.springplayground.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;


@Slf4j
@AllArgsConstructor
@Service
public class PaymentsService {
    private final UserReader userReader;

    private final TossPaymentsService tossPaymentsService;
    private final PaymentRepository paymentRepository;

    public PaymentConfirmResDto requestConfirmToTossPayments(Long userId, JSONObject paymentJSON) throws Exception {
        log.info("[INFO] PaymentsService - requestConfirmToTossPayments");
        User user = userReader.read(userId);

        TossConfirmResDto tossConfirmResDto = tossPaymentsService.requestConfirm(paymentJSON);
        if (tossConfirmResDto.getResponseCode() != 200) {
            log.error("[ERROR] Toss Payments Service - requestConfirm failed: {}", tossConfirmResDto.getMessage());
            return tossConfirmResDto.toPaymentConfirmResDto();
        }
        Payment payment = paymentRepository.save(tossConfirmResDto.toEntity(user));
        log.info("[INFO] new payment created: {} - {}", payment.getOrderId(), payment.getOrderName());

        return tossConfirmResDto.toPaymentConfirmResDto();
    }
}
