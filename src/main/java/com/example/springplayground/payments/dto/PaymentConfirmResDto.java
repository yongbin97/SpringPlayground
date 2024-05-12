package com.example.springplayground.payments.dto;

import lombok.Builder;

@Builder
public class PaymentConfirmResDto {
    private String code;
    private String message;
}
