package com.google.android.material.slider;

import android.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.h0;
import l1.z0;

/* loaded from: classes.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSlider f10761a;

    public d(BaseSlider baseSlider) {
        this.f10761a = baseSlider;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        BaseSlider baseSlider = this.f10761a;
        ArrayList arrayList = baseSlider.f10737k;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            jb.a aVar = (jb.a) obj;
            aVar.L = 1.2f;
            aVar.J = floatValue;
            aVar.K = floatValue;
            aVar.M = ja.a.b(0.0f, 1.0f, 0.19f, 1.0f, floatValue);
            aVar.invalidateSelf();
        }
        WeakHashMap weakHashMap = z0.f15748a;
        h0.k(baseSlider);
    }
}
