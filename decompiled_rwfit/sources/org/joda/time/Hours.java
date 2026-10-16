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
public final class Hours extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380864L;
    public static final Hours ZERO = new Hours(0);
    public static final Hours ONE = new Hours(1);
    public static final Hours TWO = new Hours(2);
    public static final Hours THREE = new Hours(3);
    public static final Hours FOUR = new Hours(4);
    public static final Hours FIVE = new Hours(5);
    public static final Hours SIX = new Hours(6);
    public static final Hours SEVEN = new Hours(7);
    public static final Hours EIGHT = new Hours(8);
    public static final Hours MAX_VALUE = new Hours(SubsamplingScaleImageView.TILE_SIZE_AUTO);
    public static final Hours MIN_VALUE = new Hours(Integer.MIN_VALUE);

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f16990a = w.a().d(PeriodType.hours());

    public static Hours hours(int i3) {
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
            case 8:
                return EIGHT;
            default:
                return new Hours(i3);
        }
    }

    public static Hours hoursBetween(h hVar, h hVar2) {
        return hours(BaseSingleFieldPeriod.between(hVar, hVar2, DurationFieldType.hours()));
    }

    public static Hours hoursIn(i iVar) {
        return iVar == null ? ZERO : hours(BaseSingleFieldPeriod.between(iVar.getStart(), iVar.getEnd(), DurationFieldType.hours()));
    }

    @FromString
    public static Hours parseHours(String str) {
        return str == null ? ZERO : hours(f16990a.b(str).getHours());
    }

    private Object readResolve() {
        return hours(getValue());
    }

    public static Hours standardHoursIn(k kVar) {
        return hours(BaseSingleFieldPeriod.standardPeriodIn(kVar, Const.L_WIFI_EXP));
    }

    public Hours dividedBy(int i3) {
        return i3 == 1 ? this : hours(getValue() / i3);
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod
    public DurationFieldType getFieldType() {
        return DurationFieldType.hours();
    }

    public int getHours() {
        return getValue();
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod, org.joda.time.k
    public PeriodType getPeriodType() {
        return PeriodType.hours();
    }

    public boolean isGreaterThan(Hours hours) {
        return hours == null ? getValue() > 0 : getValue() > hours.getValue();
    }

    public boolean isLessThan(Hours hours) {
        return hours == null ? getValue() < 0 : getValue() < hours.getValue();
    }

    public Hours minus(int i3) {
        return plus(nf.h(i3));
    }

    public Hours multipliedBy(int i3) {
        return hours(nf.e(getValue(), i3));
    }

    public Hours negated() {
        return hours(nf.h(getValue()));
    }

    public Hours plus(int i3) {
        return i3 == 0 ? this : hours(nf.c(getValue(), i3));
    }

    public Days toStandardDays() {
        return Days.days(getValue() / 24);
    }

    public Duration toStandardDuration() {
        return new Duration(getValue() * Const.L_WIFI_EXP);
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(nf.e(getValue(), 60));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(nf.e(getValue(), 3600));
    }

    public Weeks toStandardWeeks() {
        return Weeks.weeks(getValue() / 168);
    }

    @ToString
    public String toString() {
        return "PT" + String.valueOf(getValue()) + "H";
    }

    public Hours minus(Hours hours) {
        return hours == null ? this : minus(hours.getValue());
    }

    public Hours plus(Hours hours) {
        return hours == null ? this : plus(hours.getValue());
    }

    public static Hours hoursBetween(j jVar, j jVar2) {
        if ((jVar instanceof LocalTime) && (jVar2 instanceof LocalTime)) {
            a chronology = jVar.getChronology();
            AtomicReference atomicReference = c.f17022a;
            if (chronology == null) {
                chronology = ISOChronology.getInstance();
            }
            return hours(chronology.hours().getDifference(((LocalTime) jVar2).getLocalMillis(), ((LocalTime) jVar).getLocalMillis()));
        }
        return hours(BaseSingleFieldPeriod.between(jVar, jVar2, ZERO));
    }
}
