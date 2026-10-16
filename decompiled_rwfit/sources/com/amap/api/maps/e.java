package com.amap.api.maps;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
class e extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewGroup.LayoutParams f5719a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f5720b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SwipeDismissTouchListener f5721c;

    public e(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams, int i3) {
        this.f5721c = swipeDismissTouchListener;
        this.f5719a = layoutParams;
        this.f5720b = i3;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        View view;
        View view2;
        View view3;
        view = this.f5721c.mView;
        view.setAlpha(0.0f);
        view2 = this.f5721c.mView;
        view2.setTranslationX(0.0f);
        this.f5719a.height = this.f5720b;
        view3 = this.f5721c.mView;
        view3.setLayoutParams(this.f5719a);
    }
}
