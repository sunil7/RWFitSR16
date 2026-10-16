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
public final class Weeks extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380866L;
    public static final Weeks ZERO = new Weeks(0);
    public static final Weeks ONE = new Weeks(1);
    public static final Weeks TWO = new Weeks(2);
    public static final Weeks THREE = new Weeks(3);
    public static final Weeks MAX_VALUE = new Weeks(SubsamplingScaleImageView.TILE_SIZE_AUTO);
    public static final Weeks MIN_VALUE = new Weeks(Integer.MIN_VALUE);

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f17019a = w.a().d(PeriodType.weeks());

    @FromString
    public static Weeks parseWeeks(String str) {
        return str == null ? ZERO : weeks(f17019a.b(str).getWeeks());
    }

    private Object readResolve() {
        return weeks(getValue());
    }

    public static Weeks standardWeeksIn(k kVar) {
        return weeks(BaseSingleFieldPeriod.standardPeriodIn(kVar, 604800000L));
    }

    public static Weeks weeks(int i3) {
        return i3 != Integer.MIN_VALUE ? i3 != Integer.MAX_VALUE ? i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? new Weeks(i3) : THREE : TWO : ONE : ZERO : MAX_VALUE : MIN_VALUE;
    }

    public static Weeks weeksBetween(h hVar, h hVar2) {
        return weeks(BaseSingleFieldPeriod.between(hVar, hVar2, DurationFieldType.weeks()));
    }

    public static Weeks weeksIn(i iVar) {
        return iVar == null ? ZERO : weeks(BaseSingleFieldPeriod.between(iVar.getStart(), iVar.getEnd(), DurationFieldType.weeks()));
    }

    public Weeks dividedBy(int i3) {
        return i3 == 1 ? this : weeks(getValue() / i3);
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod
    public DurationFieldType getFieldType() {
        return DurationFieldType.weeks();
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod, org.joda.time.k
    public PeriodType getPeriodType() {
        return PeriodType.weeks();
    }

    public int getWeeks() {
        return getValue();
    }

    public boolean isGreaterThan(Weeks weeks) {
        return weeks == null ? getValue() > 0 : getValue() > weeks.getValue();
    }

    public boolean isLessThan(Weeks weeks) {
        return weeks == null ? getValue() < 0 : getValue() < weeks.getValue();
    }

    public Weeks minus(int i3) {
        return plus(nf.h(i3));
    }

    public Weeks multipliedBy(int i3) {
        return weeks(nf.e(getValue(), i3));
    }

    public Weeks negated() {
        return weeks(nf.h(getValue()));
    }

    public Weeks plus(int i3) {
        return i3 == 0 ? this : weeks(nf.c(getValue(), i3));
    }

    public Days toStandardDays() {
        return Days.days(nf.e(getValue(), 7));
    }

    public Duration toStandardDuration() {
        return new Duration(getValue() * 604800000);
    }

    public Hours toStandardHours() {
        return Hours.hours(nf.e(getValue(), 168));
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(nf.e(getValue(), 10080));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(nf.e(getValue(), 604800));
    }

    @ToString
    public String toString() {
        return "P" + String.valueOf(getValue()) + "W";
    }

    public Weeks minus(Weeks weeks) {
        return weeks == null ? this : minus(weeks.getValue());
    }

    public Weeks plus(Weeks weeks) {
        return weeks == null ? this : plus(weeks.getValue());
    }

    public static Weeks weeksBetween(j jVar, j jVar2) {
        if ((jVar instanceof LocalDate) && (jVar2 instanceof LocalDate)) {
            a chronology = jVar.getChronology();
            AtomicReference atomicReference = c.f17022a;
            if (chronology == null) {
                chronology = ISOChronology.getInstance();
            }
            return weeks(chronology.weeks().getDifference(((LocalDate) jVar2).getLocalMillis(), ((LocalDate) jVar).getLocalMillis()));
        }
        return weeks(BaseSingleFieldPeriod.between(jVar, jVar2, ZERO));
    }
}
