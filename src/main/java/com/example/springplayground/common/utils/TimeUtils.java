package com.example.springplayground.common.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
    public static LocalDateTime convertToLocalDateTime(String str){
        return LocalDateTime.from(
                Instant.from(
                        DateTimeFormatter.ISO_DATE_TIME.parse(str)
                ).atZone(ZoneId.of("Asia/Seoul"))
        );
    }
}
