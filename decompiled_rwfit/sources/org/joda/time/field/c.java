package org.joda.time.field;

import org.joda.time.DateTimeFieldType;

/* loaded from: classes2.dex */
public abstract class c extends b {

    /* renamed from: b, reason: collision with root package name */
    public final org.joda.time.b f17131b;

    public c(org.joda.time.b bVar, DateTimeFieldType dateTimeFieldType) {
        super(dateTimeFieldType);
        if (bVar == null) {
            throw new IllegalArgumentException("The field must not be null");
        }
        if (!bVar.isSupported()) {
            throw new IllegalArgumentException("The field must be supported");
        }
        this.f17131b = bVar;
    }

    @Override // org.joda.time.b
    public org.joda.time.e getDurationField() {
        return this.f17131b.getDurationField();
    }

    @Override // org.joda.time.b
    public int getMaximumValue() {
        return this.f17131b.getMaximumValue();
    }

    @Override // org.joda.time.b
    public int getMinimumValue() {
        return this.f17131b.getMinimumValue();
    }

    @Override // org.joda.time.b
    public org.joda.time.e getRangeDurationField() {
        return this.f17131b.getRangeDurationField();
    }

    @Override // org.joda.time.b
    public final boolean isLenient() {
        return this.f17131b.isLenient();
    }
}
