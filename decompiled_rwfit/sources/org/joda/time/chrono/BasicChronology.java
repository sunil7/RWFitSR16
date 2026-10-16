package org.joda.time.chrono;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.field.MillisDurationField;
import org.joda.time.field.PreciseDurationField;

/* loaded from: classes2.dex */
abstract class BasicChronology extends AssembledChronology {
    public static final org.joda.time.e L;
    public static final PreciseDurationField M;
    public static final PreciseDurationField N;
    public static final PreciseDurationField O;
    public static final PreciseDurationField P;
    public static final PreciseDurationField Q;
    public static final PreciseDurationField R;
    public static final org.joda.time.field.g S;
    public static final org.joda.time.field.g T;
    public static final org.joda.time.field.g U;
    public static final org.joda.time.field.g V;
    public static final org.joda.time.field.g W;
    public static final org.joda.time.field.g X;
    public static final org.joda.time.field.g Y;
    public static final org.joda.time.field.g Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final org.joda.time.field.j f17047a0;

    /* renamed from: b0, reason: collision with root package name */
    public static final org.joda.time.field.j f17048b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final b f17049c0;
    private static final long serialVersionUID = 8283225332206808863L;
    public final transient c[] K;
    private final int iMinDaysInFirstWeek;

    static {
        org.joda.time.e eVar = MillisDurationField.INSTANCE;
        L = eVar;
        PreciseDurationField preciseDurationField = new PreciseDurationField(DurationFieldType.seconds(), 1000L);
        M = preciseDurationField;
        PreciseDurationField preciseDurationField2 = new PreciseDurationField(DurationFieldType.minutes(), 60000L);
        N = preciseDurationField2;
        PreciseDurationField preciseDurationField3 = new PreciseDurationField(DurationFieldType.hours(), Const.L_WIFI_EXP);
        O = preciseDurationField3;
        PreciseDurationField preciseDurationField4 = new PreciseDurationField(DurationFieldType.halfdays(), 43200000L);
        P = preciseDurationField4;
        PreciseDurationField preciseDurationField5 = new PreciseDurationField(DurationFieldType.days(), Const.DAY_IN_MILLIS);
        Q = preciseDurationField5;
        R = new PreciseDurationField(DurationFieldType.weeks(), 604800000L);
        S = new org.joda.time.field.g(DateTimeFieldType.millisOfSecond(), eVar, preciseDurationField);
        T = new org.joda.time.field.g(DateTimeFieldType.millisOfDay(), eVar, preciseDurationField5);
        U = new org.joda.time.field.g(DateTimeFieldType.secondOfMinute(), preciseDurationField, preciseDurationField2);
        V = new org.joda.time.field.g(DateTimeFieldType.secondOfDay(), preciseDurationField, preciseDurationField5);
        W = new org.joda.time.field.g(DateTimeFieldType.minuteOfHour(), preciseDurationField2, preciseDurationField3);
        X = new org.joda.time.field.g(DateTimeFieldType.minuteOfDay(), preciseDurationField2, preciseDurationField5);
        org.joda.time.field.g gVar = new org.joda.time.field.g(DateTimeFieldType.hourOfDay(), preciseDurationField3, preciseDurationField5);
        Y = gVar;
        org.joda.time.field.g gVar2 = new org.joda.time.field.g(DateTimeFieldType.hourOfHalfday(), preciseDurationField3, preciseDurationField4);
        Z = gVar2;
        f17047a0 = new org.joda.time.field.j(gVar, DateTimeFieldType.clockhourOfDay());
        f17048b0 = new org.joda.time.field.j(gVar2, DateTimeFieldType.clockhourOfHalfday());
        f17049c0 = new b(DateTimeFieldType.halfdayOfDay(), P, Q);
    }

    public BasicChronology(org.joda.time.a aVar, Object obj, int i3) {
        super(aVar, obj);
        this.K = new c[1024];
        if (i3 < 1 || i3 > 7) {
            throw new IllegalArgumentException(l0.j(i3, "Invalid min days in first week: "));
        }
        this.iMinDaysInFirstWeek = i3;
    }

