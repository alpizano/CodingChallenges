package com.affinipay;

import com.affinipay.exceptions.InvalidTwelveHourTimeFormatException;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class TimeImpl implements ITime {

    enum State {
        AM,
        PM
    }

    @Override
    public String addMinutes(String time, int minutesToAdd) throws InvalidTwelveHourTimeFormatException {
        String[] timeElementsArray = extractTimeElements(time);
        State state = null;

        try {
            state = State.valueOf(timeElementsArray[2].toUpperCase());
        }
        catch(IllegalArgumentException e) {
            throw new InvalidTwelveHourTimeFormatException("Input time: " + time + " state must be either AM or PM (" + timeElementsArray[2] + " is invalid)");
        }

        String answer = calculate(timeElementsArray[0], timeElementsArray[1], state, minutesToAdd);
        System.out.println("ANSWER: " + answer);
       return answer;
    }

    private String calculate(String hours, String minutes, State state, int minutesToAdd) {
        int totalMinutes = 0;

        // Do calculations in 24 hour clock
        String hoursTo24HourClock = mapTo24HourClock(hours, state);

        // Convert input time to minutes and sum
        int timeInputAsMinutes = convertInputTimeToMinutes(hoursTo24HourClock, minutes);
        System.out.println("total time input(minutes): " + timeInputAsMinutes);

        // Combine input time + minutesToAdd
        // How do we know when to add vs substract?
        if(minutesToAdd < 0) {
            System.out.println("minutesToAdd: " + minutesToAdd + " is NEGATIVE");
            totalMinutes = timeInputAsMinutes + minutesToAdd;

        }
        else {
            System.out.println("minutesToAdd: " + minutesToAdd + " is POSITIVE");
            totalMinutes = timeInputAsMinutes + minutesToAdd;
        }


//        int answerHours = convertMinutesToHours(totalMinutes)%24;
        int answerHours = Math.floorMod(convertMinutesToHours(totalMinutes),24);
        int answerMinutes = totalMinutes%60;

        System.out.println("1 % 24=" + 1%24);
        System.out.println("-1 % 24=" + (-1)%24);
        System.out.println("-1 % 24=" + Math.floorMod(-1,24));
        System.out.println("1 % 24=" + Math.floorMod(1,24));
//        System.out.println("answer (days) + " + (totalMinutes/60)/24);
        System.out.println("(24hr clock) Remainder of hours: " + (convertMinutesToHours(totalMinutes))%24 + " from " + convertMinutesToHours(totalMinutes) + " hours" + " from " + totalMinutes + " minutes");
        System.out.println("(24hr clock) Remainder of hours (abs): " + (Math.abs(convertMinutesToHours(totalMinutes))%24)+ " from " + Math.abs(convertMinutesToHours(totalMinutes)) + " minutes");
//        System.out.println("answer (total hours) + " + (totalMinutes/60));
        System.out.println("(24hr clock) Remainder of minutes: " + (totalMinutes%60));


        if (answerHours >= 0 && answerHours < 12) {
            state = State.AM;
        }
        else if(answerHours >= 12 && answerHours <= 23) {
            state = State.PM;
        }

        return String.format("%d:%s %s",mapTo12HourClock(answerHours),padMinutes(answerMinutes), state);
    }

    /**
     *
     * @param time
     * @return a string array containing hours [0], minutes [1], and am/pm abbreviation [2], extracted from input string
     */
    private String[] extractTimeElements(String time) throws InvalidTwelveHourTimeFormatException {
        time = time.trim();
        String[] splitOnWhitespace = time.split(" ");
        String[] splitOnColon = splitOnWhitespace[0].split(":");

        validateInput(splitOnWhitespace, splitOnColon);

        return new String[]{splitOnColon[0],splitOnColon[1],splitOnWhitespace[1]};
    }

     private void validateInput(String[] splitOnWhiteSpace, String[] splitOnColon) throws InvalidTwelveHourTimeFormatException {
        if(splitOnWhiteSpace.length != 2 && splitOnColon.length == 2) {
            throw new InvalidTwelveHourTimeFormatException("Input time: " + splitOnWhiteSpace[0] + " must be in format [H]H:MM {AM|PM} (missing whitespace)");
        }
        else if(splitOnColon.length != 2 && splitOnWhiteSpace.length == 2) {
            throw new InvalidTwelveHourTimeFormatException("Input time: " + splitOnColon[0] + " must be in format [H]H:MM {AM|PM} (missing colon)");
        }
        else if(splitOnColon.length != 2 && splitOnWhiteSpace.length != 2) {
            throw new InvalidTwelveHourTimeFormatException("Input time: " + splitOnWhiteSpace[0] + " must be in format [H]H:MM {AM|PM} (missing whitespace and colon)");
        }
        else if(!splitOnColon[0].matches("[0-9]+")) {
            throw new InvalidTwelveHourTimeFormatException("Input hours: " + splitOnColon[0] + " contains invalid value(s) (can only contain digits)");
        }
        else if(!splitOnColon[1].matches("[0-9]+")) {
            throw new InvalidTwelveHourTimeFormatException("Input minutes: " + splitOnColon[1] + " contains invalid value(s) (can only contain digits)");
        }
        else if(Integer.parseInt(splitOnColon[0])  < 1 || Integer.parseInt(splitOnColon[0]) > 12) {
            throw new InvalidTwelveHourTimeFormatException("Input hours: " + splitOnColon[0] + " must be in in 12-hour clock format (range 1-12)");
        }
        else if(Integer.parseInt(splitOnColon[1])  < 0 || Integer.parseInt(splitOnColon[1]) >= 60) {
            throw new InvalidTwelveHourTimeFormatException("Input minutes: " + splitOnColon[1] + " must be in 12-hour clock format (range 00-59)");
        }
        else if(splitOnColon[1].length() != 2) {
            throw new InvalidTwelveHourTimeFormatException("Input minutes: " + splitOnColon[1] + " must be in format [H]H:MM {AM|PM} (minimum length for minutes is 2 characters)");
        }

    }

    /**
     *
     * @param hours string representation of extracted hours from input time, i.e. [H]H
     * @param state AM or PM
     * @return string representation of hours mapped to 24-hour clock format
     */
    public String mapTo24HourClock(String hours, State state) {
        if(state == State.AM) {
            switch(Integer.parseInt(hours)) {
                case 12: hours = "0";
                    break;
            }
        }
        else if(state == State.PM) {
            switch(Integer.parseInt(hours)) {
                case 1: hours = "13";
                    break;
                case 2: hours = "14";
                    break;
                case 3: hours = "15";
                    break;
                case 4: hours = "16";
                    break;
                case 5: hours = "17";
                    break;
                case 6: hours = "18";
                    break;
                case 7: hours = "19";
                    break;
                case 8: hours = "20";
                    break;
                case 9: hours = "21";
                    break;
                case 10: hours = "22";
                    break;
                case 11: hours = "23";
                    break;
            }
        }

        return hours;
    }

    public static String padMinutes(int minutes) {
        String strMinutes = String.valueOf(minutes);

        if(strMinutes.length() == 1){
            return "0"+strMinutes;
        }
        else {
            return String.valueOf(minutes);
        }
    }

    public static int getMinutes() {
        return 0;
    }

    public static int convertHoursToMinutes(int hours) {
        return hours*60;
    }

    public int convertMinutesToHours(int minutes) {
        return minutes/60;
    }

    public static int convertInputTimeToMinutes(String hours, String minutes) {
//        return (convertHoursToMinutes(mapTo24HourClock(hours,abbrev)) + Integer.parseInt(minutes));
         return (convertHoursToMinutes(Integer.parseInt(hours)) + Integer.parseInt(minutes));

    }

    public static int mapTo12HourClock(int hours) {
        switch(hours) {
            case 0: hours  = 12;
                break;
            case 13: hours = 1;
                break;
            case 14: hours = 2;
                break;
            case 15: hours = 3;
                break;
            case 16: hours = 4;
                break;
            case 17: hours = 5;
                break;
            case 18: hours = 6;
                break;
            case 19: hours = 7;
                break;
            case 20: hours = 8;
                break;
            case 21: hours = 9;
                break;
            case 22: hours = 10;
                break;
            case 23: hours = 11;
                break;
        }

        return hours;
    }

    public static void main(String[] args) throws InvalidTwelveHourTimeFormatException {
        TimeImpl test = new TimeImpl();

        // Need to test:
        // 1. invalid hrs input (greater than 2 or empty/null
        // 2. invalid mins input (greater than 2 or empty/null
        // 3. invalid time abbrev. (not AM/PM)
        // 4. minutes to add exceeds max integer size
        // 5.

        System.out.println(test.addMinutes("12:00 PM", 61)); // should return 13:01 -> 1:01 PM
        System.out.println();
        System.out.println(test.addMinutes("12:00 AM", 720)); // should return 12:00 PM -> 12:00 PM
        System.out.println();
        System.out.println(test.addMinutes("12:00 AM", 30)); // should return 12:30 -> 12:30 AM
        System.out.println();
        System.out.println(test.addMinutes("12:00 AM", 1501)); // should return 01:01 -> 1:01 AM
        System.out.println();
        System.out.println(test.addMinutes("11:00 AM", 181)); // should return 01:01 -> 1:01 AM
    }
}
