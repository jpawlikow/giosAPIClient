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
}
