package com.java.api.gios;

import java.text.ParseException;
import java.util.Date;

import static com.java.api.gios.Constants.DATE_FORMAT;

public class Util {
    public static Date parseDate(String date) {
        try {
            return DATE_FORMAT.parse(date);
        } catch (ParseException | NullPointerException e) {
            return null;
        }
    }

    public static double computeDistance(double srcLat, double srcLon, double dstLat, double dstLon) {
        return Math.sqrt(Math.pow(dstLat - srcLat, 2) + Math.pow(dstLon - srcLon, 2));
    }
}
