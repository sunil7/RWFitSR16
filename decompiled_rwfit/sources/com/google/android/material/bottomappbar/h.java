package com.google.android.material.bottomappbar;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import eb.w;

/* loaded from: classes.dex */
public final class h extends eb.e implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public float f10262c;

    /* renamed from: d, reason: collision with root package name */
    public float f10263d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f10264f;

    /* renamed from: g, reason: collision with root package name */
    public float f10265g;

    /* renamed from: h, reason: collision with root package name */
    public float f10266h;

    @Override // eb.e
    public final void q(float f2, float f10, float f11, w wVar) {
        float f12;
        float f13;
        float f14 = this.e;
        if (f14 == 0.0f) {
            wVar.d(f2, 0.0f);
            return;
        }
        float f15 = ((this.f10263d * 2.0f) + f14) / 2.0f;
        float f16 = f11 * this.f10262c;
        float f17 = f10 + this.f10265g;
        float a3 = l0.a(1.0f, f11, f15, this.f10264f * f11);
        if (a3 / f15 >= 1.0f) {
            wVar.d(f2, 0.0f);
            return;
        }
        float f18 = this.f10266h;
        float f19 = f18 * f11;
        boolean z5 = f18 == -1.0f || Math.abs((f18 * 2.0f) - f14) < 0.1f;
        if (z5) {
            f12 = a3;
            f13 = 0.0f;
        } else {
            f13 = 1.75f;
            f12 = 0.0f;
        }
        float f20 = f15 + f16;
        float f21 = f12 + f16;
        float sqrt = (float) Math.sqrt((f20 * f20) - (f21 * f21));
        float f22 = f17 - sqrt;
        float f23 = f17 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f21));
        float f24 = (90.0f - degrees) + f13;
        wVar.d(f22, 0.0f);
        float f25 = f22 - f16;
        float f26 = f22 + f16;
        float f27 = f16 * 2.0f;
        wVar.a(f25, 0.0f, f26, f27, 270.0f, degrees);
        if (z5) {
            wVar.a(f17 - f15, (-f15) - f12, f17 + f15, f15 - f12, 180.0f - f24, (f24 * 2.0f) - 180.0f);
        } else {
            float f28 = this.f10263d;
            float f29 = f19 * 2.0f;
            float f30 = f28 + f29;
            float f31 = f17 - f15;
            wVar.a(f31, -(f19 + f28), f30 + f31, f28 + f19, 180.0f - f24, ((f24 * 2.0f) - 180.0f) / 2.0f);
            float f32 = f17 + f15;
            float f33 = this.f10263d;
            wVar.d(f32 - ((f33 / 2.0f) + f19), f33 + f19);
            float f34 = this.f10263d;
            wVar.a(f32 - (f29 + f34), -(f19 + f34), f32, f34 + f19, 90.0f, f24 - 90.0f);
        }
        wVar.a(f23 - f16, 0.0f, f23 + f16, f27, 270.0f - degrees, degrees);
        wVar.d(f2, 0.0f);
    }

    public final void u(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f10264f = f2;
    }
}
