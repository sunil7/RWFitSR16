package org.joda.time;

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
public final class Minutes extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380863L;
    public static final Minutes ZERO = new Minutes(0);
    public static final Minutes ONE = new Minutes(1);
    public static final Minutes TWO = new Minutes(2);
    public static final Minutes THREE = new Minutes(3);
    public static final Minutes MAX_VALUE = new Minutes(SubsamplingScaleImageView.TILE_SIZE_AUTO);
    public static final Minutes MIN_VALUE = new Minutes(Integer.MIN_VALUE);

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f17000a = w.a().d(PeriodType.minutes());

    public static Minutes minutes(int i3) {
        return i3 != Integer.MIN_VALUE ? i3 != Integer.MAX_VALUE ? i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? new Minutes(i3) : THREE : TWO : ONE : ZERO : MAX_VALUE : MIN_VALUE;
    }

    public static Minutes minutesBetween(h hVar, h hVar2) {
        return minutes(BaseSingleFieldPeriod.between(hVar, hVar2, DurationFieldType.minutes()));
    }

    public static Minutes minutesIn(i iVar) {
        return iVar == null ? ZERO : minutes(BaseSingleFieldPeriod.between(iVar.getStart(), iVar.getEnd(), DurationFieldType.minutes()));
    }

    @FromString
    public static Minutes parseMinutes(String str) {
        return str == null ? ZERO : minutes(f17000a.b(str).getMinutes());
    }

    private Object readResolve() {
        return minutes(getValue());
    }

    public static Minutes standardMinutesIn(k kVar) {
        return minutes(BaseSingleFieldPeriod.standardPeriodIn(kVar, 60000L));
    }

    public Minutes dividedBy(int i3) {
        return i3 == 1 ? this : minutes(getValue() / i3);
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod
    public DurationFieldType getFieldType() {
        return DurationFieldType.minutes();
    }

    public int getMinutes() {
        return getValue();
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod, org.joda.time.k
    public PeriodType getPeriodType() {
        return PeriodType.minutes();
    }

    public boolean isGreaterThan(Minutes minutes) {
        return minutes == null ? getValue() > 0 : getValue() > minutes.getValue();
    }

    public boolean isLessThan(Minutes minutes) {
        return minutes == null ? getValue() < 0 : getValue() < minutes.getValue();
    }

    public Minutes minus(int i3) {
        return plus(nf.h(i3));
    }

    public Minutes multipliedBy(int i3) {
        return minutes(nf.e(getValue(), i3));
    }

    public Minutes negated() {
        return minutes(nf.h(getValue()));
    }

    public Minutes plus(int i3) {
        return i3 == 0 ? this : minutes(nf.c(getValue(), i3));
    }

    public Days toStandardDays() {
        return Days.days(getValue() / 1440);
    }

    public Duration toStandardDuration() {
        return new Duration(getValue() * 60000);
    }

    public Hours toStandardHours() {
        return Hours.hours(getValue() / 60);
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(nf.e(getValue(), 60));
    }

    public Weeks toStandardWeeks() {
        return Weeks.weeks(getValue() / 10080);
    }

    @ToString
    public String toString() {
        return "PT" + String.valueOf(getValue()) + "M";
    }

    public Minutes minus(Minutes minutes) {
        return minutes == null ? this : minus(minutes.getValue());
    }

    public Minutes plus(Minutes minutes) {
        return minutes == null ? this : plus(minutes.getValue());
    }

    public static Minutes minutesBetween(j jVar, j jVar2) {
        if ((jVar instanceof LocalTime) && (jVar2 instanceof LocalTime)) {
            a chronology = jVar.getChronology();
            AtomicReference atomicReference = c.f17022a;
            if (chronology == null) {
                chronology = ISOChronology.getInstance();
            }
            return minutes(chronology.minutes().getDifference(((LocalTime) jVar2).getLocalMillis(), ((LocalTime) jVar).getLocalMillis()));
        }
        return minutes(BaseSingleFieldPeriod.between(jVar, jVar2, ZERO));
    }
}
