package com.affinipay;

import com.affinipay.exceptions.InvalidTwelveHourTimeFormatException;

public interface ITime {
    String addMinutes(String time, int minutesToAdd) throws InvalidTwelveHourTimeFormatException;
}
