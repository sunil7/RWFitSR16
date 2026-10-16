package org.joda.time.chrono;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import org.joda.time.DateTimeFieldType;

/* loaded from: classes2.dex */
public final class e extends org.joda.time.field.e {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f17084d;
    public final BasicChronology e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(BasicChronology basicChronology, int i3) {
        super(DateTimeFieldType.weekyear(), basicChronology.getAverageMillisPerYear());
        this.f17084d = i3;
        switch (i3) {
            case 1:
                super(DateTimeFieldType.year(), basicChronology.getAverageMillisPerYear());
                this.e = basicChronology;
                break;
            default:
                this.e = basicChronology;
                break;
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, int i3) {
        switch (this.f17084d) {
            case 0:
                return i3 == 0 ? j4 : set(j4, this.e.getWeekyear(j4) + i3);
            default:
                return i3 == 0 ? j4 : set(j4, nf.c(this.e.getYear(j4), i3));
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long addWrapField(long j4, int i3) {
        switch (this.f17084d) {
            case 0:
                return add(j4, i3);
            default:
                if (i3 == 0) {
                    return j4;
                }
                BasicChronology basicChronology = this.e;
                return set(j4, nf.b(basicChronology.getYear(j4), i3, basicChronology.getMinYear(), basicChronology.getMaxYear()));
        }
    }

    @Override // org.joda.time.b
    public final int get(long j4) {
        switch (this.f17084d) {
            case 0:
                return this.e.getWeekyear(j4);
            default:
                return this.e.getYear(j4);
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long getDifferenceAsLong(long j4, long j10) {
        switch (this.f17084d) {
            case 0:
                if (j4 < j10) {
                    return -getDifference(j10, j4);
                }
                BasicChronology basicChronology = this.e;
                int weekyear = basicChronology.getWeekyear(j4);
                int weekyear2 = basicChronology.getWeekyear(j10);
                long roundFloor = j4 - roundFloor(j4);
                long roundFloor2 = j10 - roundFloor(j10);
                if (roundFloor2 >= 31449600000L && basicChronology.getWeeksInYear(weekyear) <= 52) {
                    roundFloor2 -= 604800000;
                }
                int i3 = weekyear - weekyear2;
                if (roundFloor < roundFloor2) {
                    i3--;
                }
                return i3;
            default:
                BasicChronology basicChronology2 = this.e;
                return j4 < j10 ? -basicChronology2.getYearDifference(j10, j4) : basicChronology2.getYearDifference(j4, j10);
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getLeapAmount(long j4) {
        switch (this.f17084d) {
            case 0:
                BasicChronology basicChronology = this.e;
                return basicChronology.getWeeksInYear(basicChronology.getWeekyear(j4)) - 52;
            default:
                BasicChronology basicChronology2 = this.e;
                return basicChronology2.isLeapYear(basicChronology2.getYear(j4)) ? 1 : 0;
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final org.joda.time.e getLeapDurationField() {
        switch (this.f17084d) {
            case 0:
                return this.e.weeks();
            default:
                return this.e.days();
        }
    }

    @Override // org.joda.time.b
    public final int getMaximumValue() {
        switch (this.f17084d) {
        }
        return this.e.getMaxYear();
    }

    @Override // org.joda.time.b
    public final int getMinimumValue() {
        switch (this.f17084d) {
        }
        return this.e.getMinYear();
    }

    @Override // org.joda.time.b
    public final org.joda.time.e getRangeDurationField() {
        switch (this.f17084d) {
        }
        return null;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final boolean isLeap(long j4) {
        switch (this.f17084d) {
            case 0:
                BasicChronology basicChronology = this.e;
                return basicChronology.getWeeksInYear(basicChronology.getWeekyear(j4)) > 52;
            default:
                BasicChronology basicChronology2 = this.e;
                return basicChronology2.isLeapYear(basicChronology2.getYear(j4));
        }
    }

    @Override // org.joda.time.b
    public final boolean isLenient() {
        switch (this.f17084d) {
        }
        return false;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long remainder(long j4) {
        switch (this.f17084d) {
        }
        return j4 - roundFloor(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundCeiling(long j4) {
        switch (this.f17084d) {
            case 1:
                BasicChronology basicChronology = this.e;
                int year = basicChronology.getYear(j4);
                return j4 != basicChronology.getYearMillis(year) ? basicChronology.getYearMillis(year + 1) : j4;
            default:
                return super.roundCeiling(j4);
        }
    }

    @Override // org.joda.time.b
    public final long roundFloor(long j4) {
        switch (this.f17084d) {
            case 0:
                BasicChronology basicChronology = this.e;
                long roundFloor = basicChronology.weekOfWeekyear().roundFloor(j4);
                return basicChronology.getWeekOfWeekyear(roundFloor) > 1 ? roundFloor - ((r0 - 1) * 604800000) : roundFloor;
            default:
                BasicChronology basicChronology2 = this.e;
                return basicChronology2.getYearMillis(basicChronology2.getYear(j4));
        }
    }

    @Override // org.joda.time.b
    public final long set(long j4, int i3) {
        switch (this.f17084d) {
            case 0:
                int abs = Math.abs(i3);
                BasicChronology basicChronology = this.e;
                nf.k(this, abs, basicChronology.getMinYear(), basicChronology.getMaxYear());
                int weekyear = basicChronology.getWeekyear(j4);
                if (weekyear == i3) {
                    return j4;
                }
                int dayOfWeek = basicChronology.getDayOfWeek(j4);
                int weeksInYear = basicChronology.getWeeksInYear(weekyear);
                int weeksInYear2 = basicChronology.getWeeksInYear(i3);
                if (weeksInYear2 < weeksInYear) {
                    weeksInYear = weeksInYear2;
                }
                int weekOfWeekyear = basicChronology.getWeekOfWeekyear(j4);
                if (weekOfWeekyear <= weeksInYear) {
                    weeksInYear = weekOfWeekyear;
                }
                long year = basicChronology.setYear(j4, i3);
                int weekyear2 = basicChronology.getWeekyear(year);
                if (weekyear2 < i3) {
                    year += 604800000;
                } else if (weekyear2 > i3) {
                    year -= 604800000;
                }
                return basicChronology.dayOfWeek().set(((weeksInYear - basicChronology.getWeekOfWeekyear(year)) * 604800000) + year, dayOfWeek);
            default:
                BasicChronology basicChronology2 = this.e;
                nf.k(this, i3, basicChronology2.getMinYear(), basicChronology2.getMaxYear());
                return basicChronology2.setYear(j4, i3);
        }
    }

    @Override // org.joda.time.b
    public long setExtended(long j4, int i3) {
        switch (this.f17084d) {
            case 1:
                BasicChronology basicChronology = this.e;
                nf.k(this, i3, basicChronology.getMinYear() - 1, basicChronology.getMaxYear() + 1);
                return basicChronology.setYear(j4, i3);
            default:
                return super.setExtended(j4, i3);
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, long j10) {
        switch (this.f17084d) {
        }
        return add(j4, nf.j(j10));
    }
}
