package com.affinipay;

import com.affinipay.exceptions.InvalidTwelveHourClockTimeFormatException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for addToMinutes implementation.
 */
public class TimeImplTest {
    static TimeImpl time;
    String answer;

    @BeforeClass
    public static void setUp() {
        time = new TimeImpl();
    }

    @Test
    public void addToMinutes_addMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 AM", 200);
        assertEquals("12:33 PM", answer);
    }

    @Test
    public void addToMinutes_addHalfDayOfMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 AM", 720);
        assertEquals("9:13 PM", answer);
    }

    @Test
    public void addToMinutes_addOneDayOfMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 AM", 1440);
        assertEquals("9:13 AM", answer);
    }

    @Test
    public void addToMinutes_addOneWeekOfMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 AM", 10080);
        assertEquals("9:13 AM", answer);
    }

    @Test
    public void addToMinutes_addOneMonthOfMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 AM", 306600);
        assertEquals("7:13 AM", answer);
    }

    @Test
    public void addToMinutes_addOneYearOfMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 AM", 525600);
        assertEquals("9:13 AM", answer);
    }

    @Test
    public void addToMinutes_subtractMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 AM", -200);
        assertEquals("5:53 AM", answer);
    }

    @Test
    public void addToMinutes_subtractHalfDayOfMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 AM", -720);
        assertEquals("9:13 PM", answer);
    }

    @Test
    public void addToMinutes_subtractOneDayOfMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 AM", -1440);
        assertEquals("9:13 AM", answer);
    }

    @Test
    public void addToMinutes_subtractOneWeekOfMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 AM", -10080);
        assertEquals("9:13 AM", answer);
    }

    @Test
    public void addToMinutes_subtractOneMonthOfMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 AM", -306600);
        assertEquals("11:13 AM", answer);
    }

    @Test
    public void addToMinutes_subtractOneYearOfMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 AM", -525600);
        assertEquals("9:13 AM", answer);
    }

    @Test
    public void addToMinutes_subtractMinutesWithNegativeTotalMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("2:00 AM", -180);
        assertEquals("11:00 PM", answer);
    }

    @Test(expected = InvalidTwelveHourClockTimeFormatException.class)
    public void addToMinutes_timeStateIsNotAmOrPm() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 XY", 200);
    }

    @Test(expected = InvalidTwelveHourClockTimeFormatException.class)
    public void addToMinutes_timeInputMissingWhiteSpace() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13AM", 200);
    }

    @Test(expected = InvalidTwelveHourClockTimeFormatException.class)
    public void addToMinutes_timeInputMissingColon() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("913 AM", 200);
    }

    @Test(expected = InvalidTwelveHourClockTimeFormatException.class)
    public void addToMinutes_timeInputMissingWhiteSpaceAndColon() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("913AM", 200);
    }

    @Test(expected = InvalidTwelveHourClockTimeFormatException.class)
    public void addToMinutes_timeInputInvalidHoursLessThanOne() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("0:13 AM", 200);
    }

    @Test(expected = InvalidTwelveHourClockTimeFormatException.class)
    public void addToMinute_timeInputEmptyHours() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes(":00 PM", 120);
    }

    @Test(expected = InvalidTwelveHourClockTimeFormatException.class)
    public void addToMinute_timeInputEmptyMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9: PM", 120);
    }

    @Test(expected = InvalidTwelveHourClockTimeFormatException.class)
    public void addToMinutes_timeInputInvalidHoursGreaterThanTwelve() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("13:13 AM", 200);
    }

    @Test(expected = InvalidTwelveHourClockTimeFormatException.class)
    public void addToMinutes_testInputInvalidMinutesGreaterThanFiftyNine() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:60 AM", 60);
    }

    @Test(expected = InvalidTwelveHourClockTimeFormatException.class)
    public void addToMinutes_testInputInvalidMinutesNonDigitCharacter() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:-1 AM", 60);
    }

    @Test(expected = InvalidTwelveHourClockTimeFormatException.class)
    public void addToMinutes_testInputInvalidHoursNonDigitCharacter() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("$9:01 AM", 60);
    }

    @Test(expected = InvalidTwelveHourClockTimeFormatException.class)
    public void addToMinutes_testInputInvalidMinutesLengthLessThanTwo() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:0 AM", 60);
    }

    @Test
    public void addToMinutes_testInputInvalidLeadingAndTrailingWhiteSpace() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("   9:13 AM   ", 200);
        assertEquals("12:33 PM", answer);
    }

    @Test
    public void addToMinutes_testMaxIntegerMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 AM", 2147483647);
        assertEquals("7:04 AM", answer);
    }

    @Test
    public void addToMinutes_testMinIntegerMinutes() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:13 AM", -2147483648);
        assertEquals("7:05 AM", answer);
    }

    @Test
    public void addToMinutes_timeStateCaseInsensitiveAmToAm() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("9:00 am", 60);
        assertEquals("10:00 AM", answer);
    }

    @Test
    public void addToMinutes_timeStateCaseInsensitivePmToPm() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("12:00 pm", 60);
        assertEquals("1:00 PM", answer);
    }

    @Test
    public void addToMinutes_timeStateCaseInsensitiveAmToPm() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("11:00 aM", 60);
        assertEquals("12:00 PM", answer);
    }

    @Test
    public void addToMinutes_timeStateCaseInsensitivePmToAm() throws InvalidTwelveHourClockTimeFormatException {
        answer = time.addMinutes("11:00 pM", 120);
        assertEquals("1:00 AM", answer);
    }

}
