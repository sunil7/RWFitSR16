package com.amap.api.maps;

import android.view.animation.Animation;

/* loaded from: classes.dex */
class a implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f5707a;

    public a(c cVar, Runnable runnable) {
        this.f5707a = runnable;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f5707a.run();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
