package com.oleksiykovtun.mongorestapp.util;

import java.text.SimpleDateFormat;

/**
 * Time converting utility
 */
public class Time {

    public static String getFullDateTimeNow() {
        final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss.SSS";
        return new SimpleDateFormat(dateTimeFormat).format(System.currentTimeMillis());
    }
}
