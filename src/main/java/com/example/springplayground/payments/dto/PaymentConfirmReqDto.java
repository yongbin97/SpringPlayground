package com.example.springplayground.payments.dto;

import lombok.Getter;
import org.json.simple.JSONObject;

@Getter
public class PaymentConfirmReqDto {
    private Long userId;
    private String paymentKey;
    private String orderId;
    private String amount;

    public JSONObject toJSON(){
        JSONObject obj = new JSONObject();
        obj.put("orderId", orderId);
        obj.put("amount", amount);
        obj.put("paymentKey", paymentKey);

        return obj;
    }
}
