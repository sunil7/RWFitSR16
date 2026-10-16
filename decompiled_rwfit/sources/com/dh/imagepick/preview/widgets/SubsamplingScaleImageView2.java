package com.dh.imagepick.preview.widgets;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.lifecycle.b0;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.dh.imagepick.preview.g;
import com.example.test.ui.device.activity.i0;
import com.google.android.gms.internal.mlkit_vision_barcode.h1;
import ef.i;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class SubsamplingScaleImageView2 extends SubsamplingScaleImageView {

    /* renamed from: a, reason: collision with root package name */
    public final eh.b f7165a;

    /* renamed from: b, reason: collision with root package name */
    public Float f7166b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7167c;

    /* renamed from: d, reason: collision with root package name */
    public final eh.b f7168d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public float f7169f;

    /* renamed from: g, reason: collision with root package name */
    public float f7170g;

    /* renamed from: h, reason: collision with root package name */
    public float f7171h;

    /* renamed from: i, reason: collision with root package name */
    public d f7172i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubsamplingScaleImageView2(Context context) {
        this(context, null);
        e.f(context, "context");
    }

    private final float getDismissEdge() {
        return ((Number) this.f7168d.getValue()).floatValue();
    }

    private final float getScaledTouchSlop() {
        return ((Number) this.f7167c.getValue()).floatValue();
    }

    private final g getViewModel() {
        return (g) this.f7165a.getValue();
    }

    private final void setSingleTouch(boolean z5) {
        this.e = z5;
        g viewModel = getViewModel();
        if (viewModel != null) {
            b0 b0Var = viewModel.f7143b;
            if (e.a(b0Var.d(), Boolean.valueOf(z5))) {
                return;
            }
            b0Var.k(Boolean.valueOf(z5));
        }
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getActionMasked()) : null;
        if (valueOf != null && valueOf.intValue() == 5) {
            setSingleTouch(false);
            animate().translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).start();
        } else if (valueOf != null && valueOf.intValue() == 0) {
            if (this.f7166b == null) {
                this.f7166b = Float.valueOf(getScale());
            }
        } else if ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 3)) {
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
            setSingleTouch(true);
            this.f7169f = 0.0f;
            this.f7170g = 0.0f;
            this.f7171h = 0.0f;
            if (Math.abs(getTranslationY()) > getDismissEdge()) {
                d dVar = this.f7172i;
                if (dVar != null) {
                    i iVar = (i) dVar;
                    ((i0) iVar.f12629b).g((k5.b) iVar.f12630c, this);
                }
            } else {
                float min = Math.min(1.0f, getTranslationY() / getHeight());
                d dVar2 = this.f7172i;
                if (dVar2 != null) {
                    i iVar2 = (i) dVar2;
                    ((i0) iVar2.f12629b).i((k5.b) iVar2.f12630c, this, min);
                }
                animate().translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).start();
            }
        } else if (valueOf != null && valueOf.intValue() == 2) {
            RectF rectF = new RectF();
            getPanRemaining(rectF);
            if (this.e) {
                float scale = getScale();
                Float f2 = this.f7166b;
                if ((f2 != null && scale == f2.floatValue()) || rectF.top == 0.0f) {
                    if (this.f7170g == 0.0f) {
                        this.f7170g = motionEvent.getRawX();
                    }
                    if (this.f7171h == 0.0f) {
                        this.f7171h = motionEvent.getRawY();
                    }
                    float rawX = motionEvent.getRawX() - this.f7170g;
                    float rawY = motionEvent.getRawY() - this.f7171h;
                    if (this.f7169f == 0.0f) {
                        if (rawY > getScaledTouchSlop()) {
                            this.f7169f = getScaledTouchSlop();
                        } else if (rawY < (-getScaledTouchSlop())) {
                            this.f7169f = -getScaledTouchSlop();
                        }
                    }
                    float f10 = this.f7169f;
                    if (f10 != 0.0f) {
                        float f11 = rawY - f10;
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        float abs = Math.abs(Math.max(-1.0f, Math.min(1.0f, f11 / getHeight())));
                        float min2 = 1 - Math.min(0.4f, abs);
                        setScaleX(min2);
                        setScaleY(min2);
                        setTranslationY(f11);
                        setTranslationX(rawX / 2);
                        d dVar3 = this.f7172i;
                        if (dVar3 != null) {
                            i iVar3 = (i) dVar3;
                            ((i0) iVar3.f12629b).e((k5.b) iVar3.f12630c, this, abs);
                        }
                    }
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animate().cancel();
    }

    public final void setListener(d dVar) {
        this.f7172i = dVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubsamplingScaleImageView2(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e.f(context, "context");
        this.f7165a = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.widgets.SubsamplingScaleImageView2$viewModel$2
            {
                super(0);
            }

            @Override // oh.a
            public final g invoke() {
                return (g) h1.a(SubsamplingScaleImageView2.this);
            }
        });
        this.f7167c = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.widgets.SubsamplingScaleImageView2$scaledTouchSlop$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // oh.a
            public final Float invoke() {
                return Float.valueOf(ViewConfiguration.get(context).getScaledTouchSlop() * 4.0f);
            }
        });
        this.f7168d = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.widgets.SubsamplingScaleImageView2$dismissEdge$2
            {
                super(0);
            }

            @Override // oh.a
            public final Float invoke() {
                return Float.valueOf(SubsamplingScaleImageView2.this.getHeight() * 0.12f);
            }
        });
        this.e = true;
        setOnImageEventListener(new c(this));
    }
}
