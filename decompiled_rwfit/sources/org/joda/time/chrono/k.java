package org.joda.time.chrono;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;

/* loaded from: classes2.dex */
public final class k extends org.joda.time.field.e {

    /* renamed from: d, reason: collision with root package name */
    public final BasicChronology f17112d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f17113f;

    public k(BasicChronology basicChronology) {
        super(DateTimeFieldType.monthOfYear(), basicChronology.getAverageMillisPerMonth());
        this.f17112d = basicChronology;
        this.e = basicChronology.getMaxMonth();
        this.f17113f = 2;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, int i3) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if (i3 == 0) {
            return j4;
        }
        BasicChronology basicChronology = this.f17112d;
        long millisOfDay = basicChronology.getMillisOfDay(j4);
        int year = basicChronology.getYear(j4);
        int monthOfYear = basicChronology.getMonthOfYear(j4, year);
        int i15 = monthOfYear - 1;
        int i16 = i15 + i3;
        int i17 = this.e;
        if (monthOfYear <= 0 || i16 >= 0) {
            i10 = year;
        } else {
            if (Math.signum(i3 + i17) == Math.signum(i3)) {
                i13 = year - 1;
                i14 = i3 + i17;
            } else {
                i13 = year + 1;
                i14 = i3 - i17;
            }
            int i18 = i13;
            i16 = i14 + i15;
            i10 = i18;
        }
        if (i16 >= 0) {
            i11 = (i16 / i17) + i10;
            i12 = (i16 % i17) + 1;
        } else {
            i11 = (i16 / i17) + i10;
            int i19 = i11 - 1;
            int abs = Math.abs(i16) % i17;
            if (abs == 0) {
                abs = i17;
            }
            i12 = (i17 - abs) + 1;
            if (i12 != 1) {
                i11 = i19;
            }
        }
        int dayOfMonth = basicChronology.getDayOfMonth(j4, year, monthOfYear);
        int daysInYearMonth = basicChronology.getDaysInYearMonth(i11, i12);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return basicChronology.getYearMonthDayMillis(i11, i12, dayOfMonth) + millisOfDay;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long addWrapField(long j4, int i3) {
        return set(j4, nf.b(this.f17112d.getMonthOfYear(j4), i3, 1, this.e));
    }

    @Override // org.joda.time.field.b
    public final int b(String str, Locale locale) {
        Integer num = (Integer) j.b(locale).f17105i.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(DateTimeFieldType.monthOfYear(), str);
    }

