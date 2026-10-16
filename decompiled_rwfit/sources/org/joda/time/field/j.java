package org.joda.time.field;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;

/* loaded from: classes2.dex */
public final class j extends c {
    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, int i3) {
        return this.f17131b.add(j4, i3);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long addWrapField(long j4, int i3) {
        return this.f17131b.addWrapField(j4, i3);
    }

    @Override // org.joda.time.b
    public final int get(long j4) {
        int i3 = this.f17131b.get(j4);
        return i3 == 0 ? getMaximumValue() : i3;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getDifference(long j4, long j10) {
        return this.f17131b.getDifference(j4, j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long getDifferenceAsLong(long j4, long j10) {
        return this.f17131b.getDifferenceAsLong(j4, j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getLeapAmount(long j4) {
        return this.f17131b.getLeapAmount(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final org.joda.time.e getLeapDurationField() {
        return this.f17131b.getLeapDurationField();
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final int getMaximumValue() {
        return this.f17131b.getMaximumValue() + 1;
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final int getMinimumValue() {
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final boolean isLeap(long j4) {
        return this.f17131b.isLeap(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long remainder(long j4) {
        return this.f17131b.remainder(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long roundCeiling(long j4) {
        return this.f17131b.roundCeiling(j4);
    }

    @Override // org.joda.time.b
    public final long roundFloor(long j4) {
        return this.f17131b.roundFloor(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long roundHalfCeiling(long j4) {
        return this.f17131b.roundHalfCeiling(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long roundHalfEven(long j4) {
        return this.f17131b.roundHalfEven(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long roundHalfFloor(long j4) {
        return this.f17131b.roundHalfFloor(j4);
    }

    @Override // org.joda.time.b
    public final long set(long j4, int i3) {
        int maximumValue = getMaximumValue();
        nf.k(this, i3, 1, maximumValue);
        if (i3 == maximumValue) {
            i3 = 0;
        }
        return this.f17131b.set(j4, i3);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, long j10) {
        return this.f17131b.add(j4, j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int[] addWrapField(org.joda.time.j jVar, int i3, int[] iArr, int i10) {
        return this.f17131b.addWrapField(jVar, i3, iArr, i10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumValue(long j4) {
        return this.f17131b.getMaximumValue(j4) + 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMinimumValue(long j4) {
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumValue(org.joda.time.j jVar) {
        return this.f17131b.getMaximumValue(jVar) + 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMinimumValue(org.joda.time.j jVar) {
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumValue(org.joda.time.j jVar, int[] iArr) {
        return this.f17131b.getMaximumValue(jVar, iArr) + 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMinimumValue(org.joda.time.j jVar, int[] iArr) {
        return 1;
    }
}
