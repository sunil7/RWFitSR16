package com.google.android.gms.internal.mlkit_vision_common;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;

/* loaded from: classes.dex */
public abstract class v {
    /* JADX WARN: Multi-variable type inference failed */
    public static AnimatorSet a(ra.e eVar, float f2, float f10, float f11) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(eVar, ra.b.f18104a, ra.a.f18102b, new ra.d(f2, f10, f11));
        ra.d revealInfo = eVar.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) eVar, (int) f2, (int) f10, revealInfo.f18108c, f11);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofObject, createCircularReveal);
        return animatorSet;
    }
}
