package org.joda.time.field;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import org.joda.time.DateTimeFieldType;

/* loaded from: classes2.dex */
public abstract class h extends b {

    /* renamed from: b, reason: collision with root package name */
    public final long f17141b;

    /* renamed from: c, reason: collision with root package name */
    public final org.joda.time.e f17142c;

    public h(DateTimeFieldType dateTimeFieldType, org.joda.time.e eVar) {
        super(dateTimeFieldType);
        if (!eVar.isPrecise()) {
            throw new IllegalArgumentException("Unit duration field must be precise");
        }
        long unitMillis = eVar.getUnitMillis();
        this.f17141b = unitMillis;
        if (unitMillis < 1) {
            throw new IllegalArgumentException("The unit milliseconds must be at least 1");
        }
        this.f17142c = eVar;
    }

    @Override // org.joda.time.b
    public final org.joda.time.e getDurationField() {
        return this.f17142c;
    }

    @Override // org.joda.time.b
    public int getMinimumValue() {
        return 0;
    }

    @Override // org.joda.time.b
    public final boolean isLenient() {
        return false;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long remainder(long j4) {
        long j10 = this.f17141b;
        return j4 >= 0 ? j4 % j10 : (((j4 + 1) % j10) + j10) - 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundCeiling(long j4) {
        long j10 = this.f17141b;
        if (j4 <= 0) {
            return j4 - (j4 % j10);
        }
        long j11 = j4 - 1;
        return (j11 - (j11 % j10)) + j10;
    }

    @Override // org.joda.time.b
    public long roundFloor(long j4) {
        long j10 = this.f17141b;
        if (j4 >= 0) {
            return j4 - (j4 % j10);
        }
        long j11 = j4 + 1;
        return (j11 - (j11 % j10)) - j10;
    }

    @Override // org.joda.time.b
    public long set(long j4, int i3) {
        nf.k(this, i3, getMinimumValue(), a(j4, i3));
        return ((i3 - get(j4)) * this.f17141b) + j4;
    }
}
