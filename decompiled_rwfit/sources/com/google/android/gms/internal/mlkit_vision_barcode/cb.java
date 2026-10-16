package com.google.android.gms.internal.mlkit_vision_barcode;

import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class cb {
    public static String a(long j4) {
        Calendar e = com.google.android.material.datepicker.e0.e();
        Calendar f2 = com.google.android.material.datepicker.e0.f(null);
        f2.setTimeInMillis(j4);
        return e.get(1) == f2.get(1) ? b(j4, Locale.getDefault()) : c(j4, Locale.getDefault());
    }

    public static String b(long j4, Locale locale) {
        AtomicReference atomicReference = com.google.android.material.datepicker.e0.f10426a;
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("MMMd", locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        return instanceForSkeleton.format(new Date(j4));
    }

    public static String c(long j4, Locale locale) {
        AtomicReference atomicReference = com.google.android.material.datepicker.e0.f10426a;
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMd", locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        return instanceForSkeleton.format(new Date(j4));
    }
}
