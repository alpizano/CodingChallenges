package com.affinipay;

import com.affinipay.exceptions.InvalidTwelveHourTimeFormatException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for addToMinutes implementation.
 */
public class TimeImplTest {
    static TimeImpl time;

    @BeforeClass
    public static void setUp() {
        time = new TimeImpl();
    }

    /**
     * Base test listed in coding assessment guide
     */
    @Test
    public void addToMinutes_addMinutes() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("9:13 AM", 200);
        assertEquals("12:33 PM", answer);
    }

    @Test
    public void addToMinutes_addHalfDayOfMinutes() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("9:13 AM", 720);
        assertEquals("9:13 PM", answer);
    }

    @Test
    public void addToMinutes_addOneDayOfMinutes() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("9:13 AM", 1440);
        assertEquals("9:13 AM", answer);
    }

    @Test
    public void addToMinutes_subtractMinutes() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("9:13 AM", -200);
        assertEquals("5:53 AM", answer);
    }

    @Test
    public void addToMinutes_subtractHalfDayOfMinutes() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("9:13 AM", -720);
        assertEquals("9:13 PM", answer);
    }

    @Test
    public void addToMinutes_subtractOneDayOfMinutes() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("9:13 AM", -1440);
        assertEquals("9:13 AM", answer);
    }

    @Test
    public void addToMinutes_subtractMinutesWithNegativeTotalMinutes() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("2:00 AM", -180);
        assertEquals("11:00 PM", answer);
    }


    /**
     * Only valid states for time are AM or PM. Should throw
     */
    @Test(expected=InvalidTwelveHourTimeFormatException.class)
    public void addToMinutes_timeStateIsNotAmOrPm() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("9:13 XY", 200);
    }

    @Test(expected=InvalidTwelveHourTimeFormatException.class)
    public void addToMinutes_timeInputMissingWhiteSpace() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("9:13AM", 200);
    }

    @Test(expected=InvalidTwelveHourTimeFormatException.class)
    public void addToMinutes_timeInputMissingColon() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("913 AM", 200);
    }

    @Test(expected=InvalidTwelveHourTimeFormatException.class)
    public void addToMinutes_timeInputMissingWhiteSpaceAndColon() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("913AM", 200);
    }

    @Test(expected=InvalidTwelveHourTimeFormatException.class)
    public void addToMinutes_timeInputInvalidHoursLessThanOne() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("0:13 AM", 200);
    }

    @Test(expected=InvalidTwelveHourTimeFormatException.class)
    public void addToMinutes_timeInputInvalidHoursGreaterThanTwelve() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("13:13 AM", 200);
    }

    @Test(expected=InvalidTwelveHourTimeFormatException.class)
    public void addToMinutes_testInputInvalidMinutesGreaterThanFiftyNine() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("9:60 AM", 60);
    }

    @Test(expected=InvalidTwelveHourTimeFormatException.class)
    public void addToMinutes_testInputInvalidMinutesNonDigitCharacter() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("9:-1 AM", 60);
    }

    @Test(expected=InvalidTwelveHourTimeFormatException.class)
    public void addToMinutes_testInputInvalidHoursNonDigitCharacter() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("$9:01 AM", 60);
    }

    @Test(expected=InvalidTwelveHourTimeFormatException.class)
    public void addToMinutes_testInputInvalidMinutesLengthLessThanTwo() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("9:0 AM", 60);
    }

    @Test
    public void addToMinutes_testInputInvalidLeadingAndTrailingWhiteSpace() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("   9:13 AM   ", 200);
        assertEquals("12:33 PM", answer);
    }

    @Test
    public void addToMinutes_timeStateCaseInsensitiveAmToAm() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("9:00 am", 60);
        assertEquals("10:00 AM", answer);
    }

    @Test
    public void addToMinutes_timeStateCaseInsensitivePmToPm() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("12:00 pm", 60);
        assertEquals("1:00 PM", answer);
    }

    @Test
    public void addToMinutes_timeStateCaseInsensitiveAmToPm() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("11:00 aM", 60);
        assertEquals("12:00 PM", answer);
    }

    @Test
    public void addToMinutes_timeStateCaseInsensitivePmToAm() throws InvalidTwelveHourTimeFormatException {
        String answer = time.addMinutes("11:00 pM", 120);
        assertEquals("1:00 AM", answer);
    }

}
