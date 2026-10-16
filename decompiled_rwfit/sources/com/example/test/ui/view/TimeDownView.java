package com.example.test.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import java.util.Timer;

/* loaded from: classes.dex */
public class TimeDownView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    public final Timer f8643a;

    /* renamed from: b, reason: collision with root package name */
    public i f8644b;

    /* renamed from: c, reason: collision with root package name */
    public int f8645c;

    /* renamed from: d, reason: collision with root package name */
    public int f8646d;
    public long e;

    /* renamed from: f, reason: collision with root package name */
    public AnimationSet f8647f;

    /* renamed from: g, reason: collision with root package name */
    public r f8648g;

    /* renamed from: h, reason: collision with root package name */
    public final androidx.appcompat.app.f f8649h;

    /* renamed from: i, reason: collision with root package name */
    public int f8650i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f8651j;

    public TimeDownView(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f8645c = 3;
        this.f8646d = 1;
        this.e = 1000L;
        if (this.f8647f == null) {
            this.f8647f = new AnimationSet(true);
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(3.0f, 1.0f, 3.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(this.e);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.3f);
        alphaAnimation.setDuration(this.e);
        this.f8647f.addAnimation(scaleAnimation);
        this.f8647f.addAnimation(alphaAnimation);
        this.f8647f.setInterpolator(new AccelerateInterpolator());
        setAnimation(this.f8647f);
        if (this.f8644b == null) {
            this.f8644b = new i(this, 1);
        }
        this.f8643a.schedule(this.f8644b, 0L, 1000L);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f8650i == 0) {
            return;
        }
        super.onDraw(canvas);
    }

    public void setOnTimeDownListener(r rVar) {
        this.f8648g = rVar;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (8 == i3) {
            this.f8643a.cancel();
        }
    }

    public TimeDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimeDownView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8648g = null;
        this.f8650i = 1;
        this.f8651j = true;
        if (this.f8643a == null) {
            this.f8643a = new Timer();
        }
        if (this.f8647f == null) {
            this.f8647f = new AnimationSet(true);
        }
        if (this.f8649h == null) {
            this.f8649h = new androidx.appcompat.app.f(this);
        }
        setGravity(17);
    }
}
