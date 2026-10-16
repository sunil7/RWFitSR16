package org.joda.time.chrono;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.DateTimeZone;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.field.DecoratedDurationField;
import org.joda.time.format.v;

/* loaded from: classes2.dex */
public final class GJChronology extends AssembledChronology {
    static final Instant DEFAULT_CUTOVER = new Instant(-12219292800000L);
    public static final ConcurrentHashMap K = new ConcurrentHashMap();
    private static final long serialVersionUID = -2545574827706931671L;
    private Instant iCutoverInstant;
    private long iCutoverMillis;
    private long iGapDuration;
    private GregorianChronology iGregorianChronology;
    private JulianChronology iJulianChronology;

    public static class LinkedDurationField extends DecoratedDurationField {
        private static final long serialVersionUID = 4097975388007713084L;
        private final h iField;

        public LinkedDurationField(org.joda.time.e eVar, h hVar) {
            super(eVar, eVar.getType());
            this.iField = hVar;
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
        public long add(long j4, int i3) {
            return this.iField.add(j4, i3);
        }

        @Override // org.joda.time.field.BaseDurationField, org.joda.time.e
        public int getDifference(long j4, long j10) {
            return this.iField.getDifference(j4, j10);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
        public long getDifferenceAsLong(long j4, long j10) {
            return this.iField.getDifferenceAsLong(j4, j10);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
        public long add(long j4, long j10) {
            return this.iField.add(j4, j10);
        }
    }

    public static long b(long j4, org.joda.time.a aVar, org.joda.time.a aVar2) {
        return aVar2.millisOfDay().set(aVar2.dayOfWeek().set(aVar2.weekOfWeekyear().set(aVar2.weekyear().set(0L, aVar.weekyear().get(j4)), aVar.weekOfWeekyear().get(j4)), aVar.dayOfWeek().get(j4)), aVar.millisOfDay().get(j4));
    }

    public static GJChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), DEFAULT_CUTOVER, 4);
    }

    public static GJChronology getInstanceUTC() {
        return getInstance(DateTimeZone.UTC, DEFAULT_CUTOVER, 4);
    }

    private Object readResolve() {
        return getInstance(getZone(), this.iCutoverInstant, getMinimumDaysInFirstWeek());
    }

