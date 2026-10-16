package org.joda.time.base;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import org.joda.time.DurationFieldType;
import org.joda.time.MutablePeriod;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.a;
import org.joda.time.c;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.e;
import org.joda.time.h;
import org.joda.time.j;
import org.joda.time.k;

/* loaded from: classes2.dex */
public abstract class BaseSingleFieldPeriod implements k, Comparable<BaseSingleFieldPeriod>, Serializable {
    private static final long serialVersionUID = 9386874258972L;
    private volatile int iPeriod;

    public BaseSingleFieldPeriod(int i3) {
        this.iPeriod = i3;
    }

    public static int between(h hVar, h hVar2, DurationFieldType durationFieldType) {
        if (hVar == null || hVar2 == null) {
            throw new IllegalArgumentException("ReadableInstant objects must not be null");
        }
        return durationFieldType.getField(c.c(hVar)).getDifference(hVar2.getMillis(), hVar.getMillis());
    }

    public static int standardPeriodIn(k kVar, long j4) {
        if (kVar == null) {
            return 0;
        }
        ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
        long j10 = 0;
        for (int i3 = 0; i3 < kVar.size(); i3++) {
            int value = kVar.getValue(i3);
            if (value != 0) {
                e field = kVar.getFieldType(i3).getField(instanceUTC);
                if (!field.isPrecise()) {
                    throw new IllegalArgumentException("Cannot convert period to duration as " + field.getName() + " is not precise in the period " + kVar);
                }
                j10 = nf.d(j10, nf.f(value, field.getUnitMillis()));
            }
        }
        return nf.j(j10 / j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kVar.getPeriodType() == getPeriodType() && kVar.getValue(0) == getValue();
    }

    @Override // org.joda.time.k
    public int get(DurationFieldType durationFieldType) {
        if (durationFieldType == getFieldType()) {
            return getValue();
        }
        return 0;
    }

    public abstract DurationFieldType getFieldType();

    @Override // org.joda.time.k
    public DurationFieldType getFieldType(int i3) {
        if (i3 == 0) {
            return getFieldType();
        }
        throw new IndexOutOfBoundsException(String.valueOf(i3));
    }

    @Override // org.joda.time.k
    public abstract PeriodType getPeriodType();

    public int getValue() {
        return this.iPeriod;
    }

    public int hashCode() {
        return getFieldType().hashCode() + ((getValue() + 459) * 27);
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        return durationFieldType == getFieldType();
    }

    public void setValue(int i3) {
        this.iPeriod = i3;
    }

    @Override // org.joda.time.k
    public int size() {
        return 1;
    }

    public MutablePeriod toMutablePeriod() {
        MutablePeriod mutablePeriod = new MutablePeriod();
        mutablePeriod.add(this);
        return mutablePeriod;
    }

    public Period toPeriod() {
        return Period.ZERO.withFields(this);
    }

    @Override // java.lang.Comparable
    public int compareTo(BaseSingleFieldPeriod baseSingleFieldPeriod) {
        if (baseSingleFieldPeriod.getClass() == getClass()) {
            int value = baseSingleFieldPeriod.getValue();
            int value2 = getValue();
            if (value2 > value) {
                return 1;
            }
            return value2 < value ? -1 : 0;
        }
        throw new ClassCastException(getClass() + " cannot be compared to " + baseSingleFieldPeriod.getClass());
    }

    @Override // org.joda.time.k
    public int getValue(int i3) {
        if (i3 == 0) {
            return getValue();
        }
        throw new IndexOutOfBoundsException(String.valueOf(i3));
    }

    public static int between(j jVar, j jVar2, k kVar) {
        if (jVar != null && jVar2 != null) {
            if (jVar.size() == jVar2.size()) {
                int size = jVar.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (jVar.getFieldType(i3) != jVar2.getFieldType(i3)) {
                        throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
                    }
                }
                if (c.e(jVar)) {
                    a chronology = jVar.getChronology();
                    if (chronology == null) {
                        chronology = ISOChronology.getInstance();
                    }
                    a withUTC = chronology.withUTC();
                    return withUTC.get(kVar, withUTC.set(jVar, 63072000000L), withUTC.set(jVar2, 63072000000L))[0];
                }
                throw new IllegalArgumentException("ReadablePartial objects must be contiguous");
            }
            throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
        }
        throw new IllegalArgumentException("ReadablePartial objects must not be null");
    }
}
