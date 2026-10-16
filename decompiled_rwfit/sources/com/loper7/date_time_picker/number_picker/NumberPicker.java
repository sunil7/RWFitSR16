package com.loper7.date_time_picker.number_picker;

import a1.d;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import cf.a;
import cf.b;
import cf.c;
import cf.e;
import cf.f;
import cf.h;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.loper7.date_time_picker.R$styleable;
import java.text.NumberFormat;

/* loaded from: classes2.dex */
public class NumberPicker extends LinearLayout {

    /* renamed from: p1, reason: collision with root package name */
    public static final f f11493p1 = new f();
    public int A;
    public int B;
    public int C;
    public View.OnClickListener D;
    public e E;
    public c F;
    public long G;
    public final SparseArray H;
    public int I;
    public int J;
    public int K;
    public int[] L;
    public final Paint M;
    public int N;
    public int O;
    public int P;
    public final h Q;
    public final h R;
    public int S;
    public int T;
    public b U;
    public final int U0;
    public float V;
    public int V0;
    public float W;
    public int W0;
    public int X0;
    public int Y0;
    public int Z0;

    /* renamed from: a, reason: collision with root package name */
    public String f11494a;

    /* renamed from: a0, reason: collision with root package name */
    public float f11495a0;

    /* renamed from: a1, reason: collision with root package name */
    public int f11496a1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11497b;

    /* renamed from: b0, reason: collision with root package name */
    public float f11498b0;

    /* renamed from: b1, reason: collision with root package name */
    public int f11499b1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11500c;

    /* renamed from: c0, reason: collision with root package name */
    public VelocityTracker f11501c0;

    /* renamed from: c1, reason: collision with root package name */
    public int f11502c1;

    /* renamed from: d, reason: collision with root package name */
    public final EditText f11503d;

    /* renamed from: d0, reason: collision with root package name */
    public final int f11504d0;

    /* renamed from: d1, reason: collision with root package name */
    public final boolean f11505d1;
    public float e;

    /* renamed from: e0, reason: collision with root package name */
    public final int f11506e0;

    /* renamed from: e1, reason: collision with root package name */
    public int f11507e1;

    /* renamed from: f, reason: collision with root package name */
    public float f11508f;

    /* renamed from: f0, reason: collision with root package name */
    public int f11509f0;
    public int f1;

    /* renamed from: g, reason: collision with root package name */
    public int f11510g;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f11511g0;

    /* renamed from: g1, reason: collision with root package name */
    public boolean f11512g1;

    /* renamed from: h, reason: collision with root package name */
    public int f11513h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f11514h0;

    /* renamed from: h1, reason: collision with root package name */
    public float f11515h1;

    /* renamed from: i, reason: collision with root package name */
    public int f11516i;
    public Drawable i0;

    /* renamed from: i1, reason: collision with root package name */
    public boolean f11517i1;

    /* renamed from: j, reason: collision with root package name */
    public int f11518j;

    /* renamed from: j0, reason: collision with root package name */
    public int f11519j0;

    /* renamed from: j1, reason: collision with root package name */
    public float f11520j1;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f11521k;

    /* renamed from: k0, reason: collision with root package name */
    public int f11522k0;

    /* renamed from: k1, reason: collision with root package name */
    public int f11523k1;

    /* renamed from: l, reason: collision with root package name */
    public int f11524l;

    /* renamed from: l1, reason: collision with root package name */
    public boolean f11525l1;

    /* renamed from: m, reason: collision with root package name */
    public int f11526m;

    /* renamed from: m1, reason: collision with root package name */
    public final Context f11527m1;

    /* renamed from: n, reason: collision with root package name */
    public float f11528n;

    /* renamed from: n1, reason: collision with root package name */
    public final ViewConfiguration f11529n1;

    /* renamed from: o, reason: collision with root package name */
    public boolean f11530o;

    /* renamed from: o1, reason: collision with root package name */
    public int f11531o1;

    /* renamed from: p, reason: collision with root package name */
    public boolean f11532p;

    /* renamed from: q, reason: collision with root package name */
    public Typeface f11533q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f11534s;

    /* renamed from: t, reason: collision with root package name */
    public float f11535t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f11536u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f11537v;

    /* renamed from: w, reason: collision with root package name */
    public Typeface f11538w;

    /* renamed from: x, reason: collision with root package name */
    public int f11539x;

    /* renamed from: y, reason: collision with root package name */
    public int f11540y;

    /* renamed from: z, reason: collision with root package name */
    public String[] f11541z;

    public NumberPicker(Context context) {
        this(context, null);
    }

    private float getMaxTextSize() {
        return Math.max(this.f11535t, this.f11528n);
    }

    private int[] getSelectorIndices() {
        return this.L;
    }

    public static c getTwoDigitFormatter() {
        return f11493p1;
    }

    public static int l(int i3, int i10) {
        if (i10 != -1) {
            int size = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            if (mode == Integer.MIN_VALUE) {
                return View.MeasureSpec.makeMeasureSpec(Math.min(size, i10), 1073741824);
            }
            if (mode == 0) {
                return View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
            }
            if (mode != 1073741824) {
                throw new IllegalArgumentException(l0.j(mode, "Unknown measure mode: "));
            }
        }
        return i3;
    }

    public static int r(int i3, int i10, int i11) {
        if (i3 == -1) {
            return i10;
        }
        int max = Math.max(i3, i10);
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? max : size : size < max ? 16777216 | size : max;
    }

    public final void a(boolean z5) {
        h hVar = this.Q;
        if (!m(hVar)) {
            m(this.R);
        }
        int i3 = z5 ? -this.N : this.N;
        if (k()) {
            this.S = 0;
            hVar.b(i3, 0, 300);
        } else {
            this.T = 0;
            hVar.b(0, i3, 300);
        }
        invalidate();
    }

    public final void b(int[] iArr) {
        for (int length = iArr.length - 1; length > 0; length--) {
            iArr[length] = iArr[length - 1];
        }
        int i3 = iArr[1] - 1;
        if (this.f11511g0 && i3 < this.A) {
            i3 = this.B;
        }
        iArr[0] = i3;
        c(i3);
    }

