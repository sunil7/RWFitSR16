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
public final class Seconds extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380862L;
    public static final Seconds ZERO = new Seconds(0);
    public static final Seconds ONE = new Seconds(1);
    public static final Seconds TWO = new Seconds(2);
    public static final Seconds THREE = new Seconds(3);
    public static final Seconds MAX_VALUE = new Seconds(SubsamplingScaleImageView.TILE_SIZE_AUTO);
    public static final Seconds MIN_VALUE = new Seconds(Integer.MIN_VALUE);

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f17017a = w.a().d(PeriodType.seconds());

    @FromString
    public static Seconds parseSeconds(String str) {
        return str == null ? ZERO : seconds(f17017a.b(str).getSeconds());
    }

    private Object readResolve() {
        return seconds(getValue());
    }

    public static Seconds seconds(int i3) {
        return i3 != Integer.MIN_VALUE ? i3 != Integer.MAX_VALUE ? i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? new Seconds(i3) : THREE : TWO : ONE : ZERO : MAX_VALUE : MIN_VALUE;
    }

    public static Seconds secondsBetween(h hVar, h hVar2) {
        return seconds(BaseSingleFieldPeriod.between(hVar, hVar2, DurationFieldType.seconds()));
    }

    public static Seconds secondsIn(i iVar) {
        return iVar == null ? ZERO : seconds(BaseSingleFieldPeriod.between(iVar.getStart(), iVar.getEnd(), DurationFieldType.seconds()));
    }

    public static Seconds standardSecondsIn(k kVar) {
        return seconds(BaseSingleFieldPeriod.standardPeriodIn(kVar, 1000L));
    }

    public Seconds dividedBy(int i3) {
        return i3 == 1 ? this : seconds(getValue() / i3);
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod
    public DurationFieldType getFieldType() {
        return DurationFieldType.seconds();
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod, org.joda.time.k
    public PeriodType getPeriodType() {
        return PeriodType.seconds();
    }

    public int getSeconds() {
        return getValue();
    }

    public boolean isGreaterThan(Seconds seconds) {
        return seconds == null ? getValue() > 0 : getValue() > seconds.getValue();
    }

    public boolean isLessThan(Seconds seconds) {
        return seconds == null ? getValue() < 0 : getValue() < seconds.getValue();
    }

    public Seconds minus(int i3) {
        return plus(nf.h(i3));
    }

    public Seconds multipliedBy(int i3) {
        return seconds(nf.e(getValue(), i3));
    }

    public Seconds negated() {
        return seconds(nf.h(getValue()));
    }

    public Seconds plus(int i3) {
        return i3 == 0 ? this : seconds(nf.c(getValue(), i3));
    }

    public Days toStandardDays() {
        return Days.days(getValue() / 86400);
    }

    public Duration toStandardDuration() {
        return new Duration(getValue() * 1000);
    }

    public Hours toStandardHours() {
        return Hours.hours(getValue() / 3600);
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(getValue() / 60);
    }

    public Weeks toStandardWeeks() {
        return Weeks.weeks(getValue() / 604800);
    }

    @ToString
    public String toString() {
        return "PT" + String.valueOf(getValue()) + "S";
    }

    public Seconds minus(Seconds seconds) {
        return seconds == null ? this : minus(seconds.getValue());
    }

    public Seconds plus(Seconds seconds) {
        return seconds == null ? this : plus(seconds.getValue());
    }

    public static Seconds secondsBetween(j jVar, j jVar2) {
        if ((jVar instanceof LocalTime) && (jVar2 instanceof LocalTime)) {
            a chronology = jVar.getChronology();
            AtomicReference atomicReference = c.f17022a;
            if (chronology == null) {
                chronology = ISOChronology.getInstance();
            }
            return seconds(chronology.seconds().getDifference(((LocalTime) jVar2).getLocalMillis(), ((LocalTime) jVar).getLocalMillis()));
        }
        return seconds(BaseSingleFieldPeriod.between(jVar, jVar2, ZERO));
    }
}
