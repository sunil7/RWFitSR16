package com.amap.api.maps;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewGroup.LayoutParams f5722a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SwipeDismissTouchListener f5723b;

    public f(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.f5723b = swipeDismissTouchListener;
        this.f5722a = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        this.f5722a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view = this.f5723b.mView;
        view.setLayoutParams(this.f5722a);
    }
}
