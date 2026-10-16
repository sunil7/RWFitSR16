package org.joda.time.chrono;

import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes2.dex */
abstract class BasicGJChronology extends BasicChronology {

    /* renamed from: d0, reason: collision with root package name */
    public static final int[] f17050d0 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /* renamed from: e0, reason: collision with root package name */
    public static final int[] f17051e0 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /* renamed from: f0, reason: collision with root package name */
    public static final long[] f17052f0 = new long[12];

    /* renamed from: g0, reason: collision with root package name */
    public static final long[] f17053g0 = new long[12];
    private static final long serialVersionUID = 538276888268L;

    static {
        long j4 = 0;
        int i3 = 0;
        long j10 = 0;
        while (i3 < 11) {
            j4 += f17050d0[i3] * Const.DAY_IN_MILLIS;
            int i10 = i3 + 1;
            f17052f0[i10] = j4;
            j10 += f17051e0[i3] * Const.DAY_IN_MILLIS;
            f17053g0[i10] = j10;
            i3 = i10;
        }
    }

    public BasicGJChronology(org.joda.time.a aVar, Object obj, int i3) {
        super(aVar, obj, i3);
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getDaysInMonthMax(int i3) {
        return f17051e0[i3 - 1];
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getDaysInMonthMaxForSet(long j4, int i3) {
        if (i3 > 28 || i3 < 1) {
            return getDaysInMonthMax(j4);
        }
        return 28;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getDaysInYearMonth(int i3, int i10) {
        return isLeapYear(i3) ? f17051e0[i10 - 1] : f17050d0[i10 - 1];
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getMonthOfYear(long j4, int i3) {
        int yearMillis = (int) ((j4 - getYearMillis(i3)) >> 10);
        if (isLeapYear(i3)) {
            if (yearMillis < 15356250) {
                if (yearMillis < 7678125) {
                    if (yearMillis < 2615625) {
                        return 1;
                    }
                    return yearMillis < 5062500 ? 2 : 3;
                }
                if (yearMillis < 10209375) {
                    return 4;
                }
                return yearMillis < 12825000 ? 5 : 6;
            }
            if (yearMillis < 23118750) {
                if (yearMillis < 17971875) {
                    return 7;
                }
                return yearMillis < 20587500 ? 8 : 9;
            }
            if (yearMillis < 25734375) {
                return 10;
            }
            return yearMillis < 28265625 ? 11 : 12;
        }
        if (yearMillis < 15271875) {
            if (yearMillis < 7593750) {
                if (yearMillis < 2615625) {
                    return 1;
                }
                return yearMillis < 4978125 ? 2 : 3;
            }
            if (yearMillis < 10125000) {
                return 4;
            }
            return yearMillis < 12740625 ? 5 : 6;
        }
        if (yearMillis < 23034375) {
            if (yearMillis < 17887500) {
                return 7;
            }
            return yearMillis < 20503125 ? 8 : 9;
        }
        if (yearMillis < 25650000) {
            return 10;
        }
        return yearMillis < 28181250 ? 11 : 12;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getTotalMillisByYearMonth(int i3, int i10) {
        return isLeapYear(i3) ? f17053g0[i10 - 1] : f17052f0[i10 - 1];
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getYearDifference(long j4, long j10) {
        int year = getYear(j4);
        int year2 = getYear(j10);
        long yearMillis = j4 - getYearMillis(year);
        long yearMillis2 = j10 - getYearMillis(year2);
        if (yearMillis2 >= 5097600000L) {
            if (isLeapYear(year2)) {
                if (!isLeapYear(year)) {
                    yearMillis2 -= Const.DAY_IN_MILLIS;
                }
            } else if (yearMillis >= 5097600000L && isLeapYear(year)) {
                yearMillis -= Const.DAY_IN_MILLIS;
            }
        }
        int i3 = year - year2;
        if (yearMillis < yearMillis2) {
            i3--;
        }
        return i3;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public boolean isLeapDay(long j4) {
        return dayOfMonth().get(j4) == 29 && monthOfYear().isLeap(j4);
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long setYear(long j4, int i3) {
        int year = getYear(j4);
        int dayOfYear = getDayOfYear(j4, year);
        int millisOfDay = getMillisOfDay(j4);
        if (dayOfYear > 59) {
            if (isLeapYear(year)) {
                if (!isLeapYear(i3)) {
                    dayOfYear--;
                }
            } else if (isLeapYear(i3)) {
                dayOfYear++;
            }
        }
        return getYearMonthDayMillis(i3, 1, dayOfYear) + millisOfDay;
    }
}
