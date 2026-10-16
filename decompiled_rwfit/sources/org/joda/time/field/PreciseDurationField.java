package org.joda.time.field;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import org.joda.time.DurationFieldType;

/* loaded from: classes2.dex */
public class PreciseDurationField extends BaseDurationField {
    private static final long serialVersionUID = -8346152187724495365L;
    private final long iUnitMillis;

    public PreciseDurationField(DurationFieldType durationFieldType, long j4) {
        super(durationFieldType);
        this.iUnitMillis = j4;
    }

    @Override // org.joda.time.e
    public long add(long j4, int i3) {
        return nf.d(j4, i3 * this.iUnitMillis);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PreciseDurationField) {
            PreciseDurationField preciseDurationField = (PreciseDurationField) obj;
            if (getType() == preciseDurationField.getType() && this.iUnitMillis == preciseDurationField.iUnitMillis) {
                return true;
            }
        }
        return false;
    }

    @Override // org.joda.time.e
    public long getDifferenceAsLong(long j4, long j10) {
        return nf.i(j4, j10) / this.iUnitMillis;
    }

    @Override // org.joda.time.e
    public long getMillis(int i3, long j4) {
        return i3 * this.iUnitMillis;
    }

    @Override // org.joda.time.e
    public final long getUnitMillis() {
        return this.iUnitMillis;
    }

    @Override // org.joda.time.e
    public long getValueAsLong(long j4, long j10) {
        return j4 / this.iUnitMillis;
    }

    public int hashCode() {
        long j4 = this.iUnitMillis;
        return getType().hashCode() + ((int) (j4 ^ (j4 >>> 32)));
    }

    @Override // org.joda.time.e
    public final boolean isPrecise() {
        return true;
    }

    @Override // org.joda.time.e
    public long getMillis(long j4, long j10) {
        return nf.g(j4, this.iUnitMillis);
    }

    @Override // org.joda.time.e
    public long add(long j4, long j10) {
        return nf.d(j4, nf.g(j10, this.iUnitMillis));
    }
}
