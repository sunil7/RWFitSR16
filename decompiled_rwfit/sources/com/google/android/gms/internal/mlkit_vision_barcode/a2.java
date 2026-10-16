package com.google.android.gms.internal.mlkit_vision_barcode;

import android.text.format.DateFormat;
import com.example.test.ui.XXBaseActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class a2 {
    public static int a(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(5, 1);
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        if (calendar2.get(1) <= calendar.get(1)) {
            return calendar2.get(2) + 1;
        }
        return 12;
    }

    public static int b(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(5);
    }

    public static Date c(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.getActualMaximum(5));
        Date time = calendar.getTime();
        kotlin.jvm.internal.e.e(time, "getTime(...)");
        return time;
    }

    public static Date d(Date date) {
        return android.support.v4.media.session.e.v(Calendar.getInstance(), date, 5, 5, "getTime(...)");
    }

    public static Date e(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTime(date);
        calendar.set(7, calendar.getActualMaximum(7));
        Date time = calendar.getTime();
        kotlin.jvm.internal.e.e(time, "getTime(...)");
        return time;
    }

    public static Date f(Date date) {
        return android.support.v4.media.session.e.v(Calendar.getInstance(Locale.ENGLISH), date, 7, 7, "getTime(...)");
    }

    public static int g(XXBaseActivity xXBaseActivity, int i3, int i10) {
        Calendar u10 = android.support.v4.media.session.e.u(11, i3, 12, i10);
        if (DateFormat.is24HourFormat(xXBaseActivity)) {
            return i3;
        }
        if (u10.get(9) == 1) {
            if (i3 > 12) {
                i3 -= 12;
            }
        } else if (i3 == 0) {
            i3 = 12;
        }
        return i3 - 1;
    }

    public static Date h(String date, String str) {
        kotlin.jvm.internal.e.f(date, "date");
        try {
            return new SimpleDateFormat(str, Locale.ENGLISH).parse(date);
        } catch (Exception unused) {
            return null;
        }
    }
}