    @Override // org.joda.time.chrono.AssembledChronology
    public void assemble(a aVar) {
        Object[] objArr = (Object[]) getParam();
        JulianChronology julianChronology = (JulianChronology) objArr[0];
        GregorianChronology gregorianChronology = (GregorianChronology) objArr[1];
        Instant instant = (Instant) objArr[2];
        this.iCutoverMillis = instant.getMillis();
        this.iJulianChronology = julianChronology;
        this.iGregorianChronology = gregorianChronology;
        this.iCutoverInstant = instant;
        if (getBase() != null) {
            return;
        }
        if (julianChronology.getMinimumDaysInFirstWeek() != gregorianChronology.getMinimumDaysInFirstWeek()) {
            throw new IllegalArgumentException();
        }
        long j4 = this.iCutoverMillis;
        this.iGapDuration = j4 - julianToGregorianByYear(j4);
        aVar.a(gregorianChronology);
        if (gregorianChronology.millisOfDay().get(this.iCutoverMillis) == 0) {
            aVar.f17068m = new g(this, julianChronology.millisOfSecond(), aVar.f17068m, this.iCutoverMillis);
            aVar.f17069n = new g(this, julianChronology.millisOfDay(), aVar.f17069n, this.iCutoverMillis);
            aVar.f17070o = new g(this, julianChronology.secondOfMinute(), aVar.f17070o, this.iCutoverMillis);
            aVar.f17071p = new g(this, julianChronology.secondOfDay(), aVar.f17071p, this.iCutoverMillis);
            aVar.f17072q = new g(this, julianChronology.minuteOfHour(), aVar.f17072q, this.iCutoverMillis);
            aVar.r = new g(this, julianChronology.minuteOfDay(), aVar.r, this.iCutoverMillis);
            aVar.f17073s = new g(this, julianChronology.hourOfDay(), aVar.f17073s, this.iCutoverMillis);
            aVar.f17075u = new g(this, julianChronology.hourOfHalfday(), aVar.f17075u, this.iCutoverMillis);
            aVar.f17074t = new g(this, julianChronology.clockhourOfDay(), aVar.f17074t, this.iCutoverMillis);
            aVar.f17076v = new g(this, julianChronology.clockhourOfHalfday(), aVar.f17076v, this.iCutoverMillis);
            aVar.f17077w = new g(this, julianChronology.halfdayOfDay(), aVar.f17077w, this.iCutoverMillis);
        }
        aVar.I = new g(this, julianChronology.era(), aVar.I, this.iCutoverMillis);
        h hVar = new h(this, julianChronology.year(), aVar.E, this.iCutoverMillis);
        aVar.E = hVar;
        aVar.f17065j = hVar.f17091f;
        aVar.F = new h(this, julianChronology.yearOfEra(), aVar.F, aVar.f17065j, this.iCutoverMillis, false);
        h hVar2 = new h(this, julianChronology.centuryOfEra(), aVar.H, this.iCutoverMillis);
        aVar.H = hVar2;
        aVar.f17066k = hVar2.f17091f;
        aVar.G = new h(this, julianChronology.yearOfCentury(), aVar.G, aVar.f17065j, aVar.f17066k, this.iCutoverMillis);
        h hVar3 = new h(this, julianChronology.monthOfYear(), aVar.D, (org.joda.time.e) null, aVar.f17065j, this.iCutoverMillis);
        aVar.D = hVar3;
        aVar.f17064i = hVar3.f17091f;
        h hVar4 = new h(this, julianChronology.weekyear(), aVar.B, (org.joda.time.e) null, this.iCutoverMillis, true);
        aVar.B = hVar4;
        aVar.f17063h = hVar4.f17091f;
        aVar.C = new h(this, julianChronology.weekyearOfCentury(), aVar.C, aVar.f17063h, aVar.f17066k, this.iCutoverMillis);
        aVar.f17080z = new g(this, julianChronology.dayOfYear(), aVar.f17080z, aVar.f17065j, gregorianChronology.year().roundCeiling(this.iCutoverMillis), false);
        aVar.A = new g(this, julianChronology.weekOfWeekyear(), aVar.A, aVar.f17063h, gregorianChronology.weekyear().roundCeiling(this.iCutoverMillis), true);
        g gVar = new g(this, julianChronology.dayOfMonth(), aVar.f17079y, this.iCutoverMillis);
        gVar.f17092g = aVar.f17064i;
        aVar.f17079y = gVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GJChronology) {
            GJChronology gJChronology = (GJChronology) obj;
            if (this.iCutoverMillis == gJChronology.iCutoverMillis && getMinimumDaysInFirstWeek() == gJChronology.getMinimumDaysInFirstWeek() && getZone().equals(gJChronology.getZone())) {
                return true;
            }
        }
        return false;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i3, int i10, int i11, int i12) throws IllegalArgumentException {
        org.joda.time.a base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i3, i10, i11, i12);
        }
        long dateTimeMillis = this.iGregorianChronology.getDateTimeMillis(i3, i10, i11, i12);
        if (dateTimeMillis >= this.iCutoverMillis) {
            return dateTimeMillis;
        }
        long dateTimeMillis2 = this.iJulianChronology.getDateTimeMillis(i3, i10, i11, i12);
        if (dateTimeMillis2 < this.iCutoverMillis) {
            return dateTimeMillis2;
        }
        throw new IllegalArgumentException("Specified date does not exist");
    }

    public Instant getGregorianCutover() {
        return this.iCutoverInstant;
    }

    public int getMinimumDaysInFirstWeek() {
        return this.iGregorianChronology.getMinimumDaysInFirstWeek();
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public DateTimeZone getZone() {
        org.joda.time.a base = getBase();
        return base != null ? base.getZone() : DateTimeZone.UTC;
    }

    public long gregorianToJulianByWeekyear(long j4) {
        return b(j4, this.iGregorianChronology, this.iJulianChronology);
    }

    public long gregorianToJulianByYear(long j4) {
        GregorianChronology gregorianChronology = this.iGregorianChronology;
        return this.iJulianChronology.getDateTimeMillis(gregorianChronology.year().get(j4), gregorianChronology.monthOfYear().get(j4), gregorianChronology.dayOfMonth().get(j4), gregorianChronology.millisOfDay().get(j4));
    }

    public int hashCode() {
        return this.iCutoverInstant.hashCode() + getMinimumDaysInFirstWeek() + getZone().hashCode() + 25025;
    }

    public long julianToGregorianByWeekyear(long j4) {
        return b(j4, this.iJulianChronology, this.iGregorianChronology);
    }

    public long julianToGregorianByYear(long j4) {
        JulianChronology julianChronology = this.iJulianChronology;
        return this.iGregorianChronology.getDateTimeMillis(julianChronology.year().get(j4), julianChronology.monthOfYear().get(j4), julianChronology.dayOfMonth().get(j4), julianChronology.millisOfDay().get(j4));
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(60);
        stringBuffer.append("GJChronology[");
        stringBuffer.append(getZone().getID());
        if (this.iCutoverMillis != DEFAULT_CUTOVER.getMillis()) {
            stringBuffer.append(",cutover=");
            try {
                (withUTC().dayOfYear().remainder(this.iCutoverMillis) == 0 ? v.f17248o : v.E).h(withUTC()).f(stringBuffer, this.iCutoverMillis, null);
            } catch (IOException unused) {
            }
        }
        if (getMinimumDaysInFirstWeek() != 4) {
            stringBuffer.append(",mdfw=");
            stringBuffer.append(getMinimumDaysInFirstWeek());
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withUTC() {
        return withZone(DateTimeZone.UTC);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getZone() ? this : getInstance(dateTimeZone, this.iCutoverInstant, getMinimumDaysInFirstWeek());
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, DEFAULT_CUTOVER, 4);
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, org.joda.time.h hVar) {
        return getInstance(dateTimeZone, hVar, 4);
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, org.joda.time.h hVar, int i3) {
        Instant instant;
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (hVar == null) {
            instant = DEFAULT_CUTOVER;
        } else {
            instant = hVar.toInstant();
            if (new LocalDate(instant.getMillis(), GregorianChronology.getInstance(dateTimeZone)).getYear() <= 0) {
                throw new IllegalArgumentException("Cutover too early. Must be on or after 0001-01-01.");
            }
        }
        f fVar = new f(dateTimeZone, instant, i3);
        ConcurrentHashMap concurrentHashMap = K;
        GJChronology gJChronology = (GJChronology) concurrentHashMap.get(fVar);
        if (gJChronology == null) {
            DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
            if (dateTimeZone == dateTimeZone2) {
                gJChronology = new GJChronology(null, new Object[]{JulianChronology.getInstance(dateTimeZone, i3), GregorianChronology.getInstance(dateTimeZone, i3), instant});
            } else {
                GJChronology gJChronology2 = getInstance(dateTimeZone2, instant, i3);
                gJChronology = new GJChronology(ZonedChronology.getInstance(gJChronology2, dateTimeZone), new Object[]{gJChronology2.iJulianChronology, gJChronology2.iGregorianChronology, gJChronology2.iCutoverInstant});
            }
            GJChronology gJChronology3 = (GJChronology) concurrentHashMap.putIfAbsent(fVar, gJChronology);
            if (gJChronology3 != null) {
                return gJChronology3;
            }
        }
        return gJChronology;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i3, int i10, int i11, int i12, int i13, int i14, int i15) throws IllegalArgumentException {
        int i16;
        long j4;
        org.joda.time.a base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i3, i10, i11, i12, i13, i14, i15);
        }
        try {
            j4 = this.iGregorianChronology.getDateTimeMillis(i3, i10, i11, i12, i13, i14, i15);
            i16 = i11;
        } catch (IllegalFieldValueException e) {
            i16 = i11;
            if (i10 != 2) {
                throw e;
            }
            if (i16 == 29) {
                long dateTimeMillis = this.iGregorianChronology.getDateTimeMillis(i3, i10, 28, i12, i13, i14, i15);
                if (dateTimeMillis >= this.iCutoverMillis) {
                    throw e;
                }
                j4 = dateTimeMillis;
            } else {
                throw e;
            }
        }
        if (j4 < this.iCutoverMillis) {
            j4 = this.iJulianChronology.getDateTimeMillis(i3, i10, i16, i12, i13, i14, i15);
            if (j4 >= this.iCutoverMillis) {
                throw new IllegalArgumentException("Specified date does not exist");
            }
        }
        return j4;
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, long j4, int i3) {
        return getInstance(dateTimeZone, j4 == DEFAULT_CUTOVER.getMillis() ? null : new Instant(j4), i3);
    }
}
