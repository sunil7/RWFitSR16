package com.google.android.material.textfield;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10893a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f10894b;

    public /* synthetic */ d(e eVar, int i3) {
        this.f10893a = i3;
        this.f10894b = eVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f10893a) {
            case 0:
                this.f10894b.f10923c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            default:
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                e eVar = this.f10894b;
                eVar.f10923c.setScaleX(floatValue);
                eVar.f10923c.setScaleY(floatValue);
                break;
        }
    }
}
