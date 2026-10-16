package com.dh.imagepick.preview.widgets.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import java.util.ArrayList;
import kotlin.collections.h;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class ExoVideoView2 extends ExoVideoView implements View.OnTouchListener {

    /* renamed from: g, reason: collision with root package name */
    public final eh.b f7182g;

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f7183h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7184i;

    /* renamed from: j, reason: collision with root package name */
    public float f7185j;

    /* renamed from: k, reason: collision with root package name */
    public float f7186k;

    /* renamed from: l, reason: collision with root package name */
    public float f7187l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f7188m;

    /* renamed from: n, reason: collision with root package name */
    public View.OnClickListener f7189n;

    /* renamed from: o, reason: collision with root package name */
    public View.OnLongClickListener f7190o;

    /* renamed from: p, reason: collision with root package name */
    public final GestureDetector f7191p;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExoVideoView2(Context context) {
        this(context, null, 6, 0);
        e.f(context, "context");
    }

    private final float getDismissEdge() {
        return ((Number) this.f7183h.getValue()).floatValue();
    }

    private final float getScaledTouchSlop() {
        return ((Number) this.f7182g.getValue()).floatValue();
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getPrepared()) {
            Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getActionMasked()) : null;
            if (valueOf != null && valueOf.intValue() == 5) {
                this.f7184i = false;
                animate().translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).start();
            } else {
                ArrayList arrayList = this.f7188m;
                if ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 3)) {
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(false);
                    }
                    this.f7184i = true;
                    this.f7185j = 0.0f;
                    this.f7186k = 0.0f;
                    this.f7187l = 0.0f;
                    if (Math.abs(getTranslationY()) > getDismissEdge()) {
                        for (k5.d dVar : h.v(arrayList)) {
                            dVar.getClass();
                            dVar.f15508a.g(dVar.f15509b, this);
                        }
                    } else {
                        float min = Math.min(1.0f, getTranslationY() / getHeight());
                        for (k5.d dVar2 : h.v(arrayList)) {
                            dVar2.getClass();
                            dVar2.f15508a.i(dVar2.f15509b, this, min);
                        }
                        animate().translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).start();
                    }
                } else if (valueOf != null && valueOf.intValue() == 2 && this.f7184i) {
                    if (this.f7186k == 0.0f) {
                        this.f7186k = motionEvent.getRawX();
                    }
                    if (this.f7187l == 0.0f) {
                        this.f7187l = motionEvent.getRawY();
                    }
                    float rawX = motionEvent.getRawX() - this.f7186k;
                    float rawY = motionEvent.getRawY() - this.f7187l;
                    if (this.f7185j == 0.0f) {
                        if (rawY > getScaledTouchSlop()) {
                            this.f7185j = getScaledTouchSlop();
                        } else if (rawY < (-getScaledTouchSlop())) {
                            this.f7185j = -getScaledTouchSlop();
                        }
                    }
                    float f2 = this.f7185j;
                    if (f2 != 0.0f) {
                        float f10 = rawY - f2;
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        float abs = Math.abs(Math.max(-1.0f, Math.min(1.0f, f10 / getHeight())));
                        float min2 = 1 - Math.min(0.4f, abs);
                        setScaleX(min2);
                        setScaleY(min2);
                        setTranslationY(f10);
                        setTranslationX(rawX / 2);
                        for (k5.d dVar3 : h.v(arrayList)) {
                            dVar3.getClass();
                            dVar3.f15508a.e(dVar3.f15509b, this, abs);
                        }
                    }
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.dh.imagepick.preview.widgets.video.ExoVideoView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animate().cancel();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f7191p;
        e.c(motionEvent);
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f7189n = onClickListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f7190o = onLongClickListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExoVideoView2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        e.f(context, "context");
    }

    public /* synthetic */ ExoVideoView2(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExoVideoView2(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        e.f(context, "context");
        this.f7182g = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.widgets.video.ExoVideoView2$scaledTouchSlop$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // oh.a
            public final Float invoke() {
                return Float.valueOf(ViewConfiguration.get(context).getScaledTouchSlop() * 4.0f);
            }
        });
        this.f7183h = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.widgets.video.ExoVideoView2$dismissEdge$2
            {
                super(0);
            }

            @Override // oh.a
            public final Float invoke() {
                return Float.valueOf(ExoVideoView2.this.getHeight() * 0.12f);
            }
        });
        this.f7184i = true;
        this.f7188m = new ArrayList();
        setOnTouchListener(this);
        GestureDetector gestureDetector = new GestureDetector(context, new c(this, 0));
        gestureDetector.setOnDoubleTapListener(new d(this, 0));
        this.f7191p = gestureDetector;
    }
}
