package com.tsystems.autotestuni.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.Date;

import static com.tsystems.autotestuni.basic.DateTimeProcessing.DatesComparisonResult.AFTER;
import static com.tsystems.autotestuni.basic.DateTimeProcessing.DatesComparisonResult.BEFORE;
import static com.tsystems.autotestuni.basic.DateTimeProcessing.DatesComparisonResult.SIMULTANEOUSLY;
import static com.tsystems.autotestuni.basic.DateTimeProcessing.compareTwoDates;
import static com.tsystems.autotestuni.basic.DateTimeProcessing.printOutFuture;
import static org.junit.jupiter.api.Assertions.*;

class DateTimeProcessingTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void compareTwoDatesTest() {
        Date oneDate = new Date();
        Date twoDate = (Date) oneDate.clone();
        assertEquals(SIMULTANEOUSLY, compareTwoDates(oneDate, twoDate));

        twoDate = new Date(oneDate.getTime() - 10000);
        assertEquals(AFTER, compareTwoDates(oneDate, twoDate));

        twoDate = new Date(oneDate.getTime() + 10000);
        assertEquals(BEFORE, compareTwoDates(oneDate, twoDate));
    }

    @Test
    void printOutFutureTest() {
        LocalDateTime now = LocalDateTime.now();

        outputStreamCaptor.reset();
        printOutFuture(now);
        assertEquals("date/time in 5 years will be " + now.plusYears(5) + System.lineSeparator() +
                "date/time in 9 months will be " + now.plusMonths(9) + System.lineSeparator() +
                "date/time in 3 weeks will be " + now.plusWeeks(3) + System.lineSeparator() +
                "date/time in 14 days will be " + now.plusDays(14) + System.lineSeparator() +
                "date/time in 2 hours will be " + now.plusHours(2) + System.lineSeparator() +
                "date/time in 15 minutes will be " + now.plusMinutes(15) + System.lineSeparator() +
                "date/time in 1000 seconds will be " + now.plusSeconds(5) + System.lineSeparator(),
                outputStreamCaptor.toString());
    }
}