    @Override // org.joda.time.chrono.AssembledChronology
    public void assemble(a aVar) {
        aVar.f17057a = L;
        aVar.f17058b = M;
        aVar.f17059c = N;
        aVar.f17060d = O;
        aVar.e = P;
        aVar.f17061f = Q;
        aVar.f17062g = R;
        aVar.f17068m = S;
        aVar.f17069n = T;
        aVar.f17070o = U;
        aVar.f17071p = V;
        aVar.f17072q = W;
        aVar.r = X;
        aVar.f17073s = Y;
        aVar.f17075u = Z;
        aVar.f17074t = f17047a0;
        aVar.f17076v = f17048b0;
        aVar.f17077w = f17049c0;
        e eVar = new e(this, 1);
        aVar.E = eVar;
        l lVar = new l(eVar, this);
        aVar.F = lVar;
        org.joda.time.field.f fVar = new org.joda.time.field.f(lVar, 99);
        org.joda.time.field.d dVar = new org.joda.time.field.d(fVar, fVar.f17131b.getRangeDurationField(), DateTimeFieldType.centuryOfEra());
        aVar.H = dVar;
        aVar.f17066k = dVar.f17133d;
        aVar.G = new org.joda.time.field.f(new org.joda.time.field.i(dVar), DateTimeFieldType.yearOfCentury(), 1);
        aVar.I = new i(this);
        aVar.f17078x = new d(this, aVar.f17061f, 3);
        aVar.f17079y = new d(this, aVar.f17061f, 0);
        aVar.f17080z = new d(this, aVar.f17061f, 1);
        aVar.D = new k(this);
        aVar.B = new e(this, 0);
        aVar.A = new d(this, aVar.f17062g, 2);
        aVar.C = new org.joda.time.field.f(new org.joda.time.field.i(aVar.B, aVar.f17066k, DateTimeFieldType.weekyearOfCentury()), DateTimeFieldType.weekyearOfCentury(), 1);
        aVar.f17065j = aVar.E.getDurationField();
        aVar.f17064i = aVar.D.getDurationField();
        aVar.f17063h = aVar.B.getDurationField();
    }

    public final long b(int i3, int i10, int i11, int i12) {
        long dateMidnightMillis = getDateMidnightMillis(i3, i10, i11);
        if (dateMidnightMillis == Long.MIN_VALUE) {
            dateMidnightMillis = getDateMidnightMillis(i3, i10, i11 + 1);
            i12 -= 86400000;
        }
        long j4 = i12 + dateMidnightMillis;
        if (j4 < 0 && dateMidnightMillis > 0) {
            return Format.OFFSET_SAMPLE_RELATIVE;
        }
        if (j4 <= 0 || dateMidnightMillis >= 0) {
            return j4;
        }
        return Long.MIN_VALUE;
    }

