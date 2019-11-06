package com.marveltravel.map.ui.main.common;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Common {

    @NotNull
    public static String unixTimeStampToDateTime(double unixTimeStamp) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        date.setTime((long) unixTimeStamp * 1000);
        return dateFormat.format(date);
    }
//    public static String getDataNow(){
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMMM-YYYY Время:HH:MM:SS");
//        String format=sdf.format(cal.getTime());
//    }
}