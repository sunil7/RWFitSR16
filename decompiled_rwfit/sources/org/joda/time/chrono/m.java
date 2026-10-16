package org.joda.time.chrono;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import org.joda.time.DateTimeFieldType;

/* loaded from: classes2.dex */
public final class m extends org.joda.time.field.c {

    /* renamed from: c, reason: collision with root package name */
    public static final m f17115c = new m(GregorianChronology.getInstanceUTC().year(), DateTimeFieldType.yearOfEra());

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
        return i3 < 0 ? -i3 : i3;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getDifference(long j4, long j10) {
        return this.f17131b.getDifference(j4, j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long getDifferenceAsLong(long j4, long j10) {
        return this.f17131b.getDifferenceAsLong(j4, j10);
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final int getMaximumValue() {
        return this.f17131b.getMaximumValue();
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final int getMinimumValue() {
        return 0;
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final org.joda.time.e getRangeDurationField() {
        return GregorianChronology.getInstanceUTC().eras();
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

    @Override // org.joda.time.b
    public final long set(long j4, int i3) {
        org.joda.time.b bVar = this.f17131b;
        nf.k(this, i3, 0, bVar.getMaximumValue());
        if (bVar.get(j4) < 0) {
            i3 = -i3;
        }
        return bVar.set(j4, i3);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, long j10) {
        return this.f17131b.add(j4, j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int[] addWrapField(org.joda.time.j jVar, int i3, int[] iArr, int i10) {
        return this.f17131b.addWrapField(jVar, i3, iArr, i10);
    }
}
