package org.joda.time;

import java.text.DateFormatSymbols;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.chrono.ISOChronology;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f17022a = new AtomicReference();

    public static final DateFormatSymbols a(Locale locale) {
        try {
            return (DateFormatSymbols) DateFormatSymbols.class.getMethod("getInstance", Locale.class).invoke(null, locale);
        } catch (Exception unused) {
            return new DateFormatSymbols(locale);
        }
    }

    public static final long b(g gVar) {
        if (gVar == null) {
            return 0L;
        }
        return gVar.getMillis();
    }

    public static final a c(h hVar) {
        a chronology;
        return (hVar == null || (chronology = hVar.getChronology()) == null) ? ISOChronology.getInstance() : chronology;
    }

    public static final long d(h hVar) {
        return hVar == null ? System.currentTimeMillis() : hVar.getMillis();
    }

    public static final boolean e(j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Partial must not be null");
        }
        DurationFieldType durationFieldType = null;
        for (int i3 = 0; i3 < jVar.size(); i3++) {
            b field = jVar.getField(i3);
            if (i3 > 0 && (field.getRangeDurationField() == null || field.getRangeDurationField().getType() != durationFieldType)) {
                return false;
            }
            durationFieldType = field.getDurationField().getType();
        }
        return true;
    }

    public static void f(LinkedHashMap linkedHashMap, String str, String str2) {
        try {
            linkedHashMap.put(str, DateTimeZone.forID(str2));
        } catch (RuntimeException unused) {
        }
    }
}
