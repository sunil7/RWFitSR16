package com.google.android.material.datepicker;

import android.content.res.Resources;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.material.R$string;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f10426a = new AtomicReference();

    public static long a(long j4) {
        Calendar f2 = f(null);
        f2.setTimeInMillis(j4);
        return b(f2).getTimeInMillis();
    }

    public static Calendar b(Calendar calendar) {
        Calendar f2 = f(calendar);
        Calendar f10 = f(null);
        f10.set(f2.get(1), f2.get(2), f2.get(5));
        return f10;
    }

    public static SimpleDateFormat c() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    public static String d(Resources resources, SimpleDateFormat simpleDateFormat) {
        String localizedPattern = simpleDateFormat.toLocalizedPattern();
        return localizedPattern.replaceAll(Const.INTENT_KEY_UMID, resources.getString(R$string.mtrl_picker_text_input_day_abbr)).replaceAll("M", resources.getString(R$string.mtrl_picker_text_input_month_abbr)).replaceAll("y", resources.getString(R$string.mtrl_picker_text_input_year_abbr));
    }

    public static Calendar e() {
        Calendar u10 = android.support.v4.media.session.e.u(11, 0, 12, 0);
        u10.set(13, 0);
        u10.set(14, 0);
        u10.setTimeZone(TimeZone.getTimeZone("UTC"));
        return u10;
    }

    public static Calendar f(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        if (calendar == null) {
            calendar2.clear();
            return calendar2;
        }
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        return calendar2;
    }
}
