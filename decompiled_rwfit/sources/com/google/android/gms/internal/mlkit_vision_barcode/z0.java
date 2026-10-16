package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Calendar;

/* loaded from: classes.dex */
public abstract class z0 {
    public static final boolean a(Calendar calendar, Calendar calendar2) {
        kotlin.jvm.internal.e.f(calendar, "<this>");
        kotlin.jvm.internal.e.f(calendar2, "calendar");
        return e(calendar, calendar2) && calendar.get(6) == calendar2.get(6);
    }

    public static final boolean b(Calendar calendar, Calendar calendar2) {
        kotlin.jvm.internal.e.f(calendar, "<this>");
        kotlin.jvm.internal.e.f(calendar2, "calendar");
        return a(calendar, calendar2) && calendar.get(11) == calendar2.get(11);
    }

    public static final boolean c(Calendar calendar, Calendar calendar2) {
        kotlin.jvm.internal.e.f(calendar, "<this>");
        kotlin.jvm.internal.e.f(calendar2, "calendar");
        return b(calendar, calendar2) && calendar.get(12) == calendar2.get(12);
    }

    public static final boolean d(Calendar calendar, Calendar calendar2) {
        kotlin.jvm.internal.e.f(calendar, "<this>");
        kotlin.jvm.internal.e.f(calendar2, "calendar");
        return e(calendar, calendar2) && calendar.get(2) == calendar2.get(2);
    }

    public static final boolean e(Calendar calendar, Calendar calendar2) {
        kotlin.jvm.internal.e.f(calendar, "<this>");
        kotlin.jvm.internal.e.f(calendar2, "calendar");
        return calendar.get(1) == calendar2.get(1);
    }
}
