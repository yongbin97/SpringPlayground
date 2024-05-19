package com.example.springplayground.payments.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PaymentConfirmResDto {
    private String code;
    private String message;
}