    public final void c(int i3) {
        String str;
        SparseArray sparseArray = this.H;
        if (((String) sparseArray.get(i3)) != null) {
            return;
        }
        int i10 = this.A;
        if (i3 < i10 || i3 > this.B) {
            str = "";
        } else {
            String[] strArr = this.f11541z;
            if (strArr != null) {
                int i11 = i3 - i10;
                if (i11 >= strArr.length) {
                    sparseArray.remove(i3);
                    return;
                }
                str = strArr[i11];
            } else {
                str = f(i3);
            }
        }
        sparseArray.put(i3, str);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return k() ? getWidth() : getHeight();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        if (k()) {
            return this.P;
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        if (k()) {
            return ((this.B - this.A) + 1) * this.N;
        }
        return 0;
    }

    @Override // android.view.View
    public final void computeScroll() {
        float f2;
        float f10;
        if (this.f11517i1) {
            h hVar = this.Q;
            if (hVar.f3492p) {
                hVar = this.R;
                if (hVar.f3492p) {
                    return;
                }
            }
            if (!hVar.f3492p) {
                int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - hVar.f3487k);
                int i3 = hVar.f3488l;
                if (currentAnimationTimeMillis < i3) {
                    int i10 = hVar.f3479b;
                    if (i10 == 0) {
                        float interpolation = hVar.f3478a.getInterpolation(currentAnimationTimeMillis * hVar.f3489m);
                        hVar.f3485i = Math.round(hVar.f3490n * interpolation) + hVar.f3480c;
                        hVar.f3486j = Math.round(interpolation * hVar.f3491o) + hVar.f3481d;
                    } else if (i10 == 1) {
                        float f11 = i3;
                        float f12 = currentAnimationTimeMillis / f11;
                        int i11 = (int) (f12 * 100.0f);
                        if (i11 < 100) {
                            float f13 = i11 / 100.0f;
                            int i12 = i11 + 1;
                            float[] fArr = h.f3476y;
                            float f14 = fArr[i11];
                            f10 = (fArr[i12] - f14) / ((i12 / 100.0f) - f13);
                            f2 = l0.a(f12, f13, f10, f14);
                        } else {
                            f2 = 1.0f;
                            f10 = 0.0f;
                        }
                        hVar.f3494s = ((f10 * hVar.f3495t) / f11) * 1000.0f;
                        int round = Math.round((hVar.e - r3) * f2) + hVar.f3480c;
                        hVar.f3485i = round;
                        int min = Math.min(round, hVar.f3483g);
                        hVar.f3485i = min;
                        hVar.f3485i = Math.max(min, 0);
                        int round2 = Math.round(f2 * (hVar.f3482f - r3)) + hVar.f3481d;
                        hVar.f3486j = round2;
                        int min2 = Math.min(round2, hVar.f3484h);
                        hVar.f3486j = min2;
                        int max = Math.max(min2, 0);
                        hVar.f3486j = max;
                        if (hVar.f3485i == hVar.e && max == hVar.f3482f) {
                            hVar.f3492p = true;
                        }
                    }
                } else {
                    hVar.f3485i = hVar.e;
                    hVar.f3486j = hVar.f3482f;
                    hVar.f3492p = true;
                }
            }
            if (k()) {
                int i13 = hVar.f3485i;
                if (this.S == 0) {
                    this.S = hVar.f3480c;
                }
                scrollBy(i13 - this.S, 0);
                this.S = i13;
            } else {
                int i14 = hVar.f3486j;
                if (this.T == 0) {
                    this.T = hVar.f3481d;
                }
                scrollBy(0, i14 - this.T);
                this.T = i14;
            }
            if (hVar.f3492p) {
                o(hVar);
            } else {
                postInvalidate();
            }
        }
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return k() ? getWidth() : getHeight();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        if (k()) {
            return 0;
        }
        return this.P;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        if (k()) {
            return 0;
        }
        return ((this.B - this.A) + 1) * this.N;
    }

