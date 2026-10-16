package org.joda.time.chrono;

import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.field.SkipDateTimeField;

/* loaded from: classes2.dex */
public final class JulianChronology extends BasicGJChronology {
    private static final long serialVersionUID = -8731039522547897247L;
    public static final ConcurrentHashMap i0 = new ConcurrentHashMap();

    /* renamed from: h0, reason: collision with root package name */
    public static final JulianChronology f17056h0 = getInstance(DateTimeZone.UTC);

    public JulianChronology(org.joda.time.a aVar, Object obj, int i3) {
        super(aVar, obj, i3);
    }

    public static int adjustYearForSet(int i3) {
        if (i3 > 0) {
            return i3;
        }
        if (i3 != 0) {
            return i3 + 1;
        }
        throw new IllegalFieldValueException(DateTimeFieldType.year(), Integer.valueOf(i3), (Number) null, (Number) null);
    }

    public static JulianChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), 4);
    }

    public static JulianChronology getInstanceUTC() {
        return f17056h0;
    }

    private Object readResolve() {
        org.joda.time.a base = getBase();
        int minimumDaysInFirstWeek = getMinimumDaysInFirstWeek();
        if (minimumDaysInFirstWeek == 0) {
            minimumDaysInFirstWeek = 4;
        }
        return base == null ? getInstance(DateTimeZone.UTC, minimumDaysInFirstWeek) : getInstance(base.getZone(), minimumDaysInFirstWeek);
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.AssembledChronology
    public void assemble(a aVar) {
        if (getBase() == null) {
            super.assemble(aVar);
            aVar.E = new SkipDateTimeField(this, aVar.E);
            aVar.B = new SkipDateTimeField(this, aVar.B);
        }
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long calculateFirstDayOfYearMillis(int i3) {
        int i10;
        int i11 = i3 - 1968;
        if (i11 <= 0) {
            i10 = (i3 - 1965) >> 2;
        } else {
            int i12 = i11 >> 2;
            i10 = !isLeapYear(i3) ? i12 + 1 : i12;
        }
        return (((i11 * 365) + i10) * Const.DAY_IN_MILLIS) - 62035200000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getApproxMillisAtEpochDividedByTwo() {
        return 31083663600000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getAverageMillisPerMonth() {
        return 2629800000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getAverageMillisPerYear() {
        return 31557600000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getAverageMillisPerYearDividedByTwo() {
        return 15778800000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getDateMidnightMillis(int i3, int i10, int i11) throws IllegalArgumentException {
        return super.getDateMidnightMillis(adjustYearForSet(i3), i10, i11);
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public /* bridge */ /* synthetic */ long getDateTimeMillis(int i3, int i10, int i11, int i12) throws IllegalArgumentException {
        return super.getDateTimeMillis(i3, i10, i11, i12);
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getMaxYear() {
        return 292272992;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getMinYear() {
        return -292269054;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public /* bridge */ /* synthetic */ int getMinimumDaysInFirstWeek() {
        return super.getMinimumDaysInFirstWeek();
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public /* bridge */ /* synthetic */ DateTimeZone getZone() {
        return super.getZone();
    }

    @Override // org.joda.time.chrono.BasicChronology
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // org.joda.time.chrono.BasicChronology
    public boolean isLeapYear(int i3) {
        return (i3 & 3) == 0;
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withUTC() {
        return f17056h0;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getZone() ? this : getInstance(dateTimeZone);
    }

    public static JulianChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, 4);
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public /* bridge */ /* synthetic */ long getDateTimeMillis(int i3, int i10, int i11, int i12, int i13, int i14, int i15) throws IllegalArgumentException {
        return super.getDateTimeMillis(i3, i10, i11, i12, i13, i14, i15);
    }

    public static JulianChronology getInstance(DateTimeZone dateTimeZone, int i3) {
        JulianChronology julianChronology;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap concurrentHashMap = i0;
        JulianChronology[] julianChronologyArr = (JulianChronology[]) concurrentHashMap.get(dateTimeZone);
        if (julianChronologyArr == null) {
            julianChronologyArr = new JulianChronology[7];
            JulianChronology[] julianChronologyArr2 = (JulianChronology[]) concurrentHashMap.putIfAbsent(dateTimeZone, julianChronologyArr);
            if (julianChronologyArr2 != null) {
                julianChronologyArr = julianChronologyArr2;
            }
        }
        int i10 = i3 - 1;
        try {
            JulianChronology julianChronology2 = julianChronologyArr[i10];
            if (julianChronology2 != null) {
                return julianChronology2;
            }
            synchronized (julianChronologyArr) {
                try {
                    julianChronology = julianChronologyArr[i10];
                    if (julianChronology == null) {
                        DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
                        if (dateTimeZone == dateTimeZone2) {
                            julianChronology = new JulianChronology(null, null, i3);
                        } else {
                            julianChronology = new JulianChronology(ZonedChronology.getInstance(getInstance(dateTimeZone2, i3), dateTimeZone), null, i3);
                        }
                        julianChronologyArr[i10] = julianChronology;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return julianChronology;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException(l0.j(i3, "Invalid min days in first week: "));
        }
    }
}
