package com.tsystems.autotestuni.advanced;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import static com.tsystems.autotestuni.advanced.DateTimeProcessing.timeLondonToMoscow;
import static org.junit.jupiter.api.Assertions.*;

class DateTimeProcessingTest {

    @Test
    void timeLondonToMoscowTest() {
        ZonedDateTime moscowTime = ZonedDateTime.now(ZoneId.of("Europe/Moscow"))
                .truncatedTo(ChronoUnit.SECONDS)
                .withHour(19)
                .withMinute(0)
                .withSecond(0);
        assertEquals(moscowTime, timeLondonToMoscow(17, 0, 0));

        moscowTime = ZonedDateTime.now(ZoneId.of("Europe/Moscow"))
                .truncatedTo(ChronoUnit.SECONDS)
                .withHour(2)
                .withMinute(0)
                .withSecond(0);
        assertEquals(moscowTime, timeLondonToMoscow(0, 0, 0));

        moscowTime = ZonedDateTime.now(ZoneId.of("Europe/Moscow"))
                .truncatedTo(ChronoUnit.SECONDS)
                .plusDays(1)
                .withHour(1)
                .withMinute(0)
                .withSecond(0);
        assertEquals(moscowTime, timeLondonToMoscow(23, 0, 0));
    }
}