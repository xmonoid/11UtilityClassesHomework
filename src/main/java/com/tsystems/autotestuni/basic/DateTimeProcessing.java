package com.tsystems.autotestuni.basic;

import java.time.LocalDateTime;
import java.util.Date;

public class DateTimeProcessing {

    public enum DatesComparisonResult {
        BEFORE,
        SIMULTANEOUSLY,
        AFTER
    }

    /**
     * Write a method which compares two {@link Date} instances and returns one out of three
     * possible results: {@code DatesComparisonResult.BEFORE} if the first date is before the second one,
     * {@code DatesComparisonResult.AFTER} if the first date is after the second one,
     * and {@code DatesComparisonResult.SIMULTANEOUSLY} if the first date is the same as the second one.
     *
     * @param first the first date
     * @param second the second date
     * @return {@link DatesComparisonResult} value
     */
    public static DatesComparisonResult compareTwoDates(Date first, Date second) {
        if (first.before(second)) {
            return DatesComparisonResult.BEFORE;
        } else if (first.after(second)) {
            return DatesComparisonResult.AFTER;
        } else
            return DatesComparisonResult.SIMULTANEOUSLY;
    }

    /**
     * Write a method which prints out the following dates & times based on the passed one:
     *
     * - 5 years in the future
     * - 9 months in the future
     * - 3 weeks in the future
     * - 14 days in the future
     * - 2 hours in the future
     * - 15 minutes in the future
     * - 1000 seconds in the future
     *
     * @param localDateTime entered datetime
     */
    public static void printOutFuture(LocalDateTime localDateTime) {
        System.out.println("date/time in 5 years will be " + localDateTime.plusYears(5));
        System.out.println("date/time in 9 months will be " + localDateTime.plusMonths(9));
        System.out.println("date/time in 3 weeks will be " + localDateTime.plusWeeks(3));
        System.out.println("date/time in 14 days will be " + localDateTime.plusDays(14));
        System.out.println("date/time in 2 hours will be " + localDateTime.plusHours(2));
        System.out.println("date/time in 15 minutes will be " + localDateTime.plusMinutes(15));
        System.out.println("date/time in 1000 seconds will be " + localDateTime.plusSeconds(5));
    }
}
