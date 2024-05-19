package com.example.springplayground.payments.implement;

import com.example.springplayground.payments.dto.TossConfirmResDto;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@Component
public class TossManager {
    @Value("${payments.toss.secretKey}")
    private String tossSecretKey;

    // Authorizations
    private String getAuthorizations() {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode((tossSecretKey + ":").getBytes(StandardCharsets.UTF_8));
        return "Basic " + new String(encodedBytes);
    }

    // 결제 승인 API 호출
    private HttpURLConnection callConfirmTossAPI(String authorizations, JSONObject paymentJSON) throws Exception {
        URL url = new URL("https://api.tosspayments.com/v1/payments/confirm");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Authorization", authorizations);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(paymentJSON.toString().getBytes(StandardCharsets.UTF_8));

        return connection;
    }

    private JSONObject getConfirmResult(HttpURLConnection connection, boolean isSuccess) throws Exception {
        InputStream responseStream = isSuccess ? connection.getInputStream() : connection.getErrorStream();

        JSONParser parser = new JSONParser();
        Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8);
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        responseStream.close();

        return jsonObject;
    }

    public TossConfirmResDto confirm(JSONObject paymentJSON) throws Exception {
        log.info("[INFO] Toss Payments Service - confirm");

        String authorizations = getAuthorizations();
        HttpURLConnection connection = callConfirmTossAPI(authorizations, paymentJSON);

        int responseCode = connection.getResponseCode();
        boolean isSuccess = responseCode == 200;
        JSONObject jsonObject = getConfirmResult(connection, isSuccess);

        return TossConfirmResDto.builder()
                .responseCode(responseCode)
                .obj(jsonObject)
                .code(isSuccess ? "SUCCESS" : (String) jsonObject.get("code"))
                .message(isSuccess ? "결제에 성공하였습니다." : (String) jsonObject.get("message"))
                .build();
    }
}
