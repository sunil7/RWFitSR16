package org.joda.time.chrono;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;

/* loaded from: classes2.dex */
public final class d extends org.joda.time.field.h {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f17083d;
    public final BasicChronology e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BasicChronology basicChronology, org.joda.time.e eVar, int i3) {
        super(DateTimeFieldType.dayOfMonth(), eVar);
        this.f17083d = i3;
        switch (i3) {
            case 1:
                super(DateTimeFieldType.dayOfYear(), eVar);
                this.e = basicChronology;
                break;
            case 2:
                super(DateTimeFieldType.weekOfWeekyear(), eVar);
                this.e = basicChronology;
                break;
            case 3:
                super(DateTimeFieldType.dayOfWeek(), eVar);
                this.e = basicChronology;
                break;
            default:
                this.e = basicChronology;
                break;
        }
    }

    @Override // org.joda.time.b
    public int a(long j4, int i3) {
        switch (this.f17083d) {
            case 0:
                return this.e.getDaysInMonthMaxForSet(j4, i3);
            case 1:
                int daysInYearMax = this.e.getDaysInYearMax() - 1;
                return (i3 > daysInYearMax || i3 < 1) ? getMaximumValue(j4) : daysInYearMax;
            case 2:
                if (i3 > 52) {
                    return getMaximumValue(j4);
                }
                return 52;
            default:
                return super.a(j4, i3);
        }
    }

    @Override // org.joda.time.field.b
    public int b(String str, Locale locale) {
        switch (this.f17083d) {
            case 3:
                Integer num = (Integer) j.b(locale).f17104h.get(str);
                if (num != null) {
                    return num.intValue();
                }
                throw new IllegalFieldValueException(DateTimeFieldType.dayOfWeek(), str);
            default:
                return super.b(str, locale);
        }
    }

    @Override // org.joda.time.b
    public final int get(long j4) {
        switch (this.f17083d) {
            case 0:
                return this.e.getDayOfMonth(j4);
            case 1:
                return this.e.getDayOfYear(j4);
            case 2:
                return this.e.getWeekOfWeekyear(j4);
            default:
                return this.e.getDayOfWeek(j4);
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public String getAsShortText(int i3, Locale locale) {
        switch (this.f17083d) {
            case 3:
                return j.b(locale).f17100c[i3];
            default:
                return super.getAsShortText(i3, locale);
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public String getAsText(int i3, Locale locale) {
        switch (this.f17083d) {
            case 3:
                return j.b(locale).f17099b[i3];
            default:
                return super.getAsText(i3, locale);
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumShortTextLength(Locale locale) {
        switch (this.f17083d) {
            case 3:
                return j.b(locale).f17108l;
            default:
                return super.getMaximumShortTextLength(locale);
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumTextLength(Locale locale) {
        switch (this.f17083d) {
            case 3:
                return j.b(locale).f17107k;
            default:
                return super.getMaximumTextLength(locale);
        }
    }

    @Override // org.joda.time.b
    public final int getMaximumValue() {
        switch (this.f17083d) {
            case 0:
                return this.e.getDaysInMonthMax();
            case 1:
                return this.e.getDaysInYearMax();
            case 2:
                return 53;
            default:
                return 7;
        }
    }

    @Override // org.joda.time.field.h, org.joda.time.b
    public final int getMinimumValue() {
        switch (this.f17083d) {
        }
        return 1;
    }

    @Override // org.joda.time.b
    public final org.joda.time.e getRangeDurationField() {
        switch (this.f17083d) {
            case 0:
                return this.e.months();
            case 1:
                return this.e.years();
            case 2:
                return this.e.weekyears();
            default:
                return this.e.weeks();
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public boolean isLeap(long j4) {
        switch (this.f17083d) {
            case 0:
                return this.e.isLeapDay(j4);
            case 1:
                return this.e.isLeapDay(j4);
            default:
                return super.isLeap(j4);
        }
    }

    @Override // org.joda.time.field.h, org.joda.time.field.b, org.joda.time.b
    public long remainder(long j4) {
        switch (this.f17083d) {
            case 2:
                return super.remainder(j4 + Const.MIN_TIME_AGPS_REQUEST);
            default:
                return super.remainder(j4);
        }
    }

    @Override // org.joda.time.field.h, org.joda.time.field.b, org.joda.time.b
    public long roundCeiling(long j4) {
        switch (this.f17083d) {
            case 2:
                return super.roundCeiling(j4 + Const.MIN_TIME_AGPS_REQUEST) - Const.MIN_TIME_AGPS_REQUEST;
            default:
                return super.roundCeiling(j4);
        }
    }

    @Override // org.joda.time.field.h, org.joda.time.b
    public long roundFloor(long j4) {
        switch (this.f17083d) {
            case 2:
                return super.roundFloor(j4 + Const.MIN_TIME_AGPS_REQUEST) - Const.MIN_TIME_AGPS_REQUEST;
            default:
                return super.roundFloor(j4);
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(long j4) {
        switch (this.f17083d) {
            case 0:
                return this.e.getDaysInMonthMax(j4);
            case 1:
                BasicChronology basicChronology = this.e;
                return basicChronology.getDaysInYear(basicChronology.getYear(j4));
            case 2:
                BasicChronology basicChronology2 = this.e;
                return basicChronology2.getWeeksInYear(basicChronology2.getWeekyear(j4));
            default:
                return super.getMaximumValue(j4);
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(org.joda.time.j jVar) {
        switch (this.f17083d) {
            case 0:
                boolean isSupported = jVar.isSupported(DateTimeFieldType.monthOfYear());
                BasicChronology basicChronology = this.e;
                if (isSupported) {
                    int i3 = jVar.get(DateTimeFieldType.monthOfYear());
                    if (jVar.isSupported(DateTimeFieldType.year())) {
                        return basicChronology.getDaysInYearMonth(jVar.get(DateTimeFieldType.year()), i3);
                    }
                    return basicChronology.getDaysInMonthMax(i3);
                }
                return basicChronology.getDaysInMonthMax();
            case 1:
                boolean isSupported2 = jVar.isSupported(DateTimeFieldType.year());
                BasicChronology basicChronology2 = this.e;
                if (isSupported2) {
                    return basicChronology2.getDaysInYear(jVar.get(DateTimeFieldType.year()));
                }
                return basicChronology2.getDaysInYearMax();
            case 2:
                if (!jVar.isSupported(DateTimeFieldType.weekyear())) {
                    return 53;
                }
                return this.e.getWeeksInYear(jVar.get(DateTimeFieldType.weekyear()));
            default:
                return super.getMaximumValue(jVar);
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(org.joda.time.j jVar, int[] iArr) {
        switch (this.f17083d) {
            case 0:
                int size = jVar.size();
                int i3 = 0;
                while (true) {
                    BasicChronology basicChronology = this.e;
                    if (i3 < size) {
                        if (jVar.getFieldType(i3) == DateTimeFieldType.monthOfYear()) {
                            int i10 = iArr[i3];
                            for (int i11 = 0; i11 < size; i11++) {
                                if (jVar.getFieldType(i11) == DateTimeFieldType.year()) {
                                    return basicChronology.getDaysInYearMonth(iArr[i11], i10);
                                }
                            }
                            return basicChronology.getDaysInMonthMax(i10);
                        }
                        i3++;
                    } else {
                        return basicChronology.getDaysInMonthMax();
                    }
                }
            case 1:
                int size2 = jVar.size();
                int i12 = 0;
                while (true) {
                    BasicChronology basicChronology2 = this.e;
                    if (i12 < size2) {
                        if (jVar.getFieldType(i12) == DateTimeFieldType.year()) {
                            return basicChronology2.getDaysInYear(iArr[i12]);
                        }
                        i12++;
                    } else {
                        return basicChronology2.getDaysInYearMax();
                    }
                }
            case 2:
                int size3 = jVar.size();
                for (int i13 = 0; i13 < size3; i13++) {
                    if (jVar.getFieldType(i13) == DateTimeFieldType.weekyear()) {
                        return this.e.getWeeksInYear(iArr[i13]);
                    }
                }
                return 53;
            default:
                return super.getMaximumValue(jVar, iArr);
        }
    }
}
