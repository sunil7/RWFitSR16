package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import j2.f0;
import j2.m0;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class u extends f0 {
    @Override // j2.f0
    public final void d(m0 m0Var) {
        View view = m0Var.f15264b;
        if (view instanceof TextView) {
            m0Var.f15263a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // j2.f0
    public final void g(m0 m0Var) {
        View view = m0Var.f15264b;
        if (view instanceof TextView) {
            m0Var.f15263a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // j2.f0
    public final Animator k(ViewGroup viewGroup, m0 m0Var, m0 m0Var2) {
        if (m0Var == null || m0Var2 == null || !(m0Var.f15264b instanceof TextView)) {
            return null;
        }
        View view = m0Var2.f15264b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        HashMap hashMap = m0Var.f15263a;
        HashMap hashMap2 = m0Var2.f15263a;
        float floatValue = hashMap.get("android:textscale:scale") != null ? ((Float) hashMap.get("android:textscale:scale")).floatValue() : 1.0f;
        float floatValue2 = hashMap2.get("android:textscale:scale") != null ? ((Float) hashMap2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (floatValue == floatValue2) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, floatValue2);
        ofFloat.addUpdateListener(new t(textView, 0));
        return ofFloat;
    }
}
