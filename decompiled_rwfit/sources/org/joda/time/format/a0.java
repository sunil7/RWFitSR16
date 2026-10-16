package org.joda.time.format;

import org.joda.time.MutablePeriod;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/* loaded from: classes2.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final k0 f17149a;

    /* renamed from: b, reason: collision with root package name */
    public final j0 f17150b;

    /* renamed from: c, reason: collision with root package name */
    public final PeriodType f17151c;

    public a0(k0 k0Var, j0 j0Var) {
        this.f17149a = k0Var;
        this.f17150b = j0Var;
        this.f17151c = null;
    }

    public final MutablePeriod a(String str) {
        j0 j0Var = this.f17150b;
        if (j0Var == null) {
            throw new UnsupportedOperationException("Parsing not supported");
        }
        MutablePeriod mutablePeriod = new MutablePeriod(0L, this.f17151c);
        int c9 = j0Var.c(mutablePeriod, str, 0);
        if (c9 < 0) {
            c9 = ~c9;
        } else if (c9 >= str.length()) {
            return mutablePeriod;
        }
        throw new IllegalArgumentException(u.e(c9, str));
    }

    public final Period b(String str) {
        if (this.f17150b != null) {
            return a(str).toPeriod();
        }
        throw new UnsupportedOperationException("Parsing not supported");
    }

    public final String c(ai.f fVar) {
        k0 k0Var = this.f17149a;
        if (k0Var == null) {
            throw new UnsupportedOperationException("Printing not supported");
        }
        StringBuffer stringBuffer = new StringBuffer(k0Var.b(fVar));
        k0Var.d(stringBuffer, fVar);
        return stringBuffer.toString();
    }

    public final a0 d(PeriodType periodType) {
        if (periodType == this.f17151c) {
            return this;
        }
        return new a0(this.f17149a, this.f17150b, periodType);
    }

    public a0(k0 k0Var, j0 j0Var, PeriodType periodType) {
        this.f17149a = k0Var;
        this.f17150b = j0Var;
        this.f17151c = periodType;
    }
}
