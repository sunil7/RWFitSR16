package org.joda.time.field;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import org.joda.time.DateTimeFieldType;

/* loaded from: classes2.dex */
public final class i extends c {

    /* renamed from: c, reason: collision with root package name */
    public final int f17143c;

    /* renamed from: d, reason: collision with root package name */
    public final org.joda.time.e f17144d;
    public final org.joda.time.e e;

    public i(d dVar) {
        this(dVar, dVar.f17131b.getDurationField(), dVar.f17130a);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long addWrapField(long j4, int i3) {
        return set(j4, nf.b(get(j4), i3, 0, this.f17143c - 1));
    }

    @Override // org.joda.time.b
    public final int get(long j4) {
        int i3 = this.f17131b.get(j4);
        int i10 = this.f17143c;
        if (i3 >= 0) {
            return i3 % i10;
        }
        return ((i3 + 1) % i10) + (i10 - 1);
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final org.joda.time.e getDurationField() {
        return this.f17144d;
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final int getMaximumValue() {
        return this.f17143c - 1;
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final int getMinimumValue() {
        return 0;
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final org.joda.time.e getRangeDurationField() {
        return this.e;
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
        int i10 = this.f17143c;
        nf.k(this, i3, 0, i10 - 1);
        org.joda.time.b bVar = this.f17131b;
        int i11 = bVar.get(j4);
        return bVar.set(j4, ((i11 >= 0 ? i11 / i10 : ((i11 + 1) / i10) - 1) * i10) + i3);
    }

    public i(d dVar, org.joda.time.e eVar, DateTimeFieldType dateTimeFieldType) {
        super(dVar.f17131b, dateTimeFieldType);
        this.f17143c = dVar.f17132c;
        this.f17144d = eVar;
        this.e = dVar.f17133d;
    }

    public i(org.joda.time.b bVar, org.joda.time.e eVar, DateTimeFieldType dateTimeFieldType) {
        super(bVar, dateTimeFieldType);
        this.e = eVar;
        this.f17144d = bVar.getDurationField();
        this.f17143c = 100;
    }
}
