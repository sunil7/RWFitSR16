package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f10215a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f10216b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f10217c;

    public a(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f10217c = baseBehavior;
        this.f10215a = coordinatorLayout;
        this.f10216b = appBarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f10217c.v(this.f10215a, this.f10216b, ((Integer) valueAnimator.getAnimatedValue()).intValue(), Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }
}
