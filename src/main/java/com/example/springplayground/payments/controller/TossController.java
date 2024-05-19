package com.example.springplayground.payments.controller;

import com.example.springplayground.payments.dto.PaymentConfirmReqDto;
import com.example.springplayground.payments.dto.PaymentConfirmResDto;
import com.example.springplayground.payments.service.PaymentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/toss")
public class TossController {
    private final PaymentsService paymentsService;

    @PostMapping("/confirm")
    public ResponseEntity<PaymentConfirmResDto> confirmPayment(@RequestBody PaymentConfirmReqDto paymentConfirmRequestDto) throws Exception {
        log.info("[INFO] Toss Controller - confirmPayment");
        PaymentConfirmResDto paymentConfirmResDto = paymentsService.requestConfirmToTossPayments(paymentConfirmRequestDto.getUserId(), paymentConfirmRequestDto.toJSON());
        return new ResponseEntity<>(paymentConfirmResDto, HttpStatus.OK);
    }
}
