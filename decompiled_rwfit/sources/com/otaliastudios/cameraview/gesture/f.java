package com.otaliastudios.cameraview.gesture;

import android.view.GestureDetector;

/* loaded from: classes2.dex */
public final class f extends a {

    /* renamed from: g, reason: collision with root package name */
    public static final ef.b f11607g = ef.b.a(f.class.getSimpleName());

    /* renamed from: d, reason: collision with root package name */
    public GestureDetector f11608d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public float f11609f;

    @Override // com.otaliastudios.cameraview.gesture.a
    public final float b(float f2, float f10, float f11) {
        return ((f11 - f10) * this.f11609f * 2.0f) + f2;
    }
}
