package org.affinipay;

import com.affinipay.exceptions.InvalidTwelveHourClockTimeFormatException;

public interface ITime {
    String addMinutes(String time, int minutesToAdd) throws InvalidTwelveHourClockTimeFormatException;
}
