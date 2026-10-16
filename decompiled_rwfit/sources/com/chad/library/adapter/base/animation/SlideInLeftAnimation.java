package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class SlideInLeftAnimation implements BaseAnimation {
    @Override // com.chad.library.adapter.base.animation.BaseAnimation
    public Animator[] animators(View view) {
        e.g(view, "view");
        e.b(view.getRootView(), "view.rootView");
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", -r0.getWidth(), 0.0f);
        e.b(animator, "animator");
        animator.setDuration(400L);
        animator.setInterpolator(new DecelerateInterpolator(1.8f));
        return new Animator[]{animator};
    }
}
