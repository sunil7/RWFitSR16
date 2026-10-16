package org.joda.time.base;

import ai.b;
import androidx.camera.core.impl.e;
import bi.d;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.a;
import org.joda.time.c;
import org.joda.time.h;

/* loaded from: classes2.dex */
public abstract class BaseDuration extends b implements Serializable {
    private static final long serialVersionUID = 2581698638990L;
    private volatile long iMillis;

    public BaseDuration(long j4) {
        this.iMillis = j4;
    }

    @Override // org.joda.time.g
    public long getMillis() {
        return this.iMillis;
    }

    public void setMillis(long j4) {
        this.iMillis = j4;
    }

    public Interval toIntervalFrom(h hVar) {
        return new Interval(hVar, this);
    }

    public Interval toIntervalTo(h hVar) {
        return new Interval(this, hVar);
    }

    public Period toPeriod(PeriodType periodType) {
        return new Period(getMillis(), periodType);
    }

    public Period toPeriodFrom(h hVar) {
        return new Period(hVar, this);
    }

    public Period toPeriodTo(h hVar) {
        return new Period(this, hVar);
    }

    public Period toPeriod(a aVar) {
        return new Period(getMillis(), aVar);
    }

    public Period toPeriodFrom(h hVar, PeriodType periodType) {
        return new Period(hVar, this, periodType);
    }

    public Period toPeriodTo(h hVar, PeriodType periodType) {
        return new Period(this, hVar, periodType);
    }

    public BaseDuration(long j4, long j10) {
        this.iMillis = nf.i(j10, j4);
    }

    public Period toPeriod(PeriodType periodType, a aVar) {
        return new Period(getMillis(), periodType, aVar);
    }

    public BaseDuration(Object obj) {
        Class<?> cls;
        e e = e.e();
        if (obj == null) {
            cls = null;
        } else {
            e.getClass();
            cls = obj.getClass();
        }
        bi.e eVar = (bi.e) ((d) e.e).b(cls);
        if (eVar != null) {
            this.iMillis = eVar.i(obj);
            return;
        }
        throw new IllegalArgumentException("No duration converter found for type: ".concat(obj == null ? "null" : obj.getClass().getName()));
    }

    public BaseDuration(h hVar, h hVar2) {
        if (hVar == hVar2) {
            this.iMillis = 0L;
        } else {
            this.iMillis = nf.i(c.d(hVar2), c.d(hVar));
        }
    }
}
