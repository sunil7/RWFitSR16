package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class AlphaInAnimation implements BaseAnimation {
    public static final Companion Companion = new Companion(null);
    private static final float DEFAULT_ALPHA_FROM = 0.0f;
    private final float mFrom;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public AlphaInAnimation() {
        this(0.0f, 1, null);
    }

    @Override // com.chad.library.adapter.base.animation.BaseAnimation
    public Animator[] animators(View view) {
        e.g(view, "view");
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", this.mFrom, 1.0f);
        e.b(animator, "animator");
        animator.setDuration(300L);
        animator.setInterpolator(new LinearInterpolator());
        return new Animator[]{animator};
    }

    public AlphaInAnimation(float f2) {
        this.mFrom = f2;
    }

    public /* synthetic */ AlphaInAnimation(float f2, int i3, c cVar) {
        this((i3 & 1) != 0 ? 0.0f : f2);
    }
}
