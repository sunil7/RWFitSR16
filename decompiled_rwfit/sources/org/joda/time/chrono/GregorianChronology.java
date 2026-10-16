package org.joda.time.chrono;

import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public final class GregorianChronology extends BasicGJChronology {
    private static final long serialVersionUID = -861407383323710522L;
    public static final ConcurrentHashMap i0 = new ConcurrentHashMap();

    /* renamed from: h0, reason: collision with root package name */
    public static final GregorianChronology f17054h0 = getInstance(DateTimeZone.UTC);

    public static GregorianChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), 4);
    }

    public static GregorianChronology getInstanceUTC() {
        return f17054h0;
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
        }
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long calculateFirstDayOfYearMillis(int i3) {
        int i10;
        int i11 = i3 / 100;
        if (i3 < 0) {
            i10 = ((((i3 + 3) >> 2) - i11) + ((i11 + 3) >> 2)) - 1;
        } else {
            i10 = ((i3 >> 2) - i11) + (i11 >> 2);
            if (isLeapYear(i3)) {
                i10--;
            }
        }
        return ((i3 * 365) + (i10 - 719527)) * Const.DAY_IN_MILLIS;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getApproxMillisAtEpochDividedByTwo() {
        return 31083597720000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getAverageMillisPerMonth() {
        return 2629746000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getAverageMillisPerYear() {
        return 31556952000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getAverageMillisPerYearDividedByTwo() {
        return 15778476000L;
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public /* bridge */ /* synthetic */ long getDateTimeMillis(int i3, int i10, int i11, int i12) throws IllegalArgumentException {
        return super.getDateTimeMillis(i3, i10, i11, i12);
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getMaxYear() {
        return 292278993;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getMinYear() {
        return -292275054;
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
        if ((i3 & 3) == 0) {
            return i3 % 100 != 0 || i3 % 400 == 0;
        }
        return false;
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withUTC() {
        return f17054h0;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getZone() ? this : getInstance(dateTimeZone);
    }

    public static GregorianChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, 4);
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public /* bridge */ /* synthetic */ long getDateTimeMillis(int i3, int i10, int i11, int i12, int i13, int i14, int i15) throws IllegalArgumentException {
        return super.getDateTimeMillis(i3, i10, i11, i12, i13, i14, i15);
    }

    public static GregorianChronology getInstance(DateTimeZone dateTimeZone, int i3) {
        GregorianChronology gregorianChronology;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap concurrentHashMap = i0;
        GregorianChronology[] gregorianChronologyArr = (GregorianChronology[]) concurrentHashMap.get(dateTimeZone);
        if (gregorianChronologyArr == null) {
            gregorianChronologyArr = new GregorianChronology[7];
            GregorianChronology[] gregorianChronologyArr2 = (GregorianChronology[]) concurrentHashMap.putIfAbsent(dateTimeZone, gregorianChronologyArr);
            if (gregorianChronologyArr2 != null) {
                gregorianChronologyArr = gregorianChronologyArr2;
            }
        }
        int i10 = i3 - 1;
        try {
            GregorianChronology gregorianChronology2 = gregorianChronologyArr[i10];
            if (gregorianChronology2 != null) {
                return gregorianChronology2;
            }
            synchronized (gregorianChronologyArr) {
                try {
                    gregorianChronology = gregorianChronologyArr[i10];
                    if (gregorianChronology == null) {
                        DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
                        if (dateTimeZone == dateTimeZone2) {
                            gregorianChronology = new GregorianChronology(null, null, i3);
                        } else {
                            gregorianChronology = new GregorianChronology(ZonedChronology.getInstance(getInstance(dateTimeZone2, i3), dateTimeZone), null, i3);
                        }
                        gregorianChronologyArr[i10] = gregorianChronology;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return gregorianChronology;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException(l0.j(i3, "Invalid min days in first week: "));
        }
    }
}
