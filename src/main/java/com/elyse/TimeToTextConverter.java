package com.elyse;

import java.time.LocalTime;
import java.util.Hashtable;


public class TimeToTextConverter {

    private static Hashtable<Integer, String> hours = new Hashtable<>();

    public TimeToTextConverter() {
        String[] stringHours = {"twelve AM", "one AM", "two AM", "three AM", "four AM", "five AM", "six AM", "seven AM", "eight AM",
        "nine AM", "ten AM", "eleven AM" , "twelve PM", "one PM", "two PM", "three PM", "four PM", "five PM", "six PM", "seven PM",
        "eight PM", "nine PM", "ten PM", "eleven PM", "twelve AM"};
        for (int i = 0; i <= 24; i++) {
            hours.put(i, stringHours[i]);
        }

    }


    public String amOrPm(Integer hour) {
        if (hour < 12) {
            return "AM";
        }
        else {
            return "PM";
        }
    }


    public String noonOrMidnight(Integer hour) {
        if (hour == 0 || hour == 24) {
            return "midnight";
        }
        else if (hour == 12) {
            return "noon";
        }
        else {
            return null;
        }
    }

    public String convertTimeToText(LocalTime localTime) {
        if (localTime.getMinute() == 0) {
            String hourValue = hours.get(localTime.getHour());
            String returned = noonOrMidnight(localTime.getHour());
            if ( returned != null) {
                hourValue = returned;
            }
            return hourValue;
        }
        else if (localTime.getMinute() == 30){
            String hourValue = hours.get(localTime.getHour()).replace("AM", "").replace("PM", "");
            return hourValue + "thirty " + amOrPm(localTime.getHour());
        }
        else if (localTime.getMinute() == 45) {
            String hourValue = hours.get(localTime.getHour() + 1);
            String returned = noonOrMidnight(localTime.getHour()+1);
            if ( returned != null) {
                hourValue = returned;
            }
            return "quarter to " + hourValue;
        }
        else {
            return null;
        }

    }
}
