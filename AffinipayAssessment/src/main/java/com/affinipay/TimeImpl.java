package com.affinipay;

import com.affinipay.exceptions.InvalidTwelveHourTimeFormatException;

public class TimeImpl implements ITime {

    /**
     * Enum to represent state of input time {AM|PM}
     */
    enum State {
        AM,
        PM
    }

    /**
     * @param time         input time in [H]H:MM {AM|PM} 12-hour clock format
     * @param minutesToAdd minutes to be added to input time. can be negative or positive integer
     * @return string representation of final calculated time
     * @throws InvalidTwelveHourTimeFormatException if the time format does not match 12-hour clock [H]H:MM {AM|PM} format
     */
    @Override
    public String addMinutes(String time, int minutesToAdd) throws InvalidTwelveHourTimeFormatException {
        String[] timeElementsArray = extractTimeElements(time);

        return calculate(timeElementsArray[0], timeElementsArray[1], State.valueOf(timeElementsArray[2]), minutesToAdd);
    }

    /**
     * Performs final calculation after extraction, validation, and mapping to produce final calculated time
     *
     * @param hours        hours extracted from input time
     * @param minutes      minutes extracted from input time
     * @param state        state extracted from input time, either AM or PM
     * @param minutesToAdd the minutes to be added to or subtracted from input time
     * @return calculated time based on input
     */
    private String calculate(String hours, String minutes, State state, int minutesToAdd) {
        int totalMinutes = 0;

        // Do calculations in 24 hour clock
        String hoursTo24HourClock = mapTo24HourClock(hours, state);

        // Convert input time to minutes
        int timeInputAsMinutes = sumInputTimeToMinutes(hoursTo24HourClock, minutes);

        // Sum input minutes and minutesToAdd
        totalMinutes = timeInputAsMinutes + minutesToAdd;

        int calculatedHours = convertMinutesToHours(Math.floorMod(totalMinutes, 24 * 60));
        int calculatedMinutes = Math.floorMod(totalMinutes, 60);

        // Calculate time state
        if (calculatedHours >= 0 && calculatedHours < 12) {
            state = State.AM;
        } else if (calculatedHours >= 12 && calculatedHours <= 23) {
            state = State.PM;
        }

        // Map back to 12-hour clock after calculations are complete
        String hoursTo12HourClock = mapTo12HourClock(String.valueOf(calculatedHours));

        // Build return string
        return String.format("%s:%s %s", hoursTo12HourClock, padMinutes(calculatedMinutes), state);
    }

