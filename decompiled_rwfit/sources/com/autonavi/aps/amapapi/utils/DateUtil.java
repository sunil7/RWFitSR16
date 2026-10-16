package com.autonavi.aps.amapapi.utils;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class DateUtil {
    private static long a(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j4));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static long getCorrectedGpsTime(long j4, long j10, int i3) {
        if (i3 > 0) {
            try {
                if (Math.abs(j4 - j10) > i3 * Const.YEAR_IN_MILLIS) {
                    long a3 = a(j10) + (j4 - a(j4));
                    long abs = Math.abs(a3 - j10);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date(a3));
                    int i10 = calendar.get(11);
                    if (i10 == 23 && abs >= 82800000) {
                        a3 -= Const.DAY_IN_MILLIS;
                    }
                    return (i10 != 0 || abs < 82800000) ? a3 : a3 + Const.DAY_IN_MILLIS;
                }
            } catch (Throwable unused) {
            }
        }
        return j4;
    }
}
