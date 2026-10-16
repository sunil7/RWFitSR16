package com.google.android.material.progressindicator;

import ab.a;
import ab.b;
import ab.c;
import ab.d;
import ab.j;
import ab.l;
import ab.m;
import ab.o;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.internal.mlkit_vision_barcode.s0;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.WeakHashMap;
import l1.k0;
import l1.z0;

/* loaded from: classes.dex */
public abstract class BaseProgressIndicator<S extends d> extends ProgressBar {

    /* renamed from: l, reason: collision with root package name */
    public static final int f10705l = R$style.Widget_MaterialComponents_ProgressIndicator;

    /* renamed from: a, reason: collision with root package name */
    public final d f10706a;

    /* renamed from: b, reason: collision with root package name */
    public int f10707b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10708c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10709d;
    public a e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10710f;

    /* renamed from: g, reason: collision with root package name */
    public int f10711g;

    /* renamed from: h, reason: collision with root package name */
    public final b f10712h;

    /* renamed from: i, reason: collision with root package name */
    public final b f10713i;

    /* renamed from: j, reason: collision with root package name */
    public final c f10714j;

    /* renamed from: k, reason: collision with root package name */
    public final c f10715k;

    public BaseProgressIndicator(Context context, AttributeSet attributeSet, int i3, int i10) {
        super(ib.a.a(context, attributeSet, i3, f10705l), attributeSet, i3);
        this.f10710f = false;
        this.f10711g = 4;
        this.f10712h = new b(this, 0);
        this.f10713i = new b(this, 1);
        this.f10714j = new c(this, 0);
        this.f10715k = new c(this, 1);
        Context context2 = getContext();
        this.f10706a = a(context2, attributeSet);
        TypedArray d5 = w.d(context2, attributeSet, R$styleable.BaseProgressIndicator, i3, i10, new int[0]);
        d5.getInt(R$styleable.BaseProgressIndicator_showDelay, -1);
        this.f10709d = Math.min(d5.getInt(R$styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        d5.recycle();
        this.e = new a();
        this.f10708c = true;
    }

    private m getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().f197l;
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().f175l;
    }

    public abstract d a(Context context, AttributeSet attributeSet);

    public void b(int i3) {
        if (!isIndeterminate()) {
            super.setProgress(i3);
            if (getProgressDrawable() != null) {
                getProgressDrawable().jumpToCurrentState();
                return;
            }
            return;
        }
        if (getProgressDrawable() != null) {
            this.f10707b = i3;
            this.f10710f = true;
            if (getIndeterminateDrawable().isVisible()) {
                a aVar = this.e;
                ContentResolver contentResolver = getContext().getContentResolver();
                aVar.getClass();
                if (Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f) != 0.0f) {
                    getIndeterminateDrawable().f198m.r();
                    return;
                }
            }
            getIndeterminateDrawable();
            this.f10714j.a();
        }
    }

    public final boolean c() {
        WeakHashMap weakHashMap = z0.f15748a;
        if (!k0.b(this) || getWindowVisibility() != 0) {
            return false;
        }
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f10706a.f155f;
    }

    public int[] getIndicatorColor() {
        return this.f10706a.f153c;
    }

    public int getShowAnimationBehavior() {
        return this.f10706a.e;
    }

    public int getTrackColor() {
        return this.f10706a.f154d;
    }

    public int getTrackCornerRadius() {
        return this.f10706a.f152b;
    }

