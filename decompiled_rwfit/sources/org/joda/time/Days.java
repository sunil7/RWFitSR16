package org.joda.time;

import com.autonavi.aps.amapapi.config.Const;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.a0;
import org.joda.time.format.w;

/* loaded from: classes2.dex */
public final class Days extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380865L;
    public static final Days ZERO = new Days(0);
    public static final Days ONE = new Days(1);
    public static final Days TWO = new Days(2);
    public static final Days THREE = new Days(3);
    public static final Days FOUR = new Days(4);
    public static final Days FIVE = new Days(5);
    public static final Days SIX = new Days(6);
    public static final Days SEVEN = new Days(7);
    public static final Days MAX_VALUE = new Days(SubsamplingScaleImageView.TILE_SIZE_AUTO);
    public static final Days MIN_VALUE = new Days(Integer.MIN_VALUE);

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f16989a = w.a().d(PeriodType.days());

    public static Days days(int i3) {
        if (i3 == Integer.MIN_VALUE) {
            return MIN_VALUE;
        }
        if (i3 == Integer.MAX_VALUE) {
            return MAX_VALUE;
        }
        switch (i3) {
            case 0:
                return ZERO;
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            case 7:
                return SEVEN;
            default:
                return new Days(i3);
        }
    }

    public static Days daysBetween(h hVar, h hVar2) {
        return days(BaseSingleFieldPeriod.between(hVar, hVar2, DurationFieldType.days()));
    }

    public static Days daysIn(i iVar) {
        return iVar == null ? ZERO : days(BaseSingleFieldPeriod.between(iVar.getStart(), iVar.getEnd(), DurationFieldType.days()));
    }

    @FromString
    public static Days parseDays(String str) {
        return str == null ? ZERO : days(f16989a.b(str).getDays());
    }

    private Object readResolve() {
        return days(getValue());
    }

    public static Days standardDaysIn(k kVar) {
        return days(BaseSingleFieldPeriod.standardPeriodIn(kVar, Const.DAY_IN_MILLIS));
    }

    public Days dividedBy(int i3) {
        return i3 == 1 ? this : days(getValue() / i3);
    }

    public int getDays() {
        return getValue();
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod
    public DurationFieldType getFieldType() {
        return DurationFieldType.days();
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod, org.joda.time.k
    public PeriodType getPeriodType() {
        return PeriodType.days();
    }

    public boolean isGreaterThan(Days days) {
        return days == null ? getValue() > 0 : getValue() > days.getValue();
    }

    public boolean isLessThan(Days days) {
        return days == null ? getValue() < 0 : getValue() < days.getValue();
    }

    public Days minus(int i3) {
        return plus(nf.h(i3));
    }

    public Days multipliedBy(int i3) {
        return days(nf.e(getValue(), i3));
    }

    public Days negated() {
        return days(nf.h(getValue()));
    }

    public Days plus(int i3) {
        return i3 == 0 ? this : days(nf.c(getValue(), i3));
    }

    public Duration toStandardDuration() {
        return new Duration(getValue() * Const.DAY_IN_MILLIS);
    }

    public Hours toStandardHours() {
        return Hours.hours(nf.e(getValue(), 24));
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(nf.e(getValue(), 1440));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(nf.e(getValue(), 86400));
    }

    public Weeks toStandardWeeks() {
        return Weeks.weeks(getValue() / 7);
    }

    @ToString
    public String toString() {
        return "P" + String.valueOf(getValue()) + "D";
    }

    public Days minus(Days days) {
        return days == null ? this : minus(days.getValue());
    }

    public Days plus(Days days) {
        return days == null ? this : plus(days.getValue());
    }

    public static Days daysBetween(j jVar, j jVar2) {
        if ((jVar instanceof LocalDate) && (jVar2 instanceof LocalDate)) {
            a chronology = jVar.getChronology();
            AtomicReference atomicReference = c.f17022a;
            if (chronology == null) {
                chronology = ISOChronology.getInstance();
            }
            return days(chronology.days().getDifference(((LocalDate) jVar2).getLocalMillis(), ((LocalDate) jVar).getLocalMillis()));
        }
        return days(BaseSingleFieldPeriod.between(jVar, jVar2, ZERO));
    }
}
