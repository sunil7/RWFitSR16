package com.dh.imagepick.preview.widgets;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.lifecycle.b0;
import com.dh.imagepick.preview.g;
import com.example.test.ui.device.activity.i0;
import com.example.test.utils.y;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.gms.internal.mlkit_vision_barcode.h1;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class PhotoView2 extends PhotoView {

    /* renamed from: f, reason: collision with root package name */
    public final eh.b f7157f;

    /* renamed from: g, reason: collision with root package name */
    public final eh.b f7158g;

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f7159h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7160i;

    /* renamed from: j, reason: collision with root package name */
    public float f7161j;

    /* renamed from: k, reason: collision with root package name */
    public float f7162k;

    /* renamed from: l, reason: collision with root package name */
    public float f7163l;

    /* renamed from: m, reason: collision with root package name */
    public b f7164m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhotoView2(Context context) {
        this(context, null, 6, 0);
        e.f(context, "context");
    }

    private final float getDismissEdge() {
        return ((Number) this.f7159h.getValue()).floatValue();
    }

    private final float getScaledTouchSlop() {
        return ((Number) this.f7158g.getValue()).floatValue();
    }

    private final g getViewModel() {
        return (g) this.f7157f.getValue();
    }

    private final void setSingleTouch(boolean z5) {
        this.f7160i = z5;
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
        } else if ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 3)) {
            setAllowParentInterceptOnEdge(true);
            setSingleTouch(true);
            this.f7161j = 0.0f;
            this.f7162k = 0.0f;
            this.f7163l = 0.0f;
            if (Math.abs(getTranslationY()) > getDismissEdge()) {
                b bVar = this.f7164m;
                if (bVar != null) {
                    y yVar = (y) bVar;
                    ((i0) yVar.f8773b).g((k5.a) yVar.f8774c, this);
                }
            } else {
                float min = Math.min(1.0f, getTranslationY() / getHeight());
                b bVar2 = this.f7164m;
                if (bVar2 != null) {
                    y yVar2 = (y) bVar2;
                    ((i0) yVar2.f8773b).i((k5.a) yVar2.f8774c, this, min);
                }
                animate().translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).start();
            }
        } else if (valueOf != null && valueOf.intValue() == 2) {
            RectF displayRect = getDisplayRect();
            if (this.f7160i && (getScale() == 1.0f || displayRect.top == 0.0f)) {
                if (this.f7162k == 0.0f) {
                    this.f7162k = motionEvent.getRawX();
                }
                if (this.f7163l == 0.0f) {
                    this.f7163l = motionEvent.getRawY();
                }
                float rawX = motionEvent.getRawX() - this.f7162k;
                float rawY = motionEvent.getRawY() - this.f7163l;
                if (this.f7161j == 0.0f) {
                    if (rawY > getScaledTouchSlop()) {
                        this.f7161j = getScaledTouchSlop();
                    } else if (rawY < (-getScaledTouchSlop())) {
                        this.f7161j = -getScaledTouchSlop();
                    }
                }
                float f2 = this.f7161j;
                if (f2 != 0.0f) {
                    float f10 = rawY - f2;
                    setAllowParentInterceptOnEdge(false);
                    float abs = Math.abs(Math.max(-1.0f, Math.min(1.0f, f10 / getHeight())));
                    float min2 = 1 - Math.min(0.4f, abs);
                    setScaleX(min2);
                    setScaleY(min2);
                    setTranslationY(f10);
                    setTranslationX(rawX / 2);
                    b bVar3 = this.f7164m;
                    if (bVar3 != null) {
                        y yVar3 = (y) bVar3;
                        ((i0) yVar3.f8773b).e((k5.a) yVar3.f8774c, this, abs);
                    }
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animate().cancel();
    }

    public final void setListener(b bVar) {
        this.f7164m = bVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhotoView2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        e.f(context, "context");
    }

    public /* synthetic */ PhotoView2(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoView2(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        e.f(context, "context");
        this.f7157f = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.widgets.PhotoView2$viewModel$2
            {
                super(0);
            }

            @Override // oh.a
            public final g invoke() {
                return (g) h1.a(PhotoView2.this);
            }
        });
        this.f7158g = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.widgets.PhotoView2$scaledTouchSlop$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // oh.a
            public final Float invoke() {
                return Float.valueOf(ViewConfiguration.get(context).getScaledTouchSlop() * 4.0f);
            }
        });
        this.f7159h = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.widgets.PhotoView2$dismissEdge$2
            {
                super(0);
            }

            @Override // oh.a
            public final Float invoke() {
                return Float.valueOf(PhotoView2.this.getHeight() * 0.12f);
            }
        });
        this.f7160i = true;
    }
}
