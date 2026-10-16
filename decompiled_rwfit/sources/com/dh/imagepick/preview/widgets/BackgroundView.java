package com.dh.imagepick.preview.widgets;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class BackgroundView extends ConstraintLayout {

    /* renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f7153v = 0;

    /* renamed from: s, reason: collision with root package name */
    public final eh.b f7154s;

    /* renamed from: t, reason: collision with root package name */
    public int f7155t;

    /* renamed from: u, reason: collision with root package name */
    public ValueAnimator f7156u;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BackgroundView(Context context) {
        this(context, null);
        e.f(context, "context");
    }

    private final ArgbEvaluator getArgbEvaluator() {
        return (ArgbEvaluator) this.f7154s.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f7156u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void p(final int i3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        final int i10 = this.f7155t;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dh.imagepick.preview.widgets.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator it) {
                int i11 = BackgroundView.f7153v;
                BackgroundView this$0 = BackgroundView.this;
                e.f(this$0, "this$0");
                e.f(it, "it");
                Object animatedValue = it.getAnimatedValue();
                e.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                this$0.q(i10, ((Float) animatedValue).floatValue(), i3);
            }
        });
        this.f7156u = ofFloat;
        ofFloat.start();
    }

    public final void q(int i3, float f2, int i10) {
        Object evaluate = getArgbEvaluator().evaluate(f2, Integer.valueOf(i3), Integer.valueOf(i10));
        e.d(evaluate, "null cannot be cast to non-null type kotlin.Int");
        setBackgroundColor(((Integer) evaluate).intValue());
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        super.setBackgroundColor(i3);
        this.f7155t = i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e.f(context, "context");
        this.f7154s = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.widgets.BackgroundView$argbEvaluator$2
            @Override // oh.a
            public final ArgbEvaluator invoke() {
                return new ArgbEvaluator();
            }
        });
    }
}
