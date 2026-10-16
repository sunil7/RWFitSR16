package com.example.test.ui.view;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.exoplayer2.ui.DefaultTimeBar;

/* loaded from: classes.dex */
public final /* synthetic */ class p implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8707a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f8708b;

    public /* synthetic */ p(int i3, View view) {
        this.f8707a = i3;
        this.f8708b = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = this.f8708b;
        switch (this.f8707a) {
            case 0:
                int i3 = SleepDetailChartView.f8573l;
                SleepDetailChartView sleepDetailChartView = (SleepDetailChartView) view;
                sleepDetailChartView.getClass();
                sleepDetailChartView.f8578f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                sleepDetailChartView.invalidate();
                break;
            default:
                int i10 = DefaultTimeBar.P;
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                defaultTimeBar.getClass();
                defaultTimeBar.F = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                defaultTimeBar.invalidate(defaultTimeBar.f8905a);
                break;
        }
    }
}