    public final void d() {
        int i3 = this.O - this.P;
        if (i3 == 0) {
            return;
        }
        int abs = Math.abs(i3);
        int i10 = this.N;
        if (abs > i10 / 2) {
            if (i3 > 0) {
                i10 = -i10;
            }
            i3 += i10;
        }
        boolean k10 = k();
        h hVar = this.R;
        if (k10) {
            this.S = 0;
            hVar.b(i3, 0, 800);
        } else {
            this.T = 0;
            hVar.b(0, i3, 800);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19 || keyCode == 20) {
            int action = keyEvent.getAction();
            if (action == 0) {
                if (!this.f11511g0) {
                    if (keyCode == 20) {
                    }
                }
                requestFocus();
                this.f11502c1 = keyCode;
                q();
                if (this.Q.f3492p) {
                    a(keyCode == 20);
                }
                return true;
            }
            if (action == 1 && this.f11502c1 == keyCode) {
                this.f11502c1 = -1;
                return true;
            }
        } else if (keyCode == 23 || keyCode == 66) {
            q();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            q();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            q();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.i0;
        if (drawable != null && drawable.isStateful() && this.i0.setState(getDrawableState())) {
            invalidateDrawable(this.i0);
        }
    }

    public final void e(int i3) {
        if (k()) {
            this.S = 0;
            if (i3 > 0) {
                this.Q.a(0, 0, i3, 0, SubsamplingScaleImageView.TILE_SIZE_AUTO, 0);
            } else {
                this.Q.a(SubsamplingScaleImageView.TILE_SIZE_AUTO, 0, i3, 0, SubsamplingScaleImageView.TILE_SIZE_AUTO, 0);
            }
        } else {
            this.T = 0;
            if (i3 > 0) {
                this.Q.a(0, 0, 0, i3, 0, SubsamplingScaleImageView.TILE_SIZE_AUTO);
            } else {
                this.Q.a(0, SubsamplingScaleImageView.TILE_SIZE_AUTO, 0, i3, 0, SubsamplingScaleImageView.TILE_SIZE_AUTO);
            }
        }
        invalidate();
    }

    public final String f(int i3) {
        c cVar = this.F;
        if (cVar != null) {
            return cVar.a(i3);
        }
        return i3 + "";
    }

    public final float g(boolean z5) {
        if (z5 && this.f11512g1) {
            return this.f11515h1;
        }
        return 0.0f;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return g(!k());
    }

    public String[] getDisplayedValues() {
        return this.f11541z;
    }

    public int getDividerColor() {
        return this.f11519j0;
    }

    public float getDividerDistance() {
        return this.f11522k0 / getResources().getDisplayMetrics().density;
    }

    public float getDividerThickness() {
        return this.V0 / getResources().getDisplayMetrics().density;
    }

    public float getFadingEdgeStrength() {
        return this.f11515h1;
    }

    public c getFormatter() {
        return this.F;
    }

    public String getLabel() {
        return this.f11494a;
    }

    @Override // android.view.View
    public float getLeftFadingEdgeStrength() {
        return g(k());
    }

    public float getLineSpacingMultiplier() {
        return this.f11520j1;
    }

    public int getMaxFlingVelocityCoefficient() {
        return this.f11523k1;
    }

    public int getMaxValue() {
        return this.B;
    }

    public int getMinValue() {
        return this.A;
    }

    public int getOrder() {
        return this.f1;
    }

    @Override // android.widget.LinearLayout
    public int getOrientation() {
        return this.f11507e1;
    }

    @Override // android.view.View
    public float getRightFadingEdgeStrength() {
        return g(k());
    }

    public int getSelectedTextAlign() {
        return this.f11524l;
    }

    public int getSelectedTextColor() {
        return this.f11526m;
    }

    public float getSelectedTextSize() {
        return this.f11528n;
    }

    public boolean getSelectedTextStrikeThru() {
        return this.f11530o;
    }

    public boolean getSelectedTextUnderline() {
        return this.f11532p;
    }

    public int getTextAlign() {
        return this.r;
    }

    public int getTextColor() {
        return this.f11534s;
    }

    public float getTextSize() {
        return TypedValue.applyDimension(2, this.f11535t, getResources().getDisplayMetrics());
    }

    public boolean getTextStrikeThru() {
        return this.f11536u;
    }

    public boolean getTextUnderline() {
        return this.f11537v;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return g(!k());
    }

    public Typeface getTypeface() {
        return this.f11538w;
    }

    public int getValue() {
        return this.C;
    }

    public int getWheelItemCount() {
        return this.I;
    }

    public boolean getWrapSelectorWheel() {
        return this.f11511g0;
    }

    public final int h(int i3) {
        int i10 = this.B;
        if (i3 > i10) {
            int i11 = this.A;
            return (((i3 - i10) % (i10 - i11)) + i11) - 1;
        }
        int i12 = this.A;
        return i3 < i12 ? (i10 - ((i12 - i3) % (i10 - i12))) + 1 : i3;
    }

    public final void i(int[] iArr) {
        int i3 = 0;
        while (i3 < iArr.length - 1) {
            int i10 = i3 + 1;
            iArr[i3] = iArr[i10];
            i3 = i10;
        }
        int i11 = iArr[iArr.length - 2] + 1;
        if (this.f11511g0 && i11 > this.B) {
            i11 = this.A;
        }
        iArr[iArr.length - 1] = i11;
        c(i11);
    }

    public final void j() {
        this.H.clear();
        int[] selectorIndices = getSelectorIndices();
        int value = getValue();
        for (int i3 = 0; i3 < selectorIndices.length; i3++) {
            int i10 = (i3 - this.K) + value;
            if (this.f11511g0) {
                i10 = h(i10);
            }
            selectorIndices[i3] = i10;
            c(i10);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.i0;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final boolean k() {
        return getOrientation() == 0;
    }

    public final boolean m(h hVar) {
        hVar.f3492p = true;
        if (k()) {
            int i3 = hVar.e - hVar.f3485i;
            int i10 = this.O - ((this.P + i3) % this.N);
            if (i10 != 0) {
                int abs = Math.abs(i10);
                int i11 = this.N;
                if (abs > i11 / 2) {
                    i10 = i10 > 0 ? i10 - i11 : i10 + i11;
                }
                scrollBy(i3 + i10, 0);
                return true;
            }
        } else {
            int i12 = hVar.f3482f - hVar.f3486j;
            int i13 = this.O - ((this.P + i12) % this.N);
            if (i13 != 0) {
                int abs2 = Math.abs(i13);
                int i14 = this.N;
                if (abs2 > i14 / 2) {
                    i13 = i13 > 0 ? i13 - i14 : i13 + i14;
                }
                scrollBy(0, i12 + i13);
                return true;
            }
        }
        return false;
    }

    public final void n(int i3) {
        if (this.f11499b1 == i3) {
            return;
        }
        this.f11499b1 = i3;
    }

    public final void o(h hVar) {
        if (hVar == this.Q) {
            d();
            v();
            n(0);
        } else if (this.f11499b1 != 1) {
            v();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        NumberFormat.getInstance();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas canvas) {
        float right;
        float f2;
        int right2;
        int i3;
        int i10;
        int bottom;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        String replace;
        float f10;
        int i16;
        int i17;
        canvas.save();
        int i18 = 1;
        int i19 = 0;
        boolean z5 = !this.f11505d1 || hasFocus();
        boolean k10 = k();
        EditText editText = this.f11503d;
        float f11 = 2.0f;
        if (k10) {
            right = this.P;
            f2 = editText.getTop() + editText.getBaseline();
            if (this.J < 3) {
                canvas.clipRect(this.Y0, 0, this.Z0, getBottom());
            }
        } else {
            right = (getRight() - getLeft()) / 2.0f;
            f2 = this.P;
            if (this.J < 3) {
                canvas.clipRect(0, this.W0, getRight(), this.X0);
            }
        }
        int[] selectorIndices = getSelectorIndices();
        int i20 = 0;
        while (i20 < selectorIndices.length) {
            String str = (String) this.H.get(selectorIndices[getOrder() == 0 ? i20 : (selectorIndices.length - i20) - i18]);
            int i21 = this.K;
            Paint paint = this.M;
            if (i20 == i21) {
                paint.setTextAlign(Paint.Align.values()[this.f11524l]);
                paint.setTextSize(this.f11528n);
                paint.setColor(this.f11526m);
                paint.setFakeBoldText(this.f11500c);
                paint.setStrikeThruText(this.f11530o);
                paint.setUnderlineText(this.f11532p);
                paint.setTypeface(this.f11533q);
                replace = str + this.f11494a;
            } else {
                paint.setTextAlign(Paint.Align.values()[this.r]);
                paint.setTextSize(this.f11535t);
                paint.setColor(this.f11534s);
                paint.setFakeBoldText(this.f11497b);
                paint.setStrikeThruText(this.f11536u);
                paint.setUnderlineText(this.f11537v);
                paint.setTypeface(this.f11538w);
                replace = str.replace(this.f11494a, "");
            }
            if (replace != null) {
                if ((z5 && i20 != this.K) || (i20 == this.K && editText.getVisibility() != 0)) {
                    if (k()) {
                        f10 = f2;
                    } else {
                        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                        f10 = (fontMetrics == null ? 0.0f : Math.abs(fontMetrics.top + fontMetrics.bottom) / f11) + f2;
                    }
                    if (i20 == this.K || this.f11531o1 == 0) {
                        i16 = i19;
                        i17 = i16;
                    } else if (k()) {
                        i16 = i20 > this.K ? this.f11531o1 : -this.f11531o1;
                        i17 = i19;
                    } else {
                        i17 = i20 > this.K ? this.f11531o1 : -this.f11531o1;
                        i16 = i19;
                    }
                    float f12 = i16 + right;
                    float f13 = f10 + i17;
                    if (replace.contains("\n")) {
                        String[] split = replace.split("\n");
                        float abs = Math.abs(paint.ascent() + paint.descent()) * this.f11520j1;
                        float length = f13 - (((split.length - i18) * abs) / f11);
                        for (String str2 : split) {
                            canvas.drawText(str2, f12, length, paint);
                            length += abs;
                        }
                    } else {
                        canvas.drawText(replace, f12, f13, paint);
                    }
                }
                if (k()) {
                    right += this.N;
                } else {
                    f2 += this.N;
                }
            }
            i20++;
            i18 = 1;
            i19 = 0;
            f11 = 2.0f;
        }
        canvas.restore();
        if (!z5 || this.i0 == null) {
            return;
        }
        boolean k11 = k();
        int i22 = this.U0;
        if (!k11) {
            if (i22 <= 0 || i22 > (i10 = this.f11518j)) {
                right2 = getRight();
                i3 = 0;
            } else {
                i3 = (i10 - i22) / 2;
                right2 = i22 + i3;
            }
            int i23 = this.f11496a1;
            if (i23 != 0) {
                if (i23 != 1) {
                    return;
                }
                int i24 = this.X0;
                this.i0.setBounds(i3, i24 - this.V0, right2, i24);
                this.i0.draw(canvas);
                return;
            }
            int i25 = this.W0;
            this.i0.setBounds(i3, i25, right2, this.V0 + i25);
            this.i0.draw(canvas);
            int i26 = this.X0;
            this.i0.setBounds(i3, i26 - this.V0, right2, i26);
            this.i0.draw(canvas);
            return;
        }
        int i27 = this.f11496a1;
        if (i27 != 0) {
            if (i27 != 1) {
                return;
            }
            if (i22 <= 0 || i22 > (i15 = this.f11518j)) {
                i13 = this.Y0;
                i14 = this.Z0;
            } else {
                i13 = (i15 - i22) / 2;
                i14 = i22 + i13;
            }
            int i28 = this.X0;
            this.i0.setBounds(i13, i28 - this.V0, i14, i28);
            this.i0.draw(canvas);
            return;
        }
        if (i22 <= 0 || i22 > (i12 = this.f11513h)) {
            bottom = getBottom();
            i11 = 0;
        } else {
            i11 = (i12 - i22) / 2;
            bottom = i22 + i11;
        }
        int i29 = this.Y0;
        this.i0.setBounds(i29, i11, this.V0 + i29, bottom);
        this.i0.draw(canvas);
        int i30 = this.Z0;
        this.i0.setBounds(i30 - this.V0, i11, i30, bottom);
        this.i0.draw(canvas);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(NumberPicker.class.getName());
        accessibilityEvent.setScrollable(this.f11517i1);
        int i3 = this.A;
        int i10 = this.C + i3;
        int i11 = this.N;
        int i12 = i10 * i11;
        int i13 = (this.B - i3) * i11;
        if (k()) {
            accessibilityEvent.setScrollX(i12);
            accessibilityEvent.setMaxScrollX(i13);
        } else {
            accessibilityEvent.setScrollY(i12);
            accessibilityEvent.setMaxScrollY(i13);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || (motionEvent.getAction() & 255) != 0) {
            return false;
        }
        q();
        getParent().requestDisallowInterceptTouchEvent(true);
        boolean k10 = k();
        h hVar = this.Q;
        h hVar2 = this.R;
        if (k10) {
            float x10 = motionEvent.getX();
            this.V = x10;
            this.f11495a0 = x10;
            if (!hVar.f3492p) {
                hVar.f3492p = true;
                hVar2.f3492p = true;
                o(hVar);
                n(0);
                return true;
            }
            if (!hVar2.f3492p) {
                hVar.f3492p = true;
                hVar2.f3492p = true;
                o(hVar2);
                return true;
            }
            float f2 = this.Y0;
            if (x10 >= f2 && x10 <= this.Z0) {
                View.OnClickListener onClickListener = this.D;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                    return true;
                }
            } else {
                if (x10 < f2) {
                    p(false);
                    return true;
                }
                if (x10 > this.Z0) {
                    p(true);
                    return true;
                }
            }
        } else {
            float y4 = motionEvent.getY();
            this.W = y4;
            this.f11498b0 = y4;
            if (!hVar.f3492p) {
                hVar.f3492p = true;
                hVar2.f3492p = true;
                n(0);
                return true;
            }
            if (!hVar2.f3492p) {
                hVar.f3492p = true;
                hVar2.f3492p = true;
                return true;
            }
            float f10 = this.W0;
            if (y4 >= f10 && y4 <= this.X0) {
                View.OnClickListener onClickListener2 = this.D;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(this);
                    return true;
                }
            } else {
                if (y4 < f10) {
                    p(false);
                    return true;
                }
                if (y4 > this.X0) {
                    p(true);
                }
            }
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        EditText editText = this.f11503d;
        int measuredWidth2 = editText.getMeasuredWidth();
        int measuredHeight2 = editText.getMeasuredHeight();
        int i13 = (measuredWidth - measuredWidth2) / 2;
        int i14 = (measuredHeight - measuredHeight2) / 2;
        editText.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
        this.e = ((editText.getMeasuredWidth() / 2.0f) + editText.getX()) - 2.0f;
        this.f11508f = ((editText.getMeasuredHeight() / 2.0f) + editText.getY()) - 5.0f;
        if (z5) {
            j();
            int[] selectorIndices = getSelectorIndices();
            int length = (int) (((selectorIndices.length - 1) * this.f11535t) + this.f11528n);
            float length2 = selectorIndices.length;
            if (k()) {
                this.f11539x = (int) (((getRight() - getLeft()) - length) / length2);
                this.N = ((int) getMaxTextSize()) + this.f11539x;
                this.O = (int) (this.e - (r2 * this.K));
            } else {
                this.f11540y = (int) (((getBottom() - getTop()) - length) / length2);
                this.N = ((int) getMaxTextSize()) + this.f11540y;
                this.O = (int) (this.f11508f - (r2 * this.K));
            }
            this.P = this.O;
            v();
            if (k()) {
                setHorizontalFadingEdgeEnabled(true);
                setVerticalFadingEdgeEnabled(false);
                setFadingEdgeLength(((getRight() - getLeft()) - ((int) this.f11535t)) / 2);
            } else {
                setHorizontalFadingEdgeEnabled(false);
                setVerticalFadingEdgeEnabled(true);
                setFadingEdgeLength(((getBottom() - getTop()) - ((int) this.f11535t)) / 2);
            }
            int i15 = (this.V0 * 2) + this.f11522k0;
            if (!k()) {
                int height = ((getHeight() - this.f11522k0) / 2) - this.V0;
                this.W0 = height;
                this.X0 = height + i15;
            } else {
                int width = ((getWidth() - this.f11522k0) / 2) - this.V0;
                this.Y0 = width;
                this.Z0 = width + i15;
                this.X0 = getHeight();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(l(i3, this.f11518j), l(i10, this.f11513h));
        setMeasuredDimension(r(this.f11516i, getMeasuredWidth(), i3), r(this.f11510g, getMeasuredHeight(), i10));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !this.f11517i1) {
            return false;
        }
        if (this.f11501c0 == null) {
            this.f11501c0 = VelocityTracker.obtain();
        }
        this.f11501c0.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        int i3 = this.f11504d0;
        if (action != 1) {
            if (action != 2) {
                return true;
            }
            if (k()) {
                float x10 = motionEvent.getX();
                if (this.f11499b1 == 1) {
                    scrollBy((int) (x10 - this.f11495a0), 0);
                    invalidate();
                } else if (((int) Math.abs(x10 - this.V)) > i3) {
                    q();
                    n(1);
                }
                this.f11495a0 = x10;
                return true;
            }
            float y4 = motionEvent.getY();
            if (this.f11499b1 == 1) {
                scrollBy(0, (int) (y4 - this.f11498b0));
                invalidate();
            } else if (((int) Math.abs(y4 - this.W)) > i3) {
                q();
                n(1);
            }
            this.f11498b0 = y4;
            return true;
        }
        b bVar = this.U;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
        VelocityTracker velocityTracker = this.f11501c0;
        velocityTracker.computeCurrentVelocity(1000, this.f11509f0);
        boolean k10 = k();
        int i10 = this.f11506e0;
        if (k10) {
            int xVelocity = (int) velocityTracker.getXVelocity();
            if (Math.abs(xVelocity) > i10) {
                e(xVelocity);
                n(2);
            } else {
                int x11 = (int) motionEvent.getX();
                if (((int) Math.abs(x11 - this.V)) <= i3) {
                    int i11 = (x11 / this.N) - this.K;
                    if (i11 > 0) {
                        a(true);
                    } else if (i11 < 0) {
                        a(false);
                    } else {
                        d();
                    }
                } else {
                    d();
                }
                n(0);
            }
        } else {
            int yVelocity = (int) velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) > i10) {
                e(yVelocity);
                n(2);
            } else {
                int y10 = (int) motionEvent.getY();
                if (((int) Math.abs(y10 - this.W)) <= i3) {
                    int i12 = (y10 / this.N) - this.K;
                    if (i12 > 0) {
                        a(true);
                    } else if (i12 < 0) {
                        a(false);
                    } else {
                        d();
                    }
                } else {
                    d();
                }
                n(0);
            }
        }
        this.f11501c0.recycle();
        this.f11501c0 = null;
        return true;
    }

    public final void p(boolean z5) {
        long longPressTimeout = ViewConfiguration.getLongPressTimeout();
        Runnable runnable = this.U;
        if (runnable == null) {
            this.U = new b(this, 0);
        } else {
            removeCallbacks(runnable);
        }
        b bVar = this.U;
        bVar.f3467b = z5;
        postDelayed(bVar, longPressTimeout);
    }

    public final void q() {
        b bVar = this.U;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
    }

    public final void s(int i3, boolean z5) {
        e eVar;
        if (this.C == i3) {
            return;
        }
        int h4 = this.f11511g0 ? h(i3) : Math.min(Math.max(i3, this.A), this.B);
        int i10 = this.C;
        this.C = h4;
        if (this.f11499b1 != 2) {
            v();
        }
        if (z5 && (eVar = this.E) != null) {
            eVar.g(i10, h4);
        }
        j();
        if (this.f11525l1) {
            setContentDescription(String.valueOf(getValue()));
        }
        invalidate();
    }

    @Override // android.view.View
    public final void scrollBy(int i3, int i10) {
        int i11;
        if (this.f11517i1) {
            int[] selectorIndices = getSelectorIndices();
            int i12 = this.P;
            int maxTextSize = (int) getMaxTextSize();
            if (k()) {
                if (getOrder() == 0) {
                    boolean z5 = this.f11511g0;
                    if (!z5 && i3 > 0 && selectorIndices[this.K] <= this.A) {
                        this.P = this.O;
                        return;
                    } else if (!z5 && i3 < 0 && selectorIndices[this.K] >= this.B) {
                        this.P = this.O;
                        return;
                    }
                } else {
                    boolean z6 = this.f11511g0;
                    if (!z6 && i3 > 0 && selectorIndices[this.K] >= this.B) {
                        this.P = this.O;
                        return;
                    } else if (!z6 && i3 < 0 && selectorIndices[this.K] <= this.A) {
                        this.P = this.O;
                        return;
                    }
                }
                this.P += i3;
            } else {
                if (getOrder() == 0) {
                    boolean z8 = this.f11511g0;
                    if (!z8 && i10 > 0 && selectorIndices[this.K] <= this.A) {
                        this.P = this.O;
                        return;
                    } else if (!z8 && i10 < 0 && selectorIndices[this.K] >= this.B) {
                        this.P = this.O;
                        return;
                    }
                } else {
                    boolean z10 = this.f11511g0;
                    if (!z10 && i10 > 0 && selectorIndices[this.K] >= this.B) {
                        this.P = this.O;
                        return;
                    } else if (!z10 && i10 < 0 && selectorIndices[this.K] <= this.A) {
                        this.P = this.O;
                        return;
                    }
                }
                this.P += i10;
            }
            while (true) {
                int i13 = this.P;
                if (i13 - this.O <= maxTextSize) {
                    break;
                }
                this.P = i13 - this.N;
                if (getOrder() == 0) {
                    b(selectorIndices);
                } else {
                    i(selectorIndices);
                }
                s(selectorIndices[this.K], true);
                if (!this.f11511g0 && selectorIndices[this.K] < this.A) {
                    this.P = this.O;
                }
            }
            while (true) {
                i11 = this.P;
                if (i11 - this.O >= (-maxTextSize)) {
                    break;
                }
                this.P = i11 + this.N;
                if (getOrder() == 0) {
                    i(selectorIndices);
                } else {
                    b(selectorIndices);
                }
                s(selectorIndices[this.K], true);
                if (!this.f11511g0 && selectorIndices[this.K] > this.B) {
                    this.P = this.O;
                }
            }
            if (i12 != i11) {
                if (k()) {
                    onScrollChanged(this.P, 0, i12, 0);
                } else {
                    onScrollChanged(0, this.P, 0, i12);
                }
            }
        }
    }

    public void setAccessibilityDescriptionEnabled(boolean z5) {
        this.f11525l1 = z5;
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.f11541z == strArr) {
            return;
        }
        this.f11541z = strArr;
        EditText editText = this.f11503d;
        if (strArr != null) {
            editText.setRawInputType(655360);
        } else {
            editText.setRawInputType(655360);
        }
        v();
        j();
        u();
    }

    public void setDividerColor(int i3) {
        this.f11519j0 = i3;
        this.i0 = new ColorDrawable(i3);
        invalidate();
    }

    public void setDividerColorResource(int i3) {
        setDividerColor(d.a(this.f11527m1, i3));
    }

    public void setDividerDistance(int i3) {
        this.f11522k0 = i3;
    }

    public void setDividerDistanceResource(int i3) {
        setDividerDistance(getResources().getDimensionPixelSize(i3));
    }

    public void setDividerThickness(int i3) {
        this.V0 = i3;
    }

    public void setDividerThicknessResource(int i3) {
        setDividerThickness(getResources().getDimensionPixelSize(i3));
    }

    public void setDividerType(int i3) {
        this.f11496a1 = i3;
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        this.f11503d.setEnabled(z5);
    }

    public void setFadingEdgeEnabled(boolean z5) {
        this.f11512g1 = z5;
    }

    public void setFadingEdgeStrength(float f2) {
        this.f11515h1 = f2;
    }

    public void setFormatter(c cVar) {
        if (cVar == this.F) {
            return;
        }
        this.F = cVar;
        j();
        v();
    }

    public void setItemSpacing(int i3) {
        this.f11531o1 = i3;
    }

    public void setLabel(String str) {
        this.f11494a = str;
    }

    public void setLineSpacingMultiplier(float f2) {
        this.f11520j1 = f2;
    }

    public void setMaxFlingVelocityCoefficient(int i3) {
        this.f11523k1 = i3;
        this.f11509f0 = this.f11529n1.getScaledMaximumFlingVelocity() / this.f11523k1;
    }

    public void setMaxValue(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        this.B = i3;
        if (i3 < this.C) {
            this.C = i3;
        }
        w();
        j();
        v();
        u();
        invalidate();
    }

    public void setMinValue(int i3) {
        this.A = i3;
        if (i3 > this.C) {
            this.C = i3;
        }
        w();
        j();
        v();
        u();
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    public void setOnLongPressUpdateInterval(long j4) {
        this.G = j4;
    }

    public void setOnScrollListener(cf.d dVar) {
    }

    public void setOnValueChangedListener(e eVar) {
        this.E = eVar;
    }

    public void setOrder(int i3) {
        this.f1 = i3;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i3) {
        this.f11507e1 = i3;
        t();
        requestLayout();
    }

    public void setScrollerEnabled(boolean z5) {
        this.f11517i1 = z5;
    }

    public void setSelectedTextAlign(int i3) {
        this.f11524l = i3;
    }

    public void setSelectedTextBold(boolean z5) {
        this.f11500c = z5;
    }

    public void setSelectedTextColor(int i3) {
        this.f11526m = i3;
        this.f11503d.setTextColor(i3);
        invalidate();
    }

    public void setSelectedTextColorResource(int i3) {
        setSelectedTextColor(d.a(this.f11527m1, i3));
    }

    public void setSelectedTextSize(float f2) {
        this.f11528n = f2;
        this.f11503d.setTextSize(f2 / getResources().getDisplayMetrics().scaledDensity);
        invalidate();
    }

    public void setSelectedTextStrikeThru(boolean z5) {
        this.f11530o = z5;
    }

    public void setSelectedTextUnderline(boolean z5) {
        this.f11532p = z5;
    }

    public void setSelectedTypeface(Typeface typeface) {
        this.f11533q = typeface;
        Paint paint = this.M;
        if (typeface != null) {
            paint.setTypeface(typeface);
        } else {
            Typeface typeface2 = this.f11538w;
            if (typeface2 != null) {
                paint.setTypeface(typeface2);
            } else {
                paint.setTypeface(Typeface.MONOSPACE);
            }
        }
        invalidate();
    }

    public void setTextAlign(int i3) {
        this.r = i3;
    }

    public void setTextBold(boolean z5) {
        this.f11497b = z5;
    }

    public void setTextColor(int i3) {
        this.f11534s = i3;
        this.M.setColor(i3);
        invalidate();
    }

    public void setTextColorResource(int i3) {
        setTextColor(d.a(this.f11527m1, i3));
    }

    public void setTextSize(float f2) {
        this.f11535t = f2;
        this.M.setTextSize(f2);
        invalidate();
    }

    public void setTextStrikeThru(boolean z5) {
        this.f11536u = z5;
    }

    public void setTextUnderline(boolean z5) {
        this.f11537v = z5;
    }

    public void setTypeface(Typeface typeface) {
        this.f11538w = typeface;
        EditText editText = this.f11503d;
        if (typeface != null) {
            editText.setTypeface(typeface);
            setSelectedTypeface(this.f11533q);
        } else {
            editText.setTypeface(Typeface.MONOSPACE);
        }
        invalidate();
    }

    public void setValue(int i3) {
        s(i3, false);
    }

    public void setWheelItemCount(int i3) {
        if (i3 < 1) {
            throw new IllegalArgumentException("Wheel item count must be >= 1");
        }
        this.J = i3;
        int max = Math.max(i3, 3);
        this.I = max;
        this.K = max / 2;
        this.L = new int[max];
    }

    public void setWrapSelectorWheel(boolean z5) {
        this.f11514h0 = z5;
        w();
    }

    public final void t() {
        if (k()) {
            this.f11510g = -1;
            this.f11513h = (int) (58.0f * getResources().getDisplayMetrics().density);
            this.f11516i = (int) (180.0f * getResources().getDisplayMetrics().density);
            this.f11518j = -1;
            return;
        }
        this.f11510g = -1;
        this.f11513h = (int) (180.0f * getResources().getDisplayMetrics().density);
        this.f11516i = (int) (58.0f * getResources().getDisplayMetrics().density);
        this.f11518j = -1;
    }

    public final void u() {
        int i3;
        if (this.f11521k) {
            float maxTextSize = getMaxTextSize();
            Paint paint = this.M;
            paint.setTextSize(maxTextSize);
            String[] strArr = this.f11541z;
            int i10 = 0;
            if (strArr == null) {
                float f2 = 0.0f;
                for (int i11 = 0; i11 <= 9; i11++) {
                    float measureText = paint.measureText(f(i11));
                    if (measureText > f2) {
                        f2 = measureText;
                    }
                }
                for (int i12 = this.B; i12 > 0; i12 /= 10) {
                    i10++;
                }
                i3 = (int) (i10 * f2);
            } else {
                int length = strArr.length;
                int i13 = 0;
                while (i10 < length) {
                    float measureText2 = paint.measureText(strArr[i10]);
                    if (measureText2 > i13) {
                        i13 = (int) measureText2;
                    }
                    i10++;
                }
                i3 = i13;
            }
            EditText editText = this.f11503d;
            int paddingRight = editText.getPaddingRight() + editText.getPaddingLeft() + i3;
            if (this.f11518j != paddingRight) {
                this.f11518j = Math.max(paddingRight, this.f11516i);
                invalidate();
            }
        }
    }

    public final void v() {
        String[] strArr = this.f11541z;
        String f2 = strArr == null ? f(this.C) : strArr[this.C - this.A];
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        EditText editText = this.f11503d;
        if (f2.equals(editText.getText().toString())) {
            return;
        }
        StringBuilder t8 = l0.t(f2);
        t8.append(this.f11494a);
        editText.setText(t8.toString());
    }

    public final void w() {
        this.f11511g0 = this.B - this.A >= this.L.length - 1 && this.f11514h0;
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumberPicker(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        this.f11494a = "";
        this.f11497b = true;
        this.f11500c = true;
        this.f11524l = 1;
        this.f11526m = -16777216;
        this.f11528n = 15.0f;
        this.r = 1;
        this.f11534s = -16777216;
        this.f11535t = 15.0f;
        this.A = 1;
        this.B = 100;
        this.G = 300L;
        this.H = new SparseArray();
        this.I = 3;
        this.J = 3;
        this.K = 1;
        this.L = new int[3];
        this.O = Integer.MIN_VALUE;
        this.f11514h0 = true;
        this.f11519j0 = -16777216;
        this.f11499b1 = 0;
        this.f11502c1 = -1;
        this.f11512g1 = true;
        this.f11515h1 = 0.9f;
        this.f11517i1 = true;
        this.f11520j1 = 1.0f;
        this.f11523k1 = 8;
        this.f11525l1 = true;
        this.f11531o1 = 0;
        this.f11527m1 = context;
        NumberFormat.getInstance();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NumberPicker, i3, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.NumberPicker_np_divider);
        if (drawable != null) {
            drawable.setCallback(this);
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
            this.i0 = drawable;
        } else {
            int color = obtainStyledAttributes.getColor(R$styleable.NumberPicker_np_dividerColor, this.f11519j0);
            this.f11519j0 = color;
            setDividerColor(color);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int applyDimension = (int) TypedValue.applyDimension(1, 48.0f, displayMetrics);
        int applyDimension2 = (int) TypedValue.applyDimension(1, 2.0f, displayMetrics);
        this.f11522k0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NumberPicker_np_dividerDistance, applyDimension);
        this.U0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NumberPicker_np_dividerLength, 0);
        this.V0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NumberPicker_np_dividerThickness, applyDimension2);
        this.f11496a1 = obtainStyledAttributes.getInt(R$styleable.NumberPicker_np_dividerType, 0);
        this.f1 = obtainStyledAttributes.getInt(R$styleable.NumberPicker_np_order, 0);
        this.f11507e1 = obtainStyledAttributes.getInt(R$styleable.NumberPicker_np_orientation, 1);
        float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NumberPicker_np_width, -1);
        float dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NumberPicker_np_height, -1);
        t();
        this.f11521k = true;
        this.C = obtainStyledAttributes.getInt(R$styleable.NumberPicker_np_value, this.C);
        this.B = obtainStyledAttributes.getInt(R$styleable.NumberPicker_np_max, this.B);
        this.A = obtainStyledAttributes.getInt(R$styleable.NumberPicker_np_min, this.A);
        this.f11524l = obtainStyledAttributes.getInt(R$styleable.NumberPicker_np_selectedTextAlign, this.f11524l);
        this.f11526m = obtainStyledAttributes.getColor(R$styleable.NumberPicker_np_selectedTextColor, this.f11526m);
        this.f11528n = obtainStyledAttributes.getDimension(R$styleable.NumberPicker_np_selectedTextSize, TypedValue.applyDimension(2, this.f11528n, getResources().getDisplayMetrics()));
        this.f11530o = obtainStyledAttributes.getBoolean(R$styleable.NumberPicker_np_selectedTextStrikeThru, this.f11530o);
        this.f11532p = obtainStyledAttributes.getBoolean(R$styleable.NumberPicker_np_selectedTextUnderline, this.f11532p);
        this.f11533q = Typeface.create(obtainStyledAttributes.getString(R$styleable.NumberPicker_np_selectedTypeface), 0);
        this.r = obtainStyledAttributes.getInt(R$styleable.NumberPicker_np_textAlign, this.r);
        this.f11534s = obtainStyledAttributes.getColor(R$styleable.NumberPicker_np_textColor, this.f11534s);
        this.f11535t = obtainStyledAttributes.getDimension(R$styleable.NumberPicker_np_textSize, TypedValue.applyDimension(2, this.f11535t, getResources().getDisplayMetrics()));
        this.f11536u = obtainStyledAttributes.getBoolean(R$styleable.NumberPicker_np_textStrikeThru, this.f11536u);
        this.f11537v = obtainStyledAttributes.getBoolean(R$styleable.NumberPicker_np_textUnderline, this.f11537v);
        this.f11538w = Typeface.create(obtainStyledAttributes.getString(R$styleable.NumberPicker_np_typeface), 0);
        String string = obtainStyledAttributes.getString(R$styleable.NumberPicker_np_formatter);
        this.F = TextUtils.isEmpty(string) ? null : new a(string);
        this.f11512g1 = obtainStyledAttributes.getBoolean(R$styleable.NumberPicker_np_fadingEdgeEnabled, this.f11512g1);
        this.f11515h1 = obtainStyledAttributes.getFloat(R$styleable.NumberPicker_np_fadingEdgeStrength, this.f11515h1);
        this.f11517i1 = obtainStyledAttributes.getBoolean(R$styleable.NumberPicker_np_scrollerEnabled, this.f11517i1);
        this.I = obtainStyledAttributes.getInt(R$styleable.NumberPicker_np_wheelItemCount, this.I);
        this.f11520j1 = obtainStyledAttributes.getFloat(R$styleable.NumberPicker_np_lineSpacingMultiplier, this.f11520j1);
        this.f11523k1 = obtainStyledAttributes.getInt(R$styleable.NumberPicker_np_maxFlingVelocityCoefficient, this.f11523k1);
        this.f11505d1 = obtainStyledAttributes.getBoolean(R$styleable.NumberPicker_np_hideWheelUntilFocused, false);
        this.f11525l1 = obtainStyledAttributes.getBoolean(R$styleable.NumberPicker_np_accessibilityDescriptionEnabled, true);
        this.f11531o1 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NumberPicker_np_itemSpacing, 0);
        this.f11497b = obtainStyledAttributes.getBoolean(R$styleable.NumberPicker_np_textBold, this.f11497b);
        this.f11500c = obtainStyledAttributes.getBoolean(R$styleable.NumberPicker_np_selectedTextBold, this.f11500c);
        setWillNotDraw(false);
        EditText editText = new EditText(context);
        this.f11503d = editText;
        editText.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        editText.setGravity(17);
        editText.setSingleLine(true);
        editText.setImportantForAccessibility(2);
        editText.setEnabled(false);
        editText.setFocusable(false);
        editText.setVisibility(4);
        editText.setImeOptions(1);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        this.M = paint;
        setSelectedTextColor(this.f11526m);
        setTextColor(this.f11534s);
        setTextSize(this.f11535t);
        setSelectedTextSize(this.f11528n);
        setTypeface(this.f11538w);
        setSelectedTypeface(this.f11533q);
        setFormatter(this.F);
        v();
        setValue(this.C);
        setMaxValue(this.B);
        setMinValue(this.A);
        setWheelItemCount(this.I);
        boolean z5 = obtainStyledAttributes.getBoolean(R$styleable.NumberPicker_np_wrapSelectorWheel, this.f11511g0);
        this.f11511g0 = z5;
        setWrapSelectorWheel(z5);
        if (dimensionPixelSize != -1.0f && dimensionPixelSize2 != -1.0f) {
            setScaleX(dimensionPixelSize / this.f11516i);
            setScaleY(dimensionPixelSize2 / this.f11513h);
        } else if (dimensionPixelSize != -1.0f) {
            float f2 = dimensionPixelSize / this.f11516i;
            setScaleX(f2);
            setScaleY(f2);
        } else if (dimensionPixelSize2 != -1.0f) {
            float f10 = dimensionPixelSize2 / this.f11513h;
            setScaleX(f10);
            setScaleY(f10);
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f11529n1 = viewConfiguration;
        this.f11504d0 = viewConfiguration.getScaledTouchSlop();
        this.f11506e0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f11509f0 = viewConfiguration.getScaledMaximumFlingVelocity() / this.f11523k1;
        this.Q = new h(context, null, true);
        this.R = new h(context, new DecelerateInterpolator(2.5f), context.getApplicationInfo().targetSdkVersion >= 11);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        if (getFocusable() == 16) {
            setFocusable(1);
            setFocusableInTouchMode(true);
        }
        obtainStyledAttributes.recycle();
    }

    public void setTextSize(int i3) {
        setTextSize(getResources().getDimension(i3));
    }

    public void setFormatter(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setFormatter(TextUtils.isEmpty(str) ? null : new a(str));
    }

    public void setSelectedTextSize(int i3) {
        setSelectedTextSize(getResources().getDimension(i3));
    }

    public void setTypeface(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setTypeface(Typeface.create(str, 0));
    }

    public void setSelectedTypeface(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setSelectedTypeface(Typeface.create(str, 0));
    }

    public void setFormatter(int i3) {
        setFormatter(getResources().getString(i3));
    }

    public void setTypeface(int i3) {
        String string = getResources().getString(i3);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        setTypeface(Typeface.create(string, 0));
    }

    public void setSelectedTypeface(int i3) {
        String string = getResources().getString(i3);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        setSelectedTypeface(Typeface.create(string, 0));
    }
}
