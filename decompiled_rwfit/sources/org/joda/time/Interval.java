package org.joda.time;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.base.BaseInterval;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.a0;
import org.joda.time.format.v;
import org.joda.time.format.w;

/* loaded from: classes2.dex */
public final class Interval extends BaseInterval implements Serializable {
    private static final long serialVersionUID = 4922451897541386752L;

    public Interval(long j4, long j10) {
        super(j4, j10, null);
    }

    public static Interval parse(String str) {
        return new Interval(str);
    }

    public static Interval parseWithOffset(String str) {
        DateTime dateTime;
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            throw new IllegalArgumentException("Format requires a '/' separator: ".concat(str));
        }
        String substring = str.substring(0, indexOf);
        if (substring.length() <= 0) {
            throw new IllegalArgumentException("Format invalid: ".concat(str));
        }
        String substring2 = str.substring(indexOf + 1);
        if (substring2.length() <= 0) {
            throw new IllegalArgumentException("Format invalid: ".concat(str));
        }
        org.joda.time.format.b j4 = v.f17236e0.j();
        a0 a3 = w.a();
        char charAt = substring.charAt(0);
        Period period = null;
        if (charAt == 'P' || charAt == 'p') {
            period = a3.d(PeriodType.standard()).b(substring);
            dateTime = null;
        } else {
            dateTime = j4.a(substring);
        }
        char charAt2 = substring2.charAt(0);
        if (charAt2 != 'P' && charAt2 != 'p') {
            DateTime a10 = j4.a(substring2);
            return period != null ? new Interval(period, a10) : new Interval(dateTime, a10);
        }
        if (period == null) {
            return new Interval(dateTime, a3.d(PeriodType.standard()).b(substring2));
        }
        throw new IllegalArgumentException("Interval composed of two durations: ".concat(str));
    }

    public boolean abuts(i iVar) {
        if (iVar != null) {
            return iVar.getEndMillis() == getStartMillis() || getEndMillis() == iVar.getStartMillis();
        }
        AtomicReference atomicReference = c.f17022a;
        long currentTimeMillis = System.currentTimeMillis();
        return getStartMillis() == currentTimeMillis || getEndMillis() == currentTimeMillis;
    }

    public Interval gap(i iVar) {
        AtomicReference atomicReference = c.f17022a;
        if (iVar == null) {
            long currentTimeMillis = System.currentTimeMillis();
            iVar = new Interval(currentTimeMillis, currentTimeMillis);
        }
        long startMillis = iVar.getStartMillis();
        long endMillis = iVar.getEndMillis();
        long startMillis2 = getStartMillis();
        long endMillis2 = getEndMillis();
        if (startMillis2 > endMillis) {
            return new Interval(endMillis, startMillis2, getChronology());
        }
        if (startMillis > endMillis2) {
            return new Interval(endMillis2, startMillis, getChronology());
        }
        return null;
    }

    public Interval overlap(i iVar) {
        AtomicReference atomicReference = c.f17022a;
        if (iVar == null) {
            long currentTimeMillis = System.currentTimeMillis();
            iVar = new Interval(currentTimeMillis, currentTimeMillis);
        }
        if (overlaps(iVar)) {
            return new Interval(Math.max(getStartMillis(), iVar.getStartMillis()), Math.min(getEndMillis(), iVar.getEndMillis()), getChronology());
        }
        return null;
    }

    @Override // ai.d
    public Interval toInterval() {
        return this;
    }

    public Interval withChronology(a aVar) {
        return getChronology() == aVar ? this : new Interval(getStartMillis(), getEndMillis(), aVar);
    }

    public Interval withDurationAfterStart(g gVar) {
        long b3 = c.b(gVar);
        if (b3 == toDurationMillis()) {
            return this;
        }
        a chronology = getChronology();
        long startMillis = getStartMillis();
        return new Interval(startMillis, chronology.add(startMillis, b3, 1), chronology);
    }

    public Interval withDurationBeforeEnd(g gVar) {
        long b3 = c.b(gVar);
        if (b3 == toDurationMillis()) {
            return this;
        }
        a chronology = getChronology();
        long endMillis = getEndMillis();
        return new Interval(chronology.add(endMillis, b3, -1), endMillis, chronology);
    }

    public Interval withEnd(h hVar) {
        return withEndMillis(c.d(hVar));
    }

    public Interval withEndMillis(long j4) {
        return j4 == getEndMillis() ? this : new Interval(getStartMillis(), j4, getChronology());
    }

    public Interval withPeriodAfterStart(k kVar) {
        if (kVar == null) {
            return withDurationAfterStart(null);
        }
        a chronology = getChronology();
        long startMillis = getStartMillis();
        return new Interval(startMillis, chronology.add(kVar, startMillis, 1), chronology);
    }

    public Interval withPeriodBeforeEnd(k kVar) {
        if (kVar == null) {
            return withDurationBeforeEnd(null);
        }
        a chronology = getChronology();
        long endMillis = getEndMillis();
        return new Interval(chronology.add(kVar, endMillis, -1), endMillis, chronology);
    }

    public Interval withStart(h hVar) {
        return withStartMillis(c.d(hVar));
    }

    public Interval withStartMillis(long j4) {
        return j4 == getStartMillis() ? this : new Interval(j4, getEndMillis(), getChronology());
    }

    public Interval(long j4, long j10, DateTimeZone dateTimeZone) {
        super(j4, j10, ISOChronology.getInstance(dateTimeZone));
    }

    public Interval(long j4, long j10, a aVar) {
        super(j4, j10, aVar);
    }

    public Interval(h hVar, h hVar2) {
        super(hVar, hVar2);
    }

    public Interval(h hVar, g gVar) {
        super(hVar, gVar);
    }

    public Interval(g gVar, h hVar) {
        super(gVar, hVar);
    }

    public Interval(h hVar, k kVar) {
        super(hVar, kVar);
    }

    public Interval(k kVar, h hVar) {
        super(kVar, hVar);
    }

    public Interval(Object obj) {
        super(obj, (a) null);
    }

    public Interval(Object obj, a aVar) {
        super(obj, aVar);
    }
}
