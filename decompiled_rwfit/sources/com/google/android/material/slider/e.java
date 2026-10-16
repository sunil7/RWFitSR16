package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import com.example.test.ui.device.activity.i0;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSlider f10762a;

    public e(BaseSlider baseSlider) {
        this.f10762a = baseSlider;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        BaseSlider baseSlider = this.f10762a;
        ArrayList arrayList = baseSlider.f10737k;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            jb.a aVar = (jb.a) obj;
            ViewGroup c9 = gb.c(baseSlider);
            ((ViewOverlay) (c9 == null ? null : new i0(c9)).f7866b).remove(aVar);
        }
    }
}
