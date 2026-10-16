package org.joda.time.field;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import org.joda.time.DateTimeFieldType;

/* loaded from: classes2.dex */
public final class f extends c {

    /* renamed from: c, reason: collision with root package name */
    public final int f17138c;

    /* renamed from: d, reason: collision with root package name */
    public final int f17139d;
    public final int e;

    public f(org.joda.time.b bVar, int i3) {
        this(bVar, bVar == null ? null : bVar.getType(), i3);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, int i3) {
        long add = super.add(j4, i3);
        nf.k(this, get(add), this.f17139d, this.e);
        return add;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long addWrapField(long j4, int i3) {
        return set(j4, nf.b(get(j4), i3, this.f17139d, this.e));
    }

    @Override // org.joda.time.b
    public final int get(long j4) {
        return this.f17131b.get(j4) + this.f17138c;
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
        return this.e;
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final int getMinimumValue() {
        return this.f17139d;
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
        nf.k(this, i3, this.f17139d, this.e);
        return this.f17131b.set(j4, i3 - this.f17138c);
    }

    public f(org.joda.time.b bVar, DateTimeFieldType dateTimeFieldType, int i3) {
        super(bVar, dateTimeFieldType);
        if (i3 == 0) {
            throw new IllegalArgumentException("The offset cannot be zero");
        }
        this.f17138c = i3;
        if (Integer.MIN_VALUE < bVar.getMinimumValue() + i3) {
            this.f17139d = bVar.getMinimumValue() + i3;
        } else {
            this.f17139d = Integer.MIN_VALUE;
        }
        if (Integer.MAX_VALUE > bVar.getMaximumValue() + i3) {
            this.e = bVar.getMaximumValue() + i3;
        } else {
            this.e = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, long j10) {
        long add = super.add(j4, j10);
        nf.k(this, get(add), this.f17139d, this.e);
        return add;
    }
}
