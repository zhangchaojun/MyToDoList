package com.cj.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cj on 2020/12/7.
 */
public class TimeUtil {

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getFormatDate() {
        long timeMillis = System.currentTimeMillis();
        String format = simpleDateFormat.format(new Date(timeMillis));
        return format;
    }

    public static long getTimeMillis() {
        return System.currentTimeMillis();
    }
}
