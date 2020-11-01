package com.affinipay;

public class TimeImpl implements ITime {

    enum Abbrev {
        AM,
        PM
    }

    @Override
    public String addMinutes(String time, int minutesToAdd) {
        Abbrev abbrev = null;
        String[] timeElementsArray = extractTimeElements(time);
        System.out.println("Input timeElementsArray is: " + timeElementsArray[0] + ":" + timeElementsArray[1] + " " + timeElementsArray[2]);
        System.out.println("Minutes to add is: " + minutesToAdd);

//        System.out.println("adding INPUT + ADDED, convert minutesToAdd: " + (Integer.parseInt(timeElementsArray[0])*60 + Integer.parseInt(timeElementsArray[1]) + minutesToAdd));

        // Do calculations in 24 hour clock. Map back to 12 hour clock for output
        String hoursTo24HourClock = mapTo24HourClock(timeElementsArray[0],timeElementsArray[2]);
        int timeInputAsMinutes = convert12HourInputTimeToMinutes(hoursTo24HourClock, timeElementsArray[1]);

        // How do we know when to add vs substract?
        int totalMinutes = timeInputAsMinutes + minutesToAdd;

        int hours = convertMinutesToHours(totalMinutes)%24;
        int minutes = totalMinutes%60;

//        int convertedTotalToMins = (Integer.parseInt(timeElementsArray[0])*60 + Integer.parseInt(timeElementsArray[1]) + minutesToAdd);

//        System.out.println("answer (days) + " + (totalMinutes/60)/24);
        System.out.println("(24hr clock) Remainder of hours: " + (totalMinutes/60)%24);
//        System.out.println("answer (total hours) + " + (totalMinutes/60));
        System.out.println("(24hr clock) Remainder of minutes: " + (totalMinutes%60));



//        System.out.println();
//        // Get days
//        System.out.println("divide hours (days): " + totalHours/24);
//        // Get hours
//        System.out.println("modulus hours (hours): " + totalHours%24);
//        // Get minutesToAdd
//        System.out.println("divide minutesToAdd are (hours): " + totalMinutes/60);
//        System.out.println("modulus minutesToAdd are: " + totalMinutes%60);

        if (hours >= 0 && hours < 12) {
            abbrev = Abbrev.AM;
        }
        else if(hours >= 12 && hours <= 23) {
            abbrev = Abbrev.PM;
        }

        return String.format("%d:%s %s",mapTo12HourClock(hours),padMinutes(minutes),abbrev);
    }

    /**
     *
     * @param time
     * @return a string array containing hours [0], minutes [1], and am/pm abbreviation [2], extracted from input string
     */
    public static String[] extractTimeElements(String time) {
        String[] splitOnWhitespace = time.split(" ");
        String[] splitOnColon = splitOnWhitespace[0].split(":");

        return new String[]{splitOnColon[0],splitOnColon[1],splitOnWhitespace[1]};
    }

    public static String mapTo24HourClock(String hours, String abbrev) {
        if(abbrev.equals(Abbrev.AM.toString())) {
            switch(Integer.parseInt(hours)) {
                case 12: hours = "0";
                    break;
            }
        }
        else if(abbrev.equals(Abbrev.PM.toString())) {
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

    public static int getHours() {
        return 0;
    }

    public static int convertHoursToMinutes(int hours) {
        return hours*60;
    }

    public static int convertMinutesToHours(int minutes) {
        return minutes/60;
    }

    public static int convert12HourInputTimeToMinutes(String hours, String minutes) {
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

    public static void main(String[] args) {
        
    }
}
