package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class u1 extends w1 {
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.w1
    public final double a(long j4, Object obj) {
        return Double.longBitsToDouble(this.f9838a.getLong(obj, j4));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.w1
    public final float b(long j4, Object obj) {
        return Float.intBitsToFloat(this.f9838a.getInt(obj, j4));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.w1
    public final void c(Object obj, long j4, boolean z5) {
        if (x1.f9846g) {
            x1.b(obj, j4, z5 ? (byte) 1 : (byte) 0);
        } else {
            x1.c(obj, j4, z5 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.w1
    public final void d(Object obj, long j4, byte b3) {
        if (x1.f9846g) {
            x1.b(obj, j4, b3);
        } else {
            x1.c(obj, j4, b3);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.w1
    public final void e(Object obj, long j4, double d5) {
        this.f9838a.putLong(obj, j4, Double.doubleToLongBits(d5));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.w1
    public final void f(Object obj, long j4, float f2) {
        this.f9838a.putInt(obj, j4, Float.floatToIntBits(f2));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.w1
    public final boolean g(long j4, Object obj) {
        return x1.f9846g ? x1.l(j4, obj) : x1.m(j4, obj);
    }
}