    /**
     * Extracts time elements (hours, minutes, AM/PM) from input time
     *
     * @param time input time as string
     * @return a string array containing hours [0], minutes [1], and am/pm abbreviation [2], extracted from input string
     */
    private String[] extractTimeElements(String time) throws InvalidTwelveHourTimeFormatException {
        time = time.trim();
        State state = null;
        String[] splitOnWhitespace = time.split(" ");
        String[] splitOnColon = splitOnWhitespace[0].split(":");

        validateInput(splitOnWhitespace, splitOnColon);

        try {
            state = State.valueOf(splitOnWhitespace[1].toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidTwelveHourTimeFormatException("Input time: " + time + " state must be either AM or PM (" + splitOnWhitespace[1] + " is invalid)");
        }

        return new String[]{splitOnColon[0], splitOnColon[1], state.toString()};
    }

    /**
     * Validates time input for hours, minutes and state in [H]H:MM {AM|PM} format
     *
     * @param splitOnWhiteSpace a string array containing time element and state element (AM or PM)
     * @param splitOnColon      a string array containing hours element and minutes element
     * @throws InvalidTwelveHourTimeFormatException if the time format does not match 12-hour clock [H]H:MM {AM|PM} format
     */
    private void validateInput(String[] splitOnWhiteSpace, String[] splitOnColon) throws InvalidTwelveHourTimeFormatException {
        if (splitOnWhiteSpace.length != 2 && splitOnColon.length == 2) {
            throw new InvalidTwelveHourTimeFormatException("Input time: " + splitOnWhiteSpace[0] + " must be in format [H]H:MM {AM|PM} (missing whitespace)");
        } else if (splitOnColon.length != 2 && splitOnWhiteSpace.length == 2) {
            throw new InvalidTwelveHourTimeFormatException("Input time: " + splitOnColon[0] + " must be in format [H]H:MM {AM|PM} (missing colon or minutes)");
        } else if (splitOnColon.length != 2 && splitOnWhiteSpace.length != 2) {
            throw new InvalidTwelveHourTimeFormatException("Input time: " + splitOnWhiteSpace[0] + " must be in format [H]H:MM {AM|PM} (missing whitespace and colon)");
        } else if (!splitOnColon[0].matches("[0-9]+")) {
            throw new InvalidTwelveHourTimeFormatException("Input hours: " + splitOnColon[0] + " contains invalid value(s) (can only contain digits)");
        } else if (!splitOnColon[1].matches("[0-9]+")) {
            throw new InvalidTwelveHourTimeFormatException("Input minutes: " + splitOnColon[1] + " contains invalid value(s) (can only contain digits)");
        } else if (Integer.parseInt(splitOnColon[0]) < 1 || Integer.parseInt(splitOnColon[0]) > 12) {
            throw new InvalidTwelveHourTimeFormatException("Input hours: " + splitOnColon[0] + " must be in in 12-hour clock format (range 1-12)");
        } else if (Integer.parseInt(splitOnColon[1]) < 0 || Integer.parseInt(splitOnColon[1]) >= 60) {
            throw new InvalidTwelveHourTimeFormatException("Input minutes: " + splitOnColon[1] + " must be in 12-hour clock format (range 00-59)");
        } else if (splitOnColon[1].length() != 2) {
            throw new InvalidTwelveHourTimeFormatException("Input minutes: " + splitOnColon[1] + " must be in format [H]H:MM {AM|PM} (minimum length for minutes is 2 characters)");
        }
    }

    /**
     * Pads the minutes of return calculated time if is digit 0-9 or length == 1
     *
     * @param minutes the final calculated minutes to be padded and returned to user as string
     * @return padded string minutes with length 2
     */
    private String padMinutes(int minutes) {
        String strMinutes = String.valueOf(minutes);

        if (strMinutes.length() == 1) {
            return "0" + strMinutes;
        } else {
            return String.valueOf(minutes);
        }
    }

    /**
     * Converts hours to minutes
     *
     * @param hours to be converted to minutes
     * @return integer representation of minutes
     */
    private int convertHoursToMinutes(int hours) {
        return hours * 60;
    }

    /**
     * Converts minutes to hours
     *
     * @param minutes to be converted to hours
     * @return integer representation of hours
     */
    private int convertMinutesToHours(int minutes) {
        return minutes / 60;
    }

    /**
     * Converts extracted hours element of input time to minutes and sums with extracted minutes for minute representation of input time
     *
     * @param hours   input time in hours
     * @param minutes input time in minutes
     * @return the sum of input time converted to minutes
     */
    private int sumInputTimeToMinutes(String hours, String minutes) {
        return (convertHoursToMinutes(Integer.parseInt(hours)) + Integer.parseInt(minutes));
    }

    /**
     * Maps 24-hour clock (military time) back to 12-hour clock time after calculations have been completed to be returned back to the user
     *
     * @param hours hours in 24-hour clock format
     * @return hours mapped to 12-hour clock format
     */
    private String mapTo12HourClock(String hours) {
        switch (hours) {
            case "0":
                hours = "12";
                break;
            case "13":
                hours = "1";
                break;
            case "14":
                hours = "2";
                break;
            case "15":
                hours = "3";
                break;
            case "16":
                hours = "4";
                break;
            case "17":
                hours = "5";
                break;
            case "18":
                hours = "6";
                break;
            case "19":
                hours = "7";
                break;
            case "20":
                hours = "8";
                break;
            case "21":
                hours = "9";
                break;
            case "22":
                hours = "10";
                break;
            case "23":
                hours = "11";
                break;
        }

        return hours;
    }

    /**
     * Maps the 12-hour clock input time to 24-hour clock (military time) for calculations
     *
     * @param hours string representation of extracted hours from input time, i.e. [H]H
     * @param state AM or PM
     * @return string representation of hours mapped to 24-hour clock format
     */
    private String mapTo24HourClock(String hours, State state) {
        if (state == State.AM) {
            switch (hours) {
                case "12":
                    hours = "0";
                    break;
            }
        } else if (state == State.PM) {
            switch (hours) {
                case "1":
                    hours = "13";
                    break;
                case "2":
                    hours = "14";
                    break;
                case "3":
                    hours = "15";
                    break;
                case "4":
                    hours = "16";
                    break;
                case "5":
                    hours = "17";
                    break;
                case "6":
                    hours = "18";
                    break;
                case "7":
                    hours = "19";
                    break;
                case "8":
                    hours = "20";
                    break;
                case "9":
                    hours = "21";
                    break;
                case "10":
                    hours = "22";
                    break;
                case "11":
                    hours = "23";
                    break;
            }
        }

        return hours;
    }

}
