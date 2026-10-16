package org.joda.time.field;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import org.joda.time.DurationFieldType;

/* loaded from: classes2.dex */
public abstract class BaseDurationField extends org.joda.time.e implements Serializable {
    private static final long serialVersionUID = -2554245107589433218L;
    private final DurationFieldType iType;

    public BaseDurationField(DurationFieldType durationFieldType) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("The type must not be null");
        }
        this.iType = durationFieldType;
    }

    @Override // org.joda.time.e
    public int getDifference(long j4, long j10) {
        return nf.j(getDifferenceAsLong(j4, j10));
    }

    public long getMillis(int i3) {
        return getUnitMillis() * i3;
    }

    @Override // org.joda.time.e
    public final String getName() {
        return this.iType.getName();
    }

    @Override // org.joda.time.e
    public final DurationFieldType getType() {
        return this.iType;
    }

    @Override // org.joda.time.e
    public int getValue(long j4) {
        return nf.j(getValueAsLong(j4));
    }

    @Override // org.joda.time.e
    public long getValueAsLong(long j4) {
        return j4 / getUnitMillis();
    }

    @Override // org.joda.time.e
    public final boolean isSupported() {
        return true;
    }

    public String toString() {
        return "DurationField[" + getName() + ']';
    }

    @Override // java.lang.Comparable
    public int compareTo(org.joda.time.e eVar) {
        long unitMillis = eVar.getUnitMillis();
        long unitMillis2 = getUnitMillis();
        if (unitMillis2 == unitMillis) {
            return 0;
        }
        return unitMillis2 < unitMillis ? -1 : 1;
    }

    @Override // org.joda.time.e
    public long getMillis(long j4) {
        return nf.g(j4, getUnitMillis());
    }

    @Override // org.joda.time.e
    public int getValue(long j4, long j10) {
        return nf.j(getValueAsLong(j4, j10));
    }
}
