package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.DateTimeZone;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;

/* loaded from: classes.dex */
public abstract class b1 implements bi.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9231a = 1;

    public org.joda.time.a a(Object obj, org.joda.time.a aVar) {
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        return aVar == null ? ISOChronology.getInstance() : aVar;
    }

    public org.joda.time.a b(Object obj, DateTimeZone dateTimeZone) {
        return ISOChronology.getInstance(dateTimeZone);
    }

    public int[] c(ai.e eVar, Object obj, org.joda.time.a aVar, org.joda.time.format.b bVar) {
        return j(eVar, obj, aVar);
    }

    public long d(Object obj, org.joda.time.a aVar) {
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        return System.currentTimeMillis();
    }

    public PeriodType h(Object obj) {
        return PeriodType.standard();
    }

    public int[] j(ai.e eVar, Object obj, org.joda.time.a aVar) {
        return aVar.get(eVar, d(obj, aVar));
    }

    public String toString() {
        switch (this.f9231a) {
            case 1:
                return r5.a.f(new StringBuilder("Converter["), e() == null ? "null" : e().getName(), "]");
            default:
                return super.toString();
        }
    }
}