    @Override // org.joda.time.b
    public final int get(long j4) {
        return this.f17112d.getMonthOfYear(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final String getAsShortText(int i3, Locale locale) {
        return j.b(locale).e[i3];
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final String getAsText(int i3, Locale locale) {
        return j.b(locale).f17101d[i3];
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long getDifferenceAsLong(long j4, long j10) {
        if (j4 < j10) {
            return -getDifference(j10, j4);
        }
        BasicChronology basicChronology = this.f17112d;
        int year = basicChronology.getYear(j4);
        int monthOfYear = basicChronology.getMonthOfYear(j4, year);
        int year2 = basicChronology.getYear(j10);
        int monthOfYear2 = basicChronology.getMonthOfYear(j10, year2);
        long j11 = (((year - year2) * this.e) + monthOfYear) - monthOfYear2;
        int dayOfMonth = basicChronology.getDayOfMonth(j4, year, monthOfYear);
        if (dayOfMonth == basicChronology.getDaysInYearMonth(year, monthOfYear) && basicChronology.getDayOfMonth(j10, year2, monthOfYear2) > dayOfMonth) {
            j10 = basicChronology.dayOfMonth().set(j10, dayOfMonth);
        }
        return j4 - basicChronology.getYearMonthMillis(year, monthOfYear) < j10 - basicChronology.getYearMonthMillis(year2, monthOfYear2) ? j11 - 1 : j11;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getLeapAmount(long j4) {
        return isLeap(j4) ? 1 : 0;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final org.joda.time.e getLeapDurationField() {
        return this.f17112d.days();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumShortTextLength(Locale locale) {
        return j.b(locale).f17110n;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumTextLength(Locale locale) {
        return j.b(locale).f17109m;
    }

    @Override // org.joda.time.b
    public final int getMaximumValue() {
        return this.e;
    }

    @Override // org.joda.time.b
    public final int getMinimumValue() {
        return 1;
    }

    @Override // org.joda.time.b
    public final org.joda.time.e getRangeDurationField() {
        return this.f17112d.years();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final boolean isLeap(long j4) {
        BasicChronology basicChronology = this.f17112d;
        int year = basicChronology.getYear(j4);
        return basicChronology.isLeapYear(year) && basicChronology.getMonthOfYear(j4, year) == this.f17113f;
    }

    @Override // org.joda.time.b
    public final boolean isLenient() {
        return false;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long remainder(long j4) {
        return j4 - roundFloor(j4);
    }

    @Override // org.joda.time.b
    public final long roundFloor(long j4) {
        BasicChronology basicChronology = this.f17112d;
        int year = basicChronology.getYear(j4);
        return basicChronology.getYearMonthMillis(year, basicChronology.getMonthOfYear(j4, year));
    }

    @Override // org.joda.time.b
    public final long set(long j4, int i3) {
        nf.k(this, i3, 1, this.e);
        BasicChronology basicChronology = this.f17112d;
        int year = basicChronology.getYear(j4);
        int dayOfMonth = basicChronology.getDayOfMonth(j4, year);
        int daysInYearMonth = basicChronology.getDaysInYearMonth(year, i3);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return basicChronology.getYearMonthDayMillis(year, i3, dayOfMonth) + basicChronology.getMillisOfDay(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, long j10) {
        long j11;
        long j12;
        long j13;
        int i3 = (int) j10;
        if (i3 == j10) {
            return add(j4, i3);
        }
        BasicChronology basicChronology = this.f17112d;
        long millisOfDay = basicChronology.getMillisOfDay(j4);
        int year = basicChronology.getYear(j4);
        int monthOfYear = basicChronology.getMonthOfYear(j4, year);
        long j14 = (monthOfYear - 1) + j10;
        int i10 = this.e;
        if (j14 >= 0) {
            j11 = millisOfDay;
            j13 = (j14 / i10) + year;
            j12 = (j14 % i10) + 1;
        } else {
            j11 = millisOfDay;
            long j15 = year + (j14 / i10);
            long j16 = j15 - 1;
            int abs = (int) (Math.abs(j14) % i10);
            if (abs == 0) {
                abs = i10;
            }
            j12 = (i10 - abs) + 1;
            j13 = j12 == 1 ? j15 : j16;
        }
        if (j13 >= basicChronology.getMinYear() && j13 <= basicChronology.getMaxYear()) {
            int i11 = (int) j13;
            int i12 = (int) j12;
            int dayOfMonth = basicChronology.getDayOfMonth(j4, year, monthOfYear);
            int daysInYearMonth = basicChronology.getDaysInYearMonth(i11, i12);
            if (dayOfMonth > daysInYearMonth) {
                dayOfMonth = daysInYearMonth;
            }
            return basicChronology.getYearMonthDayMillis(i11, i12, dayOfMonth) + j11;
        }
        throw new IllegalArgumentException(l0.l(j10, "Magnitude of add amount is too large: "));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int[] add(org.joda.time.j jVar, int i3, int[] iArr, int i10) {
        if (i10 == 0) {
            return iArr;
        }
        int i11 = 0;
        if (jVar.size() > 0 && jVar.getFieldType(0).equals(DateTimeFieldType.monthOfYear()) && i3 == 0) {
            set(jVar, 0, iArr, ((((i10 % 12) + (iArr[0] - 1)) + 12) % 12) + 1);
            return iArr;
        }
        if (org.joda.time.c.e(jVar)) {
            int size = jVar.size();
            long j4 = 0;
            while (true) {
                BasicChronology basicChronology = this.f17112d;
                if (i11 < size) {
                    j4 = jVar.getFieldType(i11).getField(basicChronology).set(j4, iArr[i11]);
                    i11++;
                } else {
                    return basicChronology.get(jVar, add(j4, i10));
                }
            }
        } else {
            return super.add(jVar, i3, iArr, i10);
        }
    }
}
