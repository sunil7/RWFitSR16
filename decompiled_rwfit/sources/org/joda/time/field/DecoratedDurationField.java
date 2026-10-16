package org.joda.time.field;

import org.joda.time.DurationFieldType;

/* loaded from: classes2.dex */
public class DecoratedDurationField extends BaseDurationField {
    private static final long serialVersionUID = 8019982251647420015L;
    private final org.joda.time.e iField;

    public DecoratedDurationField(org.joda.time.e eVar, DurationFieldType durationFieldType) {
        super(durationFieldType);
        if (eVar == null) {
            throw new IllegalArgumentException("The field must not be null");
        }
        if (!eVar.isSupported()) {
            throw new IllegalArgumentException("The field must be supported");
        }
        this.iField = eVar;
    }

    @Override // org.joda.time.e
    public long add(long j4, int i3) {
        return this.iField.add(j4, i3);
    }

    @Override // org.joda.time.e
    public long getDifferenceAsLong(long j4, long j10) {
        return this.iField.getDifferenceAsLong(j4, j10);
    }

    @Override // org.joda.time.e
    public long getMillis(int i3, long j4) {
        return this.iField.getMillis(i3, j4);
    }

    @Override // org.joda.time.e
    public long getUnitMillis() {
        return this.iField.getUnitMillis();
    }

    @Override // org.joda.time.e
    public long getValueAsLong(long j4, long j10) {
        return this.iField.getValueAsLong(j4, j10);
    }

    public final org.joda.time.e getWrappedField() {
        return this.iField;
    }

    @Override // org.joda.time.e
    public boolean isPrecise() {
        return this.iField.isPrecise();
    }

    @Override // org.joda.time.e
    public long add(long j4, long j10) {
        return this.iField.add(j4, j10);
    }

    @Override // org.joda.time.e
    public long getMillis(long j4, long j10) {
        return this.iField.getMillis(j4, j10);
    }
}
