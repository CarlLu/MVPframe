package com.example.administrator.mvpframe.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static SimpleDateFormat sdf;

    private static SimpleDateFormat getSimpleDateFormat(String format) {
        sdf = new SimpleDateFormat(format);
        return sdf;
    }

    public static CharSequence formatMills(long duration, String format) {
        getSimpleDateFormat(format);
        // 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        Date dt2 = new Date(duration);
        String sDateTime = sdf.format(dt2); // 得到精确到秒的表示：08/31/2006 21:08:00
        return sDateTime;
    }

    public static CharSequence formatMills(long duration) {
        return formatMills(duration, "yyyy/MM/dd HH:mm:ss");
    }
}
