package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class SlideInBottomAnimation implements BaseAnimation {
    @Override // com.chad.library.adapter.base.animation.BaseAnimation
    public Animator[] animators(View view) {
        e.g(view, "view");
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", view.getMeasuredHeight(), 0.0f);
        e.b(animator, "animator");
        animator.setDuration(400L);
        animator.setInterpolator(new DecelerateInterpolator(1.3f));
        return new Animator[]{animator};
    }
}
