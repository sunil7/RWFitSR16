package com.google.android.material.slider;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f10763a = -1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseSlider f10764b;

    public f(BaseSlider baseSlider) {
        this.f10764b = baseSlider;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10764b.f10733g.x(this.f10763a, 4);
    }
}
