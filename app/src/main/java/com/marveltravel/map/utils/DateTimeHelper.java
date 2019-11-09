package com.marveltravel.map.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeHelper {

    private static final String CURRENT_DATETIME_PATTERN = "dd-MMMM-YYYY Время:HH:MM";
    private static final String CURRENT_TIME_PATTERN = "HH:mm";

    public static String getCurrentDateTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(CURRENT_DATETIME_PATTERN, Locale.getDefault());

        return sdf.format(cal.getTime());
    }

    public static String parseDateToTime(double time) {
        DateFormat dateFormat = new SimpleDateFormat(CURRENT_TIME_PATTERN, Locale.getDefault());
        Date date = new Date();
        date.setTime((long) time * 1000);
        return dateFormat.format(date.getTime());
    }
}