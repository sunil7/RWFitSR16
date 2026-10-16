package org.joda.time.field;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import org.joda.time.DurationFieldType;

/* loaded from: classes2.dex */
public final class MillisDurationField extends org.joda.time.e implements Serializable {
    public static final org.joda.time.e INSTANCE = new MillisDurationField();
    private static final long serialVersionUID = 2656707858124633367L;

    private MillisDurationField() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.joda.time.e
    public long add(long j4, int i3) {
        return nf.d(j4, i3);
    }

    public boolean equals(Object obj) {
        return (obj instanceof MillisDurationField) && getUnitMillis() == ((MillisDurationField) obj).getUnitMillis();
    }

    @Override // org.joda.time.e
    public int getDifference(long j4, long j10) {
        return nf.j(nf.i(j4, j10));
    }

    @Override // org.joda.time.e
    public long getDifferenceAsLong(long j4, long j10) {
        return nf.i(j4, j10);
    }

    public long getMillis(int i3) {
        return i3;
    }

    @Override // org.joda.time.e
    public String getName() {
        return "millis";
    }

    @Override // org.joda.time.e
    public DurationFieldType getType() {
        return DurationFieldType.millis();
    }

    @Override // org.joda.time.e
    public final long getUnitMillis() {
        return 1L;
    }

    @Override // org.joda.time.e
    public int getValue(long j4) {
        return nf.j(j4);
    }

    @Override // org.joda.time.e
    public long getValueAsLong(long j4) {
        return j4;
    }

    public int hashCode() {
        return (int) getUnitMillis();
    }

    @Override // org.joda.time.e
    public final boolean isPrecise() {
        return true;
    }

    @Override // org.joda.time.e
    public boolean isSupported() {
        return true;
    }

    public String toString() {
        return "DurationField[millis]";
    }

    @Override // org.joda.time.e
    public long add(long j4, long j10) {
        return nf.d(j4, j10);
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
    public long getMillis(int i3, long j4) {
        return i3;
    }

    @Override // org.joda.time.e
    public int getValue(long j4, long j10) {
        return nf.j(j4);
    }

    @Override // org.joda.time.e
    public long getValueAsLong(long j4, long j10) {
        return j4;
    }

    @Override // org.joda.time.e
    public long getMillis(long j4) {
        return j4;
    }

    @Override // org.joda.time.e
    public long getMillis(long j4, long j10) {
        return j4;
    }
}
