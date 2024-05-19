package com.example.springplayground.payments.dto;


import com.example.springplayground.common.utils.TimeUtils;
import com.example.springplayground.payments.entity.Payment;
import com.example.springplayground.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import org.json.simple.JSONObject;

@Builder
@Getter
public class TossConfirmResDto {
    private int responseCode;
    private String code;
    private String message;
    private JSONObject obj;

    public Payment toEntity(User user){
        Payment payment = new Payment();
        payment.setOrderId((String) obj.get("orderId"));
        payment.setOrderName((String) obj.get("orderName"));
        payment.setPaymentKey((String) obj.get("paymentKey"));
        payment.setAmount((Long) obj.get("totalAmount"));
        payment.setMethod((String) obj.get("method"));
        payment.setRequestAt(TimeUtils.convertToLocalDateTime((String) obj.get("requestedAt")));
        payment.setApprovedAt(TimeUtils.convertToLocalDateTime((String) obj.get("approvedAt")));
        payment.setUser(user);

        return payment;
    }

    public PaymentConfirmResDto toPaymentConfirmResDto(){
        return PaymentConfirmResDto.builder()
                .code(code)
                .message(message)
                .build();
    }
}
