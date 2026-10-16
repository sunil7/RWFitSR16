package org.joda.time;

import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.joda.convert.FromString;
import org.joda.time.base.BaseDuration;

/* loaded from: classes2.dex */
public final class Duration extends BaseDuration implements Serializable {
    public static final Duration ZERO = new Duration(0);
    private static final long serialVersionUID = 2471658376918L;

    public Duration(long j4) {
        super(j4);
    }

    public static Duration millis(long j4) {
        return j4 == 0 ? ZERO : new Duration(j4);
    }

    @FromString
    public static Duration parse(String str) {
        return new Duration(str);
    }

    public static Duration standardDays(long j4) {
        return j4 == 0 ? ZERO : new Duration(nf.f(86400000, j4));
    }

    public static Duration standardHours(long j4) {
        return j4 == 0 ? ZERO : new Duration(nf.f(3600000, j4));
    }

    public static Duration standardMinutes(long j4) {
        return j4 == 0 ? ZERO : new Duration(nf.f(60000, j4));
    }

    public static Duration standardSeconds(long j4) {
        return j4 == 0 ? ZERO : new Duration(nf.f(1000, j4));
    }

    public Duration abs() {
        return getMillis() < 0 ? negated() : this;
    }

    public Duration dividedBy(long j4) {
        if (j4 == 1) {
            return this;
        }
        long millis = getMillis();
        if (millis != Long.MIN_VALUE || j4 != -1) {
            return new Duration(millis / j4);
        }
        throw new ArithmeticException("Multiplication overflows a long: " + millis + " / " + j4);
    }

    public long getStandardDays() {
        return getMillis() / Const.DAY_IN_MILLIS;
    }

    public long getStandardHours() {
        return getMillis() / Const.L_WIFI_EXP;
    }

    public long getStandardMinutes() {
        return getMillis() / 60000;
    }

    public long getStandardSeconds() {
        return getMillis() / 1000;
    }

    public Duration minus(long j4) {
        return withDurationAdded(j4, -1);
    }

    public Duration multipliedBy(long j4) {
        return j4 == 1 ? this : new Duration(nf.g(getMillis(), j4));
    }

    public Duration negated() {
        if (getMillis() != Long.MIN_VALUE) {
            return new Duration(-getMillis());
        }
        throw new ArithmeticException("Negation of this duration would overflow");
    }

    public Duration plus(long j4) {
        return withDurationAdded(j4, 1);
    }

    @Override // ai.b
    public Duration toDuration() {
        return this;
    }

    public Days toStandardDays() {
        return Days.days(nf.j(getStandardDays()));
    }

    public Hours toStandardHours() {
        return Hours.hours(nf.j(getStandardHours()));
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(nf.j(getStandardMinutes()));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(nf.j(getStandardSeconds()));
    }

    public Duration withDurationAdded(long j4, int i3) {
        if (j4 == 0 || i3 == 0) {
            return this;
        }
        return new Duration(nf.d(getMillis(), nf.f(i3, j4)));
    }

    public Duration withMillis(long j4) {
        return j4 == getMillis() ? this : new Duration(j4);
    }

    public Duration(long j4, long j10) {
        super(j4, j10);
    }

    public Duration minus(g gVar) {
        return gVar == null ? this : withDurationAdded(gVar.getMillis(), -1);
    }

    public Duration plus(g gVar) {
        return gVar == null ? this : withDurationAdded(gVar.getMillis(), 1);
    }

    public Duration(h hVar, h hVar2) {
        super(hVar, hVar2);
    }

    public Duration(Object obj) {
        super(obj);
    }

    public Duration withDurationAdded(g gVar, int i3) {
        return (gVar == null || i3 == 0) ? this : withDurationAdded(gVar.getMillis(), i3);
    }

    public Duration dividedBy(long j4, RoundingMode roundingMode) {
        if (j4 == 1) {
            return this;
        }
        long millis = getMillis();
        if (millis == Long.MIN_VALUE && j4 == -1) {
            throw new ArithmeticException("Multiplication overflows a long: " + millis + " / " + j4);
        }
        return new Duration(new BigDecimal(millis).divide(new BigDecimal(j4), roundingMode).longValue());
    }
}
