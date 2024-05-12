package com.example.springplayground.payments.service;

import com.example.springplayground.payments.dto.PaymentConfirmResDto;
import com.example.springplayground.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;


@Slf4j
@AllArgsConstructor
@Service
public class PaymentsService {
    private final UserRepository userRepository;
    private final TossPaymentsService tossPaymentsService;

    public PaymentConfirmResDto requestConfirmToTossPayments(Long userId, JSONObject paymentJSON) throws Exception {
        log.info("[INFO] PaymentsService - requestConfirmToTossPayments");

        if (!userRepository.existsUserById(userId)) throw new Exception("Not Exist User");

        JSONObject responseJSON = tossPaymentsService.requestConfirm(paymentJSON);

        return PaymentConfirmResDto.builder()
                .code((String) responseJSON.get("code"))
                .message((String) responseJSON.get("message"))
                .build();
    }
}
