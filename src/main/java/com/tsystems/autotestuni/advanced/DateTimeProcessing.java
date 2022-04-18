package com.tsystems.autotestuni.advanced;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeProcessing {

    /**
     * Time in London, UK, is passed as an argument.
     * What is the time in Moscow, Russia?
     *
     * @param hour hours in London, UK
     * @param minute minutes in London, UK
     * @param second seconds in London, UK
     * @return corresponding time in Moscow, Russia
     */
    public static ZonedDateTime timeLondonToMoscow(int hour, int minute, int second) {
        ZonedDateTime londonTime = ZonedDateTime.now(ZoneId.of("Europe/London"))
                .truncatedTo(ChronoUnit.SECONDS)
                .withHour(hour)
                .withMinute(minute)
                .withSecond(second); //set it to specified time
        return londonTime.withZoneSameInstant(ZoneId.of("Europe/Moscow"));
    }
}