    public abstract long calculateFirstDayOfYearMillis(int i3);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BasicChronology basicChronology = (BasicChronology) obj;
            if (getMinimumDaysInFirstWeek() == basicChronology.getMinimumDaysInFirstWeek() && getZone().equals(basicChronology.getZone())) {
                return true;
            }
        }
        return false;
    }

    public abstract long getApproxMillisAtEpochDividedByTwo();

    public abstract long getAverageMillisPerMonth();

    public abstract long getAverageMillisPerYear();

    public abstract long getAverageMillisPerYearDividedByTwo();

    public long getDateMidnightMillis(int i3, int i10, int i11) {
        nf.l(DateTimeFieldType.year(), i3, getMinYear() - 1, getMaxYear() + 1);
        nf.l(DateTimeFieldType.monthOfYear(), i10, 1, getMaxMonth(i3));
        nf.l(DateTimeFieldType.dayOfMonth(), i11, 1, getDaysInYearMonth(i3, i10));
        long yearMonthDayMillis = getYearMonthDayMillis(i3, i10, i11);
        if (yearMonthDayMillis < 0 && i3 == getMaxYear() + 1) {
            return Format.OFFSET_SAMPLE_RELATIVE;
        }
        if (yearMonthDayMillis <= 0 || i3 != getMinYear() - 1) {
            return yearMonthDayMillis;
        }
        return Long.MIN_VALUE;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i3, int i10, int i11, int i12) throws IllegalArgumentException {
        org.joda.time.a base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i3, i10, i11, i12);
        }
        nf.l(DateTimeFieldType.millisOfDay(), i12, 0, 86399999);
        return b(i3, i10, i11, i12);
    }

    public int getDayOfMonth(long j4) {
        int year = getYear(j4);
        return getDayOfMonth(j4, year, getMonthOfYear(j4, year));
    }

    public int getDayOfWeek(long j4) {
        long j10;
        if (j4 >= 0) {
            j10 = j4 / Const.DAY_IN_MILLIS;
        } else {
            j10 = (j4 - 86399999) / Const.DAY_IN_MILLIS;
            if (j10 < -3) {
                return ((int) ((j10 + 4) % 7)) + 7;
            }
        }
        return ((int) ((j10 + 3) % 7)) + 1;
    }

    public int getDayOfYear(long j4) {
        return getDayOfYear(j4, getYear(j4));
    }

    public int getDaysInMonthMax() {
        return 31;
    }

    public abstract int getDaysInMonthMax(int i3);

    public int getDaysInMonthMaxForSet(long j4, int i3) {
        return getDaysInMonthMax(j4);
    }

    public int getDaysInYear(int i3) {
        return isLeapYear(i3) ? 366 : 365;
    }

    public int getDaysInYearMax() {
        return 366;
    }

    public abstract int getDaysInYearMonth(int i3, int i10);

    public long getFirstWeekOfYearMillis(int i3) {
        long yearMillis = getYearMillis(i3);
        return getDayOfWeek(yearMillis) > 8 - this.iMinDaysInFirstWeek ? ((8 - r8) * Const.DAY_IN_MILLIS) + yearMillis : yearMillis - ((r8 - 1) * Const.DAY_IN_MILLIS);
    }

    public int getMaxMonth() {
        return 12;
    }

    public abstract int getMaxYear();

    public int getMillisOfDay(long j4) {
        return j4 >= 0 ? (int) (j4 % Const.DAY_IN_MILLIS) : ((int) ((j4 + 1) % Const.DAY_IN_MILLIS)) + 86399999;
    }

    public abstract int getMinYear();

    public int getMinimumDaysInFirstWeek() {
        return this.iMinDaysInFirstWeek;
    }

    public int getMonthOfYear(long j4) {
        return getMonthOfYear(j4, getYear(j4));
    }

    public abstract int getMonthOfYear(long j4, int i3);

    public abstract long getTotalMillisByYearMonth(int i3, int i10);

    public int getWeekOfWeekyear(long j4) {
        return getWeekOfWeekyear(j4, getYear(j4));
    }

    public int getWeeksInYear(int i3) {
        return (int) ((getFirstWeekOfYearMillis(i3 + 1) - getFirstWeekOfYearMillis(i3)) / 604800000);
    }

    public int getWeekyear(long j4) {
        int year = getYear(j4);
        int weekOfWeekyear = getWeekOfWeekyear(j4, year);
        return weekOfWeekyear == 1 ? getYear(j4 + 604800000) : weekOfWeekyear > 51 ? getYear(j4 - Const.L_MAX_HM) : year;
    }

    public int getYear(long j4) {
        long averageMillisPerYearDividedByTwo = getAverageMillisPerYearDividedByTwo();
        long approxMillisAtEpochDividedByTwo = (j4 >> 1) + getApproxMillisAtEpochDividedByTwo();
        if (approxMillisAtEpochDividedByTwo < 0) {
            approxMillisAtEpochDividedByTwo = (approxMillisAtEpochDividedByTwo - averageMillisPerYearDividedByTwo) + 1;
        }
        int i3 = (int) (approxMillisAtEpochDividedByTwo / averageMillisPerYearDividedByTwo);
        long yearMillis = getYearMillis(i3);
        long j10 = j4 - yearMillis;
        if (j10 < 0) {
            return i3 - 1;
        }
        long j11 = Const.YEAR_IN_MILLIS;
        if (j10 < Const.YEAR_IN_MILLIS) {
            return i3;
        }
        if (isLeapYear(i3)) {
            j11 = 31622400000L;
        }
        return yearMillis + j11 <= j4 ? i3 + 1 : i3;
    }

    public abstract long getYearDifference(long j4, long j10);

    public long getYearMillis(int i3) {
        int i10 = i3 & 1023;
        c[] cVarArr = this.K;
        c cVar = cVarArr[i10];
        if (cVar == null || cVar.f17081a != i3) {
            cVar = new c(i3, calculateFirstDayOfYearMillis(i3));
            cVarArr[i10] = cVar;
        }
        return cVar.f17082b;
    }

    public long getYearMonthDayMillis(int i3, int i10, int i11) {
        return ((i11 - 1) * Const.DAY_IN_MILLIS) + getYearMillis(i3) + getTotalMillisByYearMonth(i3, i10);
    }

    public long getYearMonthMillis(int i3, int i10) {
        return getYearMillis(i3) + getTotalMillisByYearMonth(i3, i10);
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public DateTimeZone getZone() {
        org.joda.time.a base = getBase();
        return base != null ? base.getZone() : DateTimeZone.UTC;
    }

    public int hashCode() {
        return getZone().hashCode() + (getClass().getName().hashCode() * 11) + getMinimumDaysInFirstWeek();
    }

    public boolean isLeapDay(long j4) {
        return false;
    }

    public abstract boolean isLeapYear(int i3);

    public abstract long setYear(long j4, int i3);

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public String toString() {
        StringBuilder sb2 = new StringBuilder(60);
        String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            name = name.substring(lastIndexOf + 1);
        }
        sb2.append(name);
        sb2.append('[');
        DateTimeZone zone = getZone();
        if (zone != null) {
            sb2.append(zone.getID());
        }
        if (getMinimumDaysInFirstWeek() != 4) {
            sb2.append(",mdfw=");
            sb2.append(getMinimumDaysInFirstWeek());
        }
        sb2.append(']');
        return sb2.toString();
    }

    public int getDayOfYear(long j4, int i3) {
        return ((int) ((j4 - getYearMillis(i3)) / Const.DAY_IN_MILLIS)) + 1;
    }

    public int getDaysInMonthMax(long j4) {
        int year = getYear(j4);
        return getDaysInYearMonth(year, getMonthOfYear(j4, year));
    }

    public int getMaxMonth(int i3) {
        return getMaxMonth();
    }

    public int getWeekOfWeekyear(long j4, int i3) {
        long firstWeekOfYearMillis = getFirstWeekOfYearMillis(i3);
        if (j4 < firstWeekOfYearMillis) {
            return getWeeksInYear(i3 - 1);
        }
        if (j4 >= getFirstWeekOfYearMillis(i3 + 1)) {
            return 1;
        }
        return ((int) ((j4 - firstWeekOfYearMillis) / 604800000)) + 1;
    }

    public int getDayOfMonth(long j4, int i3) {
        return getDayOfMonth(j4, i3, getMonthOfYear(j4, i3));
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i3, int i10, int i11, int i12, int i13, int i14, int i15) throws IllegalArgumentException {
        org.joda.time.a base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i3, i10, i11, i12, i13, i14, i15);
        }
        nf.l(DateTimeFieldType.hourOfDay(), i12, 0, 23);
        nf.l(DateTimeFieldType.minuteOfHour(), i13, 0, 59);
        nf.l(DateTimeFieldType.secondOfMinute(), i14, 0, 59);
        nf.l(DateTimeFieldType.millisOfSecond(), i15, 0, GLMapStaticValue.MAPRENDER_CAN_STOP_AND_FULLSCREEN_RENDEROVER);
        return b(i3, i10, i11, (i14 * 1000) + (i13 * 60000) + (i12 * 3600000) + i15);
    }

    public int getDayOfMonth(long j4, int i3, int i10) {
        return ((int) ((j4 - (getYearMillis(i3) + getTotalMillisByYearMonth(i3, i10))) / Const.DAY_IN_MILLIS)) + 1;
    }
}
