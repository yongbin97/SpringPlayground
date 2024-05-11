package com.example.springplayground.payments.controller;

import com.example.springplayground.payments.dto.PaymentConfirmRequestDto;
import com.example.springplayground.payments.service.TossService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/toss")
public class TossController {
    private final TossService tossService;

    @PostMapping("/confirm")
    public void confirmPayment(@RequestBody PaymentConfirmRequestDto paymentConfirmRequestDto) throws Exception {
        log.info("toss confirm controller");
        tossService.confirmPayment(paymentConfirmRequestDto);
    }
}
