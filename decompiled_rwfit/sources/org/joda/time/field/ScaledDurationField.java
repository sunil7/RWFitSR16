package org.joda.time.field;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import org.joda.time.DurationFieldType;

/* loaded from: classes2.dex */
public class ScaledDurationField extends DecoratedDurationField {
    private static final long serialVersionUID = -3205227092378684157L;
    private final int iScalar;

    public ScaledDurationField(org.joda.time.e eVar, DurationFieldType durationFieldType, int i3) {
        super(eVar, durationFieldType);
        if (i3 == 0 || i3 == 1) {
            throw new IllegalArgumentException("The scalar must not be 0 or 1");
        }
        this.iScalar = i3;
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
    public long add(long j4, int i3) {
        return getWrappedField().add(j4, i3 * this.iScalar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ScaledDurationField) {
            ScaledDurationField scaledDurationField = (ScaledDurationField) obj;
            if (getWrappedField().equals(scaledDurationField.getWrappedField()) && getType() == scaledDurationField.getType() && this.iScalar == scaledDurationField.iScalar) {
                return true;
            }
        }
        return false;
    }

    @Override // org.joda.time.field.BaseDurationField, org.joda.time.e
    public int getDifference(long j4, long j10) {
        return getWrappedField().getDifference(j4, j10) / this.iScalar;
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
    public long getDifferenceAsLong(long j4, long j10) {
        return getWrappedField().getDifferenceAsLong(j4, j10) / this.iScalar;
    }

    @Override // org.joda.time.field.BaseDurationField
    public long getMillis(int i3) {
        return getWrappedField().getMillis(i3 * this.iScalar);
    }

    public int getScalar() {
        return this.iScalar;
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
    public long getUnitMillis() {
        return getWrappedField().getUnitMillis() * this.iScalar;
    }

    @Override // org.joda.time.field.BaseDurationField, org.joda.time.e
    public int getValue(long j4) {
        return getWrappedField().getValue(j4) / this.iScalar;
    }

    @Override // org.joda.time.field.BaseDurationField, org.joda.time.e
    public long getValueAsLong(long j4) {
        return getWrappedField().getValueAsLong(j4) / this.iScalar;
    }

    public int hashCode() {
        long j4 = this.iScalar;
        return getWrappedField().hashCode() + getType().hashCode() + ((int) (j4 ^ (j4 >>> 32)));
    }

    @Override // org.joda.time.field.BaseDurationField, org.joda.time.e
    public int getValue(long j4, long j10) {
        return getWrappedField().getValue(j4, j10) / this.iScalar;
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
    public long getValueAsLong(long j4, long j10) {
        return getWrappedField().getValueAsLong(j4, j10) / this.iScalar;
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
    public long add(long j4, long j10) {
        return getWrappedField().add(j4, nf.f(this.iScalar, j10));
    }

    @Override // org.joda.time.field.BaseDurationField, org.joda.time.e
    public long getMillis(long j4) {
        return getWrappedField().getMillis(nf.f(this.iScalar, j4));
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
    public long getMillis(int i3, long j4) {
        return getWrappedField().getMillis(i3 * this.iScalar, j4);
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.e
    public long getMillis(long j4, long j10) {
        return getWrappedField().getMillis(nf.f(this.iScalar, j4), j10);
    }
}
