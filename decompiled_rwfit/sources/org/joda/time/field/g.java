package org.joda.time.field;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import org.joda.time.DateTimeFieldType;

/* loaded from: classes2.dex */
public class g extends h {

    /* renamed from: d, reason: collision with root package name */
    public final int f17140d;
    public final org.joda.time.e e;

    public g(DateTimeFieldType dateTimeFieldType, org.joda.time.e eVar, org.joda.time.e eVar2) {
        super(dateTimeFieldType, eVar);
        if (!eVar2.isPrecise()) {
            throw new IllegalArgumentException("Range duration field must be precise");
        }
        int unitMillis = (int) (eVar2.getUnitMillis() / this.f17141b);
        this.f17140d = unitMillis;
        if (unitMillis < 2) {
            throw new IllegalArgumentException("The effective range must be at least 2");
        }
        this.e = eVar2;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long addWrapField(long j4, int i3) {
        int i10 = get(j4);
        return ((nf.b(i10, i3, 0, this.f17140d - 1) - i10) * this.f17141b) + j4;
    }

    @Override // org.joda.time.b
    public final int get(long j4) {
        int i3 = this.f17140d;
        long j10 = this.f17141b;
        return j4 >= 0 ? (int) ((j4 / j10) % i3) : (i3 - 1) + ((int) (((j4 + 1) / j10) % i3));
    }

    @Override // org.joda.time.b
    public final int getMaximumValue() {
        return this.f17140d - 1;
    }

    @Override // org.joda.time.b
    public final org.joda.time.e getRangeDurationField() {
        return this.e;
    }

    @Override // org.joda.time.field.h, org.joda.time.b
    public final long set(long j4, int i3) {
        nf.k(this, i3, 0, this.f17140d - 1);
        return ((i3 - get(j4)) * this.f17141b) + j4;
    }
}
