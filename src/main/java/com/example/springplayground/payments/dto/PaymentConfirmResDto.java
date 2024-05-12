package com.example.springplayground.payments.dto;

import lombok.Builder;

@Builder
public class PaymentConfirmResDto {
    private int responseCode;
    private String code;
    private String message;
}
