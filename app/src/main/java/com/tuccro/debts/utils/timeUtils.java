package com.tuccro.debts.utils;

import java.text.SimpleDateFormat;

public abstract class timeUtils {

    public static String getTimeFromMillis(long time) {

        String curStringTime = new SimpleDateFormat("HH:mm:ss").format(time);
        return curStringTime;
    }

    public static String getDateFromMillis(long time) {

        String curStringDate = new SimpleDateFormat("dd MM yyyy").format(time);
        return curStringDate;
    }
}
