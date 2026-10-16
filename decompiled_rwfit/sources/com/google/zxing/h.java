package com.google.zxing;

import com.google.android.gms.internal.mlkit_vision_common.e0;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final float f11247a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11248b;

    public h(float f2, float f10) {
        this.f11247a = f2;
        this.f11248b = f10;
    }

    public static float a(h hVar, h hVar2) {
        return e0.a(hVar.f11247a, hVar.f11248b, hVar2.f11247a, hVar2.f11248b);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f11247a == hVar.f11247a && this.f11248b == hVar.f11248b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f11248b) + (Float.floatToIntBits(this.f11247a) * 31);
    }

    public final String toString() {
        return "(" + this.f11247a + ',' + this.f11248b + ')';
    }
}
