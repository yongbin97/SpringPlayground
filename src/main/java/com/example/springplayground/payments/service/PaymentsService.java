package com.example.springplayground.payments.service;

import com.example.springplayground.payments.dto.PaymentConfirmResDto;
import com.example.springplayground.payments.dto.TossConfirmResDto;
import com.example.springplayground.payments.implement.PaymentManager;
import com.example.springplayground.payments.implement.TossManager;
import com.example.springplayground.user.entity.User;
import com.example.springplayground.user.implement.UserReader;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;


@Slf4j
@AllArgsConstructor
@Service
public class PaymentsService {
    private final UserReader userReader;
    private final TossManager tossManager;
    private final PaymentManager paymentManager;

    public PaymentConfirmResDto requestConfirmToTossPayments(Long userId, JSONObject paymentJSON) throws Exception {
        log.info("[INFO] PaymentsService - requestConfirmToTossPayments");

        User user = userReader.read(userId);
        TossConfirmResDto tossConfirmResDto = tossManager.confirm(paymentJSON);
        return paymentManager.save(user, tossConfirmResDto);
    }
}
