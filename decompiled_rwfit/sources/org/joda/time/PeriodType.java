package org.joda.time;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class PeriodType implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static PeriodType f17002b = null;

    /* renamed from: c, reason: collision with root package name */
    public static PeriodType f17003c = null;

    /* renamed from: d, reason: collision with root package name */
    public static PeriodType f17004d = null;
    public static PeriodType e = null;

    /* renamed from: f, reason: collision with root package name */
    public static PeriodType f17005f = null;

    /* renamed from: g, reason: collision with root package name */
    public static PeriodType f17006g = null;

    /* renamed from: h, reason: collision with root package name */
    public static PeriodType f17007h = null;

    /* renamed from: i, reason: collision with root package name */
    public static PeriodType f17008i = null;

    /* renamed from: j, reason: collision with root package name */
    public static PeriodType f17009j = null;

    /* renamed from: k, reason: collision with root package name */
    public static PeriodType f17010k = null;

    /* renamed from: l, reason: collision with root package name */
    public static PeriodType f17011l = null;

    /* renamed from: m, reason: collision with root package name */
    public static PeriodType f17012m = null;

    /* renamed from: n, reason: collision with root package name */
    public static PeriodType f17013n = null;

    /* renamed from: o, reason: collision with root package name */
    public static PeriodType f17014o = null;

    /* renamed from: p, reason: collision with root package name */
    public static PeriodType f17015p = null;

    /* renamed from: q, reason: collision with root package name */
    public static PeriodType f17016q = null;
    public static PeriodType r = null;
    private static final long serialVersionUID = 2274324892792009998L;
    private final int[] iIndices;
    private final String iName;
    private final DurationFieldType[] iTypes;

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f17001a = new HashMap(32);
    static int YEAR_INDEX = 0;
    static int MONTH_INDEX = 1;
    static int WEEK_INDEX = 2;
    static int DAY_INDEX = 3;
    static int HOUR_INDEX = 4;
    static int MINUTE_INDEX = 5;
    static int SECOND_INDEX = 6;
    static int MILLI_INDEX = 7;

    public PeriodType(String str, DurationFieldType[] durationFieldTypeArr, int[] iArr) {
        this.iName = str;
        this.iTypes = durationFieldTypeArr;
        this.iIndices = iArr;
    }

    public static PeriodType dayTime() {
        PeriodType periodType = f17008i;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("DayTime", new DurationFieldType[]{DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis()}, new int[]{-1, -1, -1, 0, 1, 2, 3, 4});
        f17008i = periodType2;
        return periodType2;
    }

    public static PeriodType days() {
        PeriodType periodType = f17013n;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Days", new DurationFieldType[]{DurationFieldType.days()}, new int[]{-1, -1, -1, 0, -1, -1, -1, -1});
        f17013n = periodType2;
        return periodType2;
    }

    public static synchronized PeriodType forFields(DurationFieldType[] durationFieldTypeArr) {
        synchronized (PeriodType.class) {
            if (durationFieldTypeArr != null) {
                try {
                    if (durationFieldTypeArr.length != 0) {
                        for (DurationFieldType durationFieldType : durationFieldTypeArr) {
                            if (durationFieldType == null) {
                                throw new IllegalArgumentException("Types array must not contain null");
                            }
                        }
                        HashMap hashMap = f17001a;
                        if (hashMap.isEmpty()) {
                            hashMap.put(standard(), standard());
                            hashMap.put(yearMonthDayTime(), yearMonthDayTime());
                            hashMap.put(yearMonthDay(), yearMonthDay());
                            hashMap.put(yearWeekDayTime(), yearWeekDayTime());
                            hashMap.put(yearWeekDay(), yearWeekDay());
                            hashMap.put(yearDayTime(), yearDayTime());
                            hashMap.put(yearDay(), yearDay());
                            hashMap.put(dayTime(), dayTime());
                            hashMap.put(time(), time());
                            hashMap.put(years(), years());
                            hashMap.put(months(), months());
                            hashMap.put(weeks(), weeks());
                            hashMap.put(days(), days());
                            hashMap.put(hours(), hours());
                            hashMap.put(minutes(), minutes());
                            hashMap.put(seconds(), seconds());
                            hashMap.put(millis(), millis());
                        }
                        PeriodType periodType = new PeriodType(null, durationFieldTypeArr, null);
                        Object obj = hashMap.get(periodType);
                        if (obj instanceof PeriodType) {
                            return (PeriodType) obj;
                        }
                        if (obj != null) {
                            throw new IllegalArgumentException("PeriodType does not support fields: " + obj);
                        }
                        PeriodType standard = standard();
                        ArrayList arrayList = new ArrayList(Arrays.asList(durationFieldTypeArr));
                        if (!arrayList.remove(DurationFieldType.years())) {
                            standard = standard.withYearsRemoved();
                        }
                        if (!arrayList.remove(DurationFieldType.months())) {
                            standard = standard.withMonthsRemoved();
                        }
                        if (!arrayList.remove(DurationFieldType.weeks())) {
                            standard = standard.withWeeksRemoved();
                        }
                        if (!arrayList.remove(DurationFieldType.days())) {
                            standard = standard.withDaysRemoved();
                        }
                        if (!arrayList.remove(DurationFieldType.hours())) {
                            standard = standard.withHoursRemoved();
                        }
                        if (!arrayList.remove(DurationFieldType.minutes())) {
                            standard = standard.withMinutesRemoved();
                        }
                        if (!arrayList.remove(DurationFieldType.seconds())) {
                            standard = standard.withSecondsRemoved();
                        }
                        if (!arrayList.remove(DurationFieldType.millis())) {
                            standard = standard.withMillisRemoved();
                        }
                        if (arrayList.size() > 0) {
                            hashMap.put(periodType, arrayList);
                            throw new IllegalArgumentException("PeriodType does not support fields: " + arrayList);
                        }
                        PeriodType periodType2 = new PeriodType(null, standard.iTypes, null);
                        PeriodType periodType3 = (PeriodType) hashMap.get(periodType2);
                        if (periodType3 != null) {
                            hashMap.put(periodType2, periodType3);
                            return periodType3;
                        }
                        hashMap.put(periodType2, standard);
                        return standard;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            throw new IllegalArgumentException("Types array must not be null or empty");
        }
    }

    public static PeriodType hours() {
        PeriodType periodType = f17014o;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Hours", new DurationFieldType[]{DurationFieldType.hours()}, new int[]{-1, -1, -1, -1, 0, -1, -1, -1});
        f17014o = periodType2;
        return periodType2;
    }

    public static PeriodType millis() {
        PeriodType periodType = r;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Millis", new DurationFieldType[]{DurationFieldType.millis()}, new int[]{-1, -1, -1, -1, -1, -1, -1, 0});
        r = periodType2;
        return periodType2;
    }

    public static PeriodType minutes() {
        PeriodType periodType = f17015p;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Minutes", new DurationFieldType[]{DurationFieldType.minutes()}, new int[]{-1, -1, -1, -1, -1, 0, -1, -1});
        f17015p = periodType2;
        return periodType2;
    }

    public static PeriodType months() {
        PeriodType periodType = f17011l;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Months", new DurationFieldType[]{DurationFieldType.months()}, new int[]{-1, 0, -1, -1, -1, -1, -1, -1});
        f17011l = periodType2;
        return periodType2;
    }

    public static PeriodType seconds() {
        PeriodType periodType = f17016q;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Seconds", new DurationFieldType[]{DurationFieldType.seconds()}, new int[]{-1, -1, -1, -1, -1, -1, 0, -1});
        f17016q = periodType2;
        return periodType2;
    }

    public static PeriodType standard() {
        PeriodType periodType = f17002b;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Standard", new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.months(), DurationFieldType.weeks(), DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis()}, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        f17002b = periodType2;
        return periodType2;
    }

    public static PeriodType time() {
        PeriodType periodType = f17009j;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Time", new DurationFieldType[]{DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis()}, new int[]{-1, -1, -1, -1, 0, 1, 2, 3});
        f17009j = periodType2;
        return periodType2;
    }

    public static PeriodType weeks() {
        PeriodType periodType = f17012m;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Weeks", new DurationFieldType[]{DurationFieldType.weeks()}, new int[]{-1, -1, 0, -1, -1, -1, -1, -1});
        f17012m = periodType2;
        return periodType2;
    }

    public static PeriodType yearDay() {
        PeriodType periodType = f17007h;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("YearDay", new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.days()}, new int[]{0, -1, -1, 1, -1, -1, -1, -1});
        f17007h = periodType2;
        return periodType2;
    }

    public static PeriodType yearDayTime() {
        PeriodType periodType = f17006g;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("YearDayTime", new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis()}, new int[]{0, -1, -1, 1, 2, 3, 4, 5});
        f17006g = periodType2;
        return periodType2;
    }

    public static PeriodType yearMonthDay() {
        PeriodType periodType = f17004d;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("YearMonthDay", new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.months(), DurationFieldType.days()}, new int[]{0, 1, -1, 2, -1, -1, -1, -1});
        f17004d = periodType2;
        return periodType2;
    }

    public static PeriodType yearMonthDayTime() {
        PeriodType periodType = f17003c;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("YearMonthDayTime", new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.months(), DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis()}, new int[]{0, 1, -1, 2, 3, 4, 5, 6});
        f17003c = periodType2;
        return periodType2;
    }

    public static PeriodType yearWeekDay() {
        PeriodType periodType = f17005f;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("YearWeekDay", new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.weeks(), DurationFieldType.days()}, new int[]{0, -1, 1, 2, -1, -1, -1, -1});
        f17005f = periodType2;
        return periodType2;
    }

    public static PeriodType yearWeekDayTime() {
        PeriodType periodType = e;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("YearWeekDayTime", new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.weeks(), DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis()}, new int[]{0, -1, 1, 2, 3, 4, 5, 6});
        e = periodType2;
        return periodType2;
    }

    public static PeriodType years() {
        PeriodType periodType = f17010k;
        if (periodType != null) {
            return periodType;
        }
        PeriodType periodType2 = new PeriodType("Years", new DurationFieldType[]{DurationFieldType.years()}, new int[]{0, -1, -1, -1, -1, -1, -1, -1});
        f17010k = periodType2;
        return periodType2;
    }

    public final PeriodType a(int i3, String str) {
        int i10 = this.iIndices[i3];
        if (i10 == -1) {
            return this;
        }
        DurationFieldType[] durationFieldTypeArr = new DurationFieldType[size() - 1];
        int i11 = 0;
        while (true) {
            DurationFieldType[] durationFieldTypeArr2 = this.iTypes;
            if (i11 >= durationFieldTypeArr2.length) {
                break;
            }
            if (i11 < i10) {
                durationFieldTypeArr[i11] = durationFieldTypeArr2[i11];
            } else if (i11 > i10) {
                durationFieldTypeArr[i11 - 1] = durationFieldTypeArr2[i11];
            }
            i11++;
        }
        int[] iArr = new int[8];
        for (int i12 = 0; i12 < 8; i12++) {
            if (i12 < i3) {
                iArr[i12] = this.iIndices[i12];
            } else if (i12 > i3) {
                int i13 = this.iIndices[i12];
                iArr[i12] = i13 == -1 ? -1 : i13 - 1;
            } else {
                iArr[i12] = -1;
            }
        }
        return new PeriodType(getName() + str, durationFieldTypeArr, iArr);
    }

    public boolean addIndexedField(k kVar, int i3, int[] iArr, int i10) {
        if (i10 == 0) {
            return false;
        }
        int i11 = this.iIndices[i3];
        if (i11 == -1) {
            throw new UnsupportedOperationException("Field is not supported");
        }
        iArr[i11] = nf.c(iArr[i11], i10);
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PeriodType) {
            return Arrays.equals(this.iTypes, ((PeriodType) obj).iTypes);
        }
        return false;
    }

    public DurationFieldType getFieldType(int i3) {
        return this.iTypes[i3];
    }

    public int getIndexedField(k kVar, int i3) {
        int i10 = this.iIndices[i3];
        if (i10 == -1) {
            return 0;
        }
        return kVar.getValue(i10);
    }

    public String getName() {
        return this.iName;
    }

    public int hashCode() {
        int i3 = 0;
        int i10 = 0;
        while (true) {
            DurationFieldType[] durationFieldTypeArr = this.iTypes;
            if (i3 >= durationFieldTypeArr.length) {
                return i10;
            }
            i10 += durationFieldTypeArr[i3].hashCode();
            i3++;
        }
    }

    public int indexOf(DurationFieldType durationFieldType) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.iTypes[i3] == durationFieldType) {
                return i3;
            }
        }
        return -1;
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        return indexOf(durationFieldType) >= 0;
    }

    public boolean setIndexedField(k kVar, int i3, int[] iArr, int i10) {
        int i11 = this.iIndices[i3];
        if (i11 == -1) {
            throw new UnsupportedOperationException("Field is not supported");
        }
        iArr[i11] = i10;
        return true;
    }

    public int size() {
        return this.iTypes.length;
    }

    public String toString() {
        return "PeriodType[" + getName() + "]";
    }

    public PeriodType withDaysRemoved() {
        return a(3, "NoDays");
    }

    public PeriodType withHoursRemoved() {
        return a(4, "NoHours");
    }

    public PeriodType withMillisRemoved() {
        return a(7, "NoMillis");
    }

    public PeriodType withMinutesRemoved() {
        return a(5, "NoMinutes");
    }

    public PeriodType withMonthsRemoved() {
        return a(1, "NoMonths");
    }

    public PeriodType withSecondsRemoved() {
        return a(6, "NoSeconds");
    }

    public PeriodType withWeeksRemoved() {
        return a(2, "NoWeeks");
    }

    public PeriodType withYearsRemoved() {
        return a(0, "NoYears");
    }
}
