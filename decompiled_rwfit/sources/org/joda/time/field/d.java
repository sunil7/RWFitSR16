package org.joda.time.field;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import org.joda.time.DateTimeFieldType;

/* loaded from: classes2.dex */
public final class d extends c {

    /* renamed from: c, reason: collision with root package name */
    public final int f17132c;

    /* renamed from: d, reason: collision with root package name */
    public final ScaledDurationField f17133d;
    public final org.joda.time.e e;

    /* renamed from: f, reason: collision with root package name */
    public final int f17134f;

    /* renamed from: g, reason: collision with root package name */
    public final int f17135g;

    public d(c cVar, org.joda.time.e eVar, DateTimeFieldType dateTimeFieldType) {
        super(cVar, dateTimeFieldType);
        org.joda.time.e durationField = cVar.getDurationField();
        if (durationField == null) {
            this.f17133d = null;
        } else {
            this.f17133d = new ScaledDurationField(durationField, dateTimeFieldType.getDurationType(), 100);
        }
        this.e = eVar;
        this.f17132c = 100;
        int minimumValue = cVar.getMinimumValue();
        int i3 = minimumValue >= 0 ? minimumValue / 100 : ((minimumValue + 1) / 100) - 1;
        int maximumValue = cVar.getMaximumValue();
        int i10 = maximumValue >= 0 ? maximumValue / 100 : ((maximumValue + 1) / 100) - 1;
        this.f17134f = i3;
        this.f17135g = i10;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, int i3) {
        return this.f17131b.add(j4, i3 * this.f17132c);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long addWrapField(long j4, int i3) {
        return set(j4, nf.b(get(j4), i3, this.f17134f, this.f17135g));
    }

    @Override // org.joda.time.b
    public final int get(long j4) {
        int i3 = this.f17131b.get(j4);
        return i3 >= 0 ? i3 / this.f17132c : ((i3 + 1) / r3) - 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getDifference(long j4, long j10) {
        return this.f17131b.getDifference(j4, j10) / this.f17132c;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long getDifferenceAsLong(long j4, long j10) {
        return this.f17131b.getDifferenceAsLong(j4, j10) / this.f17132c;
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final org.joda.time.e getDurationField() {
        return this.f17133d;
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final int getMaximumValue() {
        return this.f17135g;
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final int getMinimumValue() {
        return this.f17134f;
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final org.joda.time.e getRangeDurationField() {
        org.joda.time.e eVar = this.e;
        return eVar != null ? eVar : super.getRangeDurationField();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long remainder(long j4) {
        return set(j4, get(this.f17131b.remainder(j4)));
    }

    @Override // org.joda.time.b
    public final long roundFloor(long j4) {
        int i3 = get(j4) * this.f17132c;
        org.joda.time.b bVar = this.f17131b;
        return bVar.roundFloor(bVar.set(j4, i3));
    }

    @Override // org.joda.time.b
    public final long set(long j4, int i3) {
        int i10;
        nf.k(this, i3, this.f17134f, this.f17135g);
        org.joda.time.b bVar = this.f17131b;
        int i11 = bVar.get(j4);
        int i12 = this.f17132c;
        if (i11 >= 0) {
            i10 = i11 % i12;
        } else {
            i10 = ((i11 + 1) % i12) + (i12 - 1);
        }
        return bVar.set(j4, (i3 * i12) + i10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, long j10) {
        return this.f17131b.add(j4, j10 * this.f17132c);
    }
}
