package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class ScaleInAnimation implements BaseAnimation {
    public static final Companion Companion = new Companion(null);
    private static final float DEFAULT_SCALE_FROM = 0.5f;
    private final float mFrom;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public ScaleInAnimation() {
        this(0.0f, 1, null);
    }

    @Override // com.chad.library.adapter.base.animation.BaseAnimation
    public Animator[] animators(View view) {
        e.g(view, "view");
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", this.mFrom, 1.0f);
        e.b(scaleX, "scaleX");
        scaleX.setDuration(300L);
        scaleX.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", this.mFrom, 1.0f);
        e.b(scaleY, "scaleY");
        scaleY.setDuration(300L);
        scaleY.setInterpolator(new DecelerateInterpolator());
        return new Animator[]{scaleX, scaleY};
    }

    public ScaleInAnimation(float f2) {
        this.mFrom = f2;
    }

    public /* synthetic */ ScaleInAnimation(float f2, int i3, c cVar) {
        this((i3 & 1) != 0 ? 0.5f : f2);
    }
}