    public int getTrackThickness() {
        return this.f10706a.f151a;
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f198m.q(this.f10714j);
        }
        j progressDrawable = getProgressDrawable();
        c cVar = this.f10715k;
        if (progressDrawable != null) {
            j progressDrawable2 = getProgressDrawable();
            if (progressDrawable2.f187f == null) {
                progressDrawable2.f187f = new ArrayList();
            }
            if (!progressDrawable2.f187f.contains(cVar)) {
                progressDrawable2.f187f.add(cVar);
            }
        }
        if (getIndeterminateDrawable() != null) {
            o indeterminateDrawable = getIndeterminateDrawable();
            if (indeterminateDrawable.f187f == null) {
                indeterminateDrawable.f187f = new ArrayList();
            }
            if (!indeterminateDrawable.f187f.contains(cVar)) {
                indeterminateDrawable.f187f.add(cVar);
            }
        }
        if (c()) {
            if (this.f10709d > 0) {
                SystemClock.uptimeMillis();
            }
            setVisibility(0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f10713i);
        removeCallbacks(this.f10712h);
        ((l) getCurrentDrawable()).e(false, false, false);
        o indeterminateDrawable = getIndeterminateDrawable();
        c cVar = this.f10715k;
        if (indeterminateDrawable != null) {
            getIndeterminateDrawable().g(cVar);
            getIndeterminateDrawable().f198m.w();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().g(cVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        try {
            int save = canvas.save();
            if (getPaddingLeft() == 0) {
                if (getPaddingTop() != 0) {
                }
                if (getPaddingRight() == 0 || getPaddingBottom() != 0) {
                    canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
                }
                getCurrentDrawable().draw(canvas);
                canvas.restoreToCount(save);
            }
            canvas.translate(getPaddingLeft(), getPaddingTop());
            if (getPaddingRight() == 0) {
            }
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(save);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i3, int i10) {
        try {
            super.onMeasure(i3, i10);
            m currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            int e = currentDrawingDelegate.e();
            int d5 = currentDrawingDelegate.d();
            setMeasuredDimension(e < 0 ? getMeasuredWidth() : e + getPaddingLeft() + getPaddingRight(), d5 < 0 ? getMeasuredHeight() : d5 + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        boolean z5 = i3 == 0;
        if (this.f10708c) {
            ((l) getCurrentDrawable()).e(c(), false, z5);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        if (this.f10708c) {
            ((l) getCurrentDrawable()).e(c(), false, false);
        }
    }

    public void setAnimatorDurationScaleProvider(a aVar) {
        this.e = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f185c = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f185c = aVar;
        }
    }

    public void setHideAnimationBehavior(int i3) {
        this.f10706a.f155f = i3;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z5) {
        try {
            if (z5 == isIndeterminate()) {
                return;
            }
            if (c() && z5) {
                throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
            }
            l lVar = (l) getCurrentDrawable();
            if (lVar != null) {
                lVar.e(false, false, false);
            }
            super.setIndeterminate(z5);
            l lVar2 = (l) getCurrentDrawable();
            if (lVar2 != null) {
                lVar2.e(c(), false, false);
            }
            this.f10710f = false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof o)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((l) drawable).e(false, false, false);
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            TypedValue a3 = s0.a(getContext(), R$attr.colorPrimary);
            iArr = new int[]{a3 != null ? a3.data : -1};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f10706a.f153c = iArr;
        getIndeterminateDrawable().f198m.p();
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i3) {
        if (isIndeterminate()) {
            return;
        }
        b(i3);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof j)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            j jVar = (j) drawable;
            jVar.e(false, false, false);
            super.setProgressDrawable(jVar);
            jVar.setLevel((int) ((getProgress() / getMax()) * 10000.0f));
        }
    }

    public void setShowAnimationBehavior(int i3) {
        this.f10706a.e = i3;
        invalidate();
    }

    public void setTrackColor(int i3) {
        d dVar = this.f10706a;
        if (dVar.f154d != i3) {
            dVar.f154d = i3;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i3) {
        d dVar = this.f10706a;
        if (dVar.f152b != i3) {
            dVar.f152b = Math.min(i3, dVar.f151a / 2);
        }
    }

    public void setTrackThickness(int i3) {
        d dVar = this.f10706a;
        if (dVar.f151a != i3) {
            dVar.f151a = i3;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i3) {
        if (i3 != 0 && i3 != 4 && i3 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f10711g = i3;
    }

    @Override // android.widget.ProgressBar
    public o getIndeterminateDrawable() {
        return (o) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public j getProgressDrawable() {
        return (j) super.getProgressDrawable();
    }
}
