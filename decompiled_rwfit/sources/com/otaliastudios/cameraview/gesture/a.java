package com.otaliastudios.cameraview.gesture;

import android.graphics.PointF;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11595a;

    /* renamed from: b, reason: collision with root package name */
    public Gesture f11596b;

    /* renamed from: c, reason: collision with root package name */
    public final PointF[] f11597c;

    public a(int i3) {
        this.f11597c = new PointF[i3];
        for (int i10 = 0; i10 < i3; i10++) {
            this.f11597c[i10] = new PointF(0.0f, 0.0f);
        }
    }

    public final float a(float f2, float f10, float f11) {
        float b3 = b(f2, f10, f11);
        if (b3 < f10) {
            b3 = f10;
        }
        if (b3 > f11) {
            b3 = f11;
        }
        float f12 = ((f11 - f10) / 50.0f) / 2.0f;
        return (b3 < f2 - f12 || b3 > f12 + f2) ? b3 : f2;
    }

    public abstract float b(float f2, float f10, float f11);
}
