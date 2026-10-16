package com.google.android.material.slider;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.qb;
import com.google.android.gms.internal.mlkit_vision_barcode.rb;
import com.google.android.gms.internal.mlkit_vision_barcode.s0;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.s;
import com.google.android.material.internal.w;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.a;
import com.google.android.material.slider.b;
import eb.l;
import eb.m;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import l1.i0;
import l1.k0;
import l1.z0;

/* loaded from: classes.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends a, T extends b> extends View {

    /* renamed from: a0, reason: collision with root package name */
    public static final int f10727a0 = R$style.Widget_MaterialComponents_Slider;
    public final int A;
    public float B;
    public MotionEvent C;
    public boolean D;
    public float E;
    public float F;
    public ArrayList G;
    public int H;
    public int I;
    public float J;
    public float[] K;
    public boolean L;
    public int M;
    public boolean N;
    public boolean O;
    public ColorStateList P;
    public ColorStateList Q;
    public ColorStateList R;
    public ColorStateList S;
    public ColorStateList T;
    public final eb.h U;
    public float V;
    public int W;

    /* renamed from: a, reason: collision with root package name */
    public final Paint f10728a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f10729b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f10730c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f10731d;
    public final Paint e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f10732f;

    /* renamed from: g, reason: collision with root package name */
    public final g f10733g;

    /* renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f10734h;

    /* renamed from: i, reason: collision with root package name */
    public f f10735i;

    /* renamed from: j, reason: collision with root package name */
    public final c f10736j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f10737k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f10738l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f10739m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10740n;

    /* renamed from: o, reason: collision with root package name */
    public ValueAnimator f10741o;

    /* renamed from: p, reason: collision with root package name */
    public ValueAnimator f10742p;

    /* renamed from: q, reason: collision with root package name */
    public final int f10743q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public final int f10744s;

    /* renamed from: t, reason: collision with root package name */
    public final int f10745t;

    /* renamed from: u, reason: collision with root package name */
    public int f10746u;

    /* renamed from: v, reason: collision with root package name */
    public int f10747v;

    /* renamed from: w, reason: collision with root package name */
    public int f10748w;

    /* renamed from: x, reason: collision with root package name */
    public final int f10749x;

    /* renamed from: y, reason: collision with root package name */
    public int f10750y;

    /* renamed from: z, reason: collision with root package name */
    public int f10751z;

    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new h();

        /* renamed from: a, reason: collision with root package name */
        public float f10752a;

        /* renamed from: b, reason: collision with root package name */
        public float f10753b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f10754c;

        /* renamed from: d, reason: collision with root package name */
        public float f10755d;
        public boolean e;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeFloat(this.f10752a);
            parcel.writeFloat(this.f10753b);
            parcel.writeList(this.f10754c);
            parcel.writeFloat(this.f10755d);
            parcel.writeBooleanArray(new boolean[]{this.e});
        }
    }

    public BaseSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.sliderStyle);
    }

    public final int a() {
        return this.f10749x + (this.f10746u == 1 ? ((jb.a) this.f10737k.get(0)).getIntrinsicHeight() : 0);
    }

    public void addOnChangeListener(L l3) {
        this.f10738l.add(l3);
    }

    public void addOnSliderTouchListener(T t8) {
        this.f10739m.add(t8);
    }

    public final ValueAnimator b(boolean z5) {
        float f2 = z5 ? 0.0f : 1.0f;
        ValueAnimator valueAnimator = z5 ? this.f10742p : this.f10741o;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            f2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, z5 ? 1.0f : 0.0f);
        ofFloat.setDuration(z5 ? 83L : 117L);
        ofFloat.setInterpolator(z5 ? ja.a.e : ja.a.f15385c);
        ofFloat.addUpdateListener(new d(this));
        return ofFloat;
    }

    public final void c() {
        ArrayList arrayList = this.f10738l;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            if (obj != null) {
                throw new ClassCastException();
            }
            Iterator it = this.G.iterator();
            if (it.hasNext()) {
                ((Float) it.next()).getClass();
                throw null;
            }
        }
    }

    public final void d() {
        if (this.f10740n) {
            this.f10740n = false;
            ValueAnimator b3 = b(false);
            this.f10742p = b3;
            this.f10741o = null;
            b3.addListener(new e(this));
            this.f10742p.start();
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f10733g.m(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.f10728a.setColor(g(this.T));
        this.f10729b.setColor(g(this.S));
        this.e.setColor(g(this.R));
        this.f10732f.setColor(g(this.Q));
        ArrayList arrayList = this.f10737k;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            jb.a aVar = (jb.a) obj;
            if (aVar.isStateful()) {
                aVar.setState(getDrawableState());
            }
        }
        eb.h hVar = this.U;
        if (hVar.isStateful()) {
            hVar.setState(getDrawableState());
        }
        Paint paint = this.f10731d;
        paint.setColor(g(this.P));
        paint.setAlpha(63);
    }

    public final String e(float f2) {
        return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", Float.valueOf(f2));
    }

    public final float[] f() {
        float floatValue = ((Float) Collections.max(getValues())).floatValue();
        float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.G.size() == 1) {
            floatValue2 = this.E;
        }
        float m10 = m(floatValue2);
        float m11 = m(floatValue);
        return i() ? new float[]{m11, m10} : new float[]{m10, m11};
    }

    public final int g(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f10733g.f17361k;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getValueFrom() {
        return this.E;
    }

    public float getValueTo() {
        return this.F;
    }

    public List<Float> getValues() {
        return new ArrayList(this.G);
    }

    public final boolean h() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public final boolean i() {
        WeakHashMap weakHashMap = z0.f15748a;
        return i0.d(this) == 1;
    }

    public final void j() {
        if (this.J <= 0.0f) {
            return;
        }
        v();
        int min = Math.min((int) (((this.F - this.E) / this.J) + 1.0f), (this.M / (this.f10747v * 2)) + 1);
        float[] fArr = this.K;
        if (fArr == null || fArr.length != min * 2) {
            this.K = new float[min * 2];
        }
        float f2 = this.M / (min - 1);
        for (int i3 = 0; i3 < min * 2; i3 += 2) {
            float[] fArr2 = this.K;
            fArr2[i3] = ((i3 / 2) * f2) + this.f10748w;
            fArr2[i3 + 1] = a();
        }
    }

    public final boolean k(int i3) {
        int i10 = this.I;
        long j4 = i10 + i3;
        long size = this.G.size() - 1;
        if (j4 < 0) {
            j4 = 0;
        } else if (j4 > size) {
            j4 = size;
        }
        int i11 = (int) j4;
        this.I = i11;
        if (i11 == i10) {
            return false;
        }
        if (this.H != -1) {
            this.H = i11;
        }
        u();
        postInvalidate();
        return true;
    }

    public final void l(int i3) {
        if (i()) {
            i3 = i3 == Integer.MIN_VALUE ? SubsamplingScaleImageView.TILE_SIZE_AUTO : -i3;
        }
        k(i3);
    }

    public final float m(float f2) {
        float f10 = this.E;
        float f11 = (f2 - f10) / (this.F - f10);
        return i() ? 1.0f - f11 : f11;
    }

    public final void n() {
        Iterator it = this.f10739m.iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.session.e.d(it);
        }
    }

    public boolean o() {
        if (this.H == -1) {
            float f2 = this.V;
            if (i()) {
                f2 = 1.0f - f2;
            }
            float f10 = this.F;
            float f11 = this.E;
            float a3 = l0.a(f10, f11, f2, f11);
            float m10 = (m(a3) * this.M) + this.f10748w;
            this.H = 0;
            float abs = Math.abs(((Float) this.G.get(0)).floatValue() - a3);
            for (int i3 = 1; i3 < this.G.size(); i3++) {
                float abs2 = Math.abs(((Float) this.G.get(i3)).floatValue() - a3);
                float m11 = (m(((Float) this.G.get(i3)).floatValue()) * this.M) + this.f10748w;
                if (Float.compare(abs2, abs) > 1) {
                    break;
                }
                boolean z5 = !i() ? m11 - m10 >= 0.0f : m11 - m10 <= 0.0f;
                if (Float.compare(abs2, abs) < 0) {
                    this.H = i3;
                } else {
                    if (Float.compare(abs2, abs) != 0) {
                        continue;
                    } else {
                        if (Math.abs(m11 - m10) < this.f10743q) {
                            this.H = -1;
                            return false;
                        }
                        if (z5) {
                            this.H = i3;
                        }
                    }
                }
                abs = abs2;
            }
            if (this.H == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ArrayList arrayList = this.f10737k;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            jb.a aVar = (jb.a) obj;
            ViewGroup c9 = gb.c(this);
            if (c9 == null) {
                aVar.getClass();
            } else {
                aVar.getClass();
                int[] iArr = new int[2];
                c9.getLocationOnScreen(iArr);
                aVar.I = iArr[0];
                c9.getWindowVisibleDisplayFrame(aVar.C);
                c9.addOnLayoutChangeListener(aVar.B);
            }
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        f fVar = this.f10735i;
        if (fVar != null) {
            removeCallbacks(fVar);
        }
        int i3 = 0;
        this.f10740n = false;
        ArrayList arrayList = this.f10737k;
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            jb.a aVar = (jb.a) obj;
            ViewGroup c9 = gb.c(this);
            com.example.test.ui.device.activity.i0 i0Var = c9 == null ? null : new com.example.test.ui.device.activity.i0(c9);
            if (i0Var != null) {
                ((ViewOverlay) i0Var.f7866b).remove(aVar);
                ViewGroup c10 = gb.c(this);
                if (c10 == null) {
                    aVar.getClass();
                } else {
                    c10.removeOnLayoutChangeListener(aVar.B);
                }
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.O) {
            v();
            j();
        }
        super.onDraw(canvas);
        int a3 = a();
        int i3 = this.M;
        float[] f2 = f();
        int i10 = this.f10748w;
        float f10 = i3;
        float f11 = (f2[1] * f10) + i10;
        float f12 = i10 + i3;
        Paint paint = this.f10728a;
        if (f11 < f12) {
            float f13 = a3;
            canvas.drawLine(f11, f13, f12, f13, paint);
        }
        float f14 = this.f10748w;
        int i11 = 0;
        float f15 = (f2[0] * f10) + f14;
        if (f15 > f14) {
            float f16 = a3;
            canvas.drawLine(f14, f16, f15, f16, paint);
        }
        if (((Float) Collections.max(getValues())).floatValue() > this.E) {
            int i12 = this.M;
            float[] f17 = f();
            float f18 = this.f10748w;
            float f19 = i12;
            float f20 = (f17[1] * f19) + f18;
            float f21 = (f17[0] * f19) + f18;
            float f22 = a3;
            canvas.drawLine(f21, f22, f20, f22, this.f10729b);
        }
        if (this.L && this.J > 0.0f) {
            float[] f23 = f();
            int round = Math.round(f23[0] * ((this.K.length / 2) - 1));
            int round2 = Math.round(f23[1] * ((this.K.length / 2) - 1));
            float[] fArr = this.K;
            int i13 = round * 2;
            Paint paint2 = this.e;
            canvas.drawPoints(fArr, 0, i13, paint2);
            int i14 = round2 * 2;
            canvas.drawPoints(this.K, i13, i14 - i13, this.f10732f);
            float[] fArr2 = this.K;
            canvas.drawPoints(fArr2, i14, fArr2.length - i14, paint2);
        }
        if ((this.D || isFocused()) && isEnabled()) {
            int i15 = this.M;
            if (!(getBackground() instanceof RippleDrawable)) {
                int m10 = (int) ((m(((Float) this.G.get(this.I)).floatValue()) * i15) + this.f10748w);
                if (Build.VERSION.SDK_INT < 28) {
                    int i16 = this.f10751z;
                    canvas.clipRect(m10 - i16, a3 - i16, m10 + i16, i16 + a3, Region.Op.UNION);
                }
                canvas.drawCircle(m10, a3, this.f10751z, this.f10731d);
            }
            if (this.H != -1 && this.f10746u != 2) {
                if (!this.f10740n) {
                    this.f10740n = true;
                    ValueAnimator b3 = b(true);
                    this.f10741o = b3;
                    this.f10742p = null;
                    b3.start();
                }
                ArrayList arrayList = this.f10737k;
                Iterator it = arrayList.iterator();
                for (int i17 = 0; i17 < this.G.size() && it.hasNext(); i17++) {
                    if (i17 != this.I) {
                        p((jb.a) it.next(), ((Float) this.G.get(i17)).floatValue());
                    }
                }
                if (!it.hasNext()) {
                    throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(arrayList.size()), Integer.valueOf(this.G.size())));
                }
                p((jb.a) it.next(), ((Float) this.G.get(this.I)).floatValue());
            }
        }
        int i18 = this.M;
        if (!isEnabled()) {
            ArrayList arrayList2 = this.G;
            int size = arrayList2.size();
            int i19 = 0;
            while (i19 < size) {
                Object obj = arrayList2.get(i19);
                i19++;
                canvas.drawCircle((m(((Float) obj).floatValue()) * i18) + this.f10748w, a3, this.f10750y, this.f10730c);
            }
        }
        ArrayList arrayList3 = this.G;
        int size2 = arrayList3.size();
        while (i11 < size2) {
            Object obj2 = arrayList3.get(i11);
            i11++;
            canvas.save();
            int m11 = this.f10748w + ((int) (m(((Float) obj2).floatValue()) * i18));
            int i20 = this.f10750y;
            canvas.translate(m11 - i20, a3 - i20);
            this.U.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z5, int i3, Rect rect) {
        super.onFocusChanged(z5, i3, rect);
        g gVar = this.f10733g;
        if (!z5) {
            this.H = -1;
            d();
            gVar.j(this.I);
            return;
        }
        if (i3 == 1) {
            k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        } else if (i3 == 2) {
            k(Integer.MIN_VALUE);
        } else if (i3 == 17) {
            l(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        } else if (i3 == 66) {
            l(Integer.MIN_VALUE);
        }
        gVar.w(this.I);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i3, keyEvent);
        }
        if (this.G.size() == 1) {
            this.H = 0;
        }
        Float f2 = null;
        Boolean valueOf = null;
        if (this.H == -1) {
            if (i3 != 61) {
                if (i3 != 66) {
                    if (i3 != 81) {
                        if (i3 == 69) {
                            k(-1);
                            valueOf = Boolean.TRUE;
                        } else if (i3 != 70) {
                            switch (i3) {
                                case 21:
                                    l(-1);
                                    valueOf = Boolean.TRUE;
                                    break;
                                case 22:
                                    l(1);
                                    valueOf = Boolean.TRUE;
                                    break;
                            }
                        }
                    }
                    k(1);
                    valueOf = Boolean.TRUE;
                }
                this.H = this.I;
                postInvalidate();
                valueOf = Boolean.TRUE;
            } else {
                valueOf = keyEvent.hasNoModifiers() ? Boolean.valueOf(k(1)) : keyEvent.isShiftPressed() ? Boolean.valueOf(k(-1)) : Boolean.FALSE;
            }
            return valueOf != null ? valueOf.booleanValue() : super.onKeyDown(i3, keyEvent);
        }
        boolean isLongPress = this.N | keyEvent.isLongPress();
        this.N = isLongPress;
        if (isLongPress) {
            float f10 = this.J;
            r10 = f10 != 0.0f ? f10 : 1.0f;
            if ((this.F - this.E) / r10 > 20) {
                r10 *= Math.round(r0 / r11);
            }
        } else {
            float f11 = this.J;
            if (f11 != 0.0f) {
                r10 = f11;
            }
        }
        if (i3 == 21) {
            if (!i()) {
                r10 = -r10;
            }
            f2 = Float.valueOf(r10);
        } else if (i3 == 22) {
            if (i()) {
                r10 = -r10;
            }
            f2 = Float.valueOf(r10);
        } else if (i3 == 69) {
            f2 = Float.valueOf(-r10);
        } else if (i3 == 70 || i3 == 81) {
            f2 = Float.valueOf(r10);
        }
        if (f2 != null) {
            if (r(f2.floatValue() + ((Float) this.G.get(this.H)).floatValue(), this.H)) {
                u();
                postInvalidate();
            }
            return true;
        }
        if (i3 != 23) {
            if (i3 == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return k(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return k(-1);
                }
                return false;
            }
            if (i3 != 66) {
                return super.onKeyDown(i3, keyEvent);
            }
        }
        this.H = -1;
        d();
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        this.N = false;
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.f10745t + (this.f10746u == 1 ? ((jb.a) this.f10737k.get(0)).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.E = sliderState.f10752a;
        this.F = sliderState.f10753b;
        q(sliderState.f10754c);
        this.J = sliderState.f10755d;
        if (sliderState.e) {
            requestFocus();
        }
        c();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f10752a = this.E;
        sliderState.f10753b = this.F;
        sliderState.f10754c = new ArrayList(this.G);
        sliderState.f10755d = this.J;
        sliderState.e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i10, int i11, int i12) {
        this.M = Math.max(i3 - (this.f10748w * 2), 0);
        j();
        u();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            float x10 = motionEvent.getX();
            float f2 = (x10 - this.f10748w) / this.M;
            this.V = f2;
            float max = Math.max(0.0f, f2);
            this.V = max;
            this.V = Math.min(1.0f, max);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                int i3 = this.f10743q;
                if (actionMasked == 1) {
                    this.D = false;
                    MotionEvent motionEvent2 = this.C;
                    if (motionEvent2 != null && motionEvent2.getActionMasked() == 0) {
                        float f10 = i3;
                        if (Math.abs(this.C.getX() - motionEvent.getX()) <= f10 && Math.abs(this.C.getY() - motionEvent.getY()) <= f10 && o()) {
                            n();
                        }
                    }
                    if (this.H != -1) {
                        s();
                        this.H = -1;
                        Iterator it = this.f10739m.iterator();
                        if (it.hasNext()) {
                            throw android.support.v4.media.session.e.d(it);
                        }
                    }
                    d();
                    invalidate();
                } else if (actionMasked == 2) {
                    if (!this.D) {
                        if (!h() || Math.abs(x10 - this.B) >= i3) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            n();
                        }
                    }
                    if (o()) {
                        this.D = true;
                        s();
                        u();
                        invalidate();
                    }
                }
            } else {
                this.B = x10;
                if (!h()) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (o()) {
                        requestFocus();
                        this.D = true;
                        s();
                        u();
                        invalidate();
                        n();
                    }
                }
            }
            setPressed(this.D);
            this.C = MotionEvent.obtain(motionEvent);
            return true;
        }
        return false;
    }

    public final void p(jb.a aVar, float f2) {
        String e = e(f2);
        if (!TextUtils.equals(aVar.f15396x, e)) {
            aVar.f15396x = e;
            aVar.A.f10635d = true;
            aVar.invalidateSelf();
        }
        int m10 = (this.f10748w + ((int) (m(f2) * this.M))) - (aVar.getIntrinsicWidth() / 2);
        int a3 = a() - (this.A + this.f10750y);
        aVar.setBounds(m10, a3 - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + m10, a3);
        Rect rect = new Rect(aVar.getBounds());
        com.google.android.material.internal.c.c(gb.c(this), this, rect);
        aVar.setBounds(rect);
        ViewGroup c9 = gb.c(this);
        ((ViewOverlay) (c9 == null ? null : new com.example.test.ui.device.activity.i0(c9)).f7866b).add(aVar);
    }

    public final void q(ArrayList arrayList) {
        ViewGroup c9;
        int resourceId;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.G.size() == arrayList.size() && this.G.equals(arrayList)) {
            return;
        }
        this.G = arrayList;
        this.O = true;
        int i3 = 0;
        this.I = 0;
        u();
        ArrayList arrayList2 = this.f10737k;
        if (arrayList2.size() > this.G.size()) {
            List<jb.a> subList = arrayList2.subList(this.G.size(), arrayList2.size());
            for (jb.a aVar : subList) {
                WeakHashMap weakHashMap = z0.f15748a;
                if (k0.b(this)) {
                    ViewGroup c10 = gb.c(this);
                    com.example.test.ui.device.activity.i0 i0Var = c10 == null ? null : new com.example.test.ui.device.activity.i0(c10);
                    if (i0Var != null) {
                        ((ViewOverlay) i0Var.f7866b).remove(aVar);
                        ViewGroup c11 = gb.c(this);
                        if (c11 == null) {
                            aVar.getClass();
                        } else {
                            c11.removeOnLayoutChangeListener(aVar.B);
                        }
                    }
                }
            }
            subList.clear();
        }
        while (arrayList2.size() < this.G.size()) {
            c cVar = this.f10736j;
            BaseSlider baseSlider = cVar.f10760c;
            TypedArray d5 = w.d(baseSlider.getContext(), cVar.f10758a, R$styleable.Slider, cVar.f10759b, f10727a0, new int[0]);
            Context context = baseSlider.getContext();
            int resourceId2 = d5.getResourceId(R$styleable.Slider_labelStyle, R$style.Widget_MaterialComponents_Tooltip);
            jb.a aVar2 = new jb.a(context, resourceId2);
            TypedArray d8 = w.d(aVar2.f15397y, null, R$styleable.Tooltip, 0, resourceId2, new int[0]);
            Context context2 = aVar2.f15397y;
            aVar2.H = context2.getResources().getDimensionPixelSize(R$dimen.mtrl_tooltip_arrowSize);
            l f2 = aVar2.f12505a.f12488a.f();
            f2.f12537k = aVar2.v();
            aVar2.setShapeAppearanceModel(f2.a());
            CharSequence text = d8.getText(R$styleable.Tooltip_android_text);
            boolean equals = TextUtils.equals(aVar2.f15396x, text);
            s sVar = aVar2.A;
            if (!equals) {
                aVar2.f15396x = text;
                sVar.f10635d = true;
                aVar2.invalidateSelf();
            }
            int i10 = R$styleable.Tooltip_android_textAppearance;
            sVar.b((!d8.hasValue(i10) || (resourceId = d8.getResourceId(i10, 0)) == 0) ? null : new bb.e(context2, resourceId), context2);
            aVar2.l(ColorStateList.valueOf(d8.getColor(R$styleable.Tooltip_backgroundTint, c1.a.c(c1.a.e(s0.b(context2, R$attr.colorOnBackground, jb.a.class.getCanonicalName()), 153), c1.a.e(s0.b(context2, R.attr.colorBackground, jb.a.class.getCanonicalName()), 229)))));
            aVar2.q(ColorStateList.valueOf(s0.b(context2, R$attr.colorSurface, jb.a.class.getCanonicalName())));
            aVar2.D = d8.getDimensionPixelSize(R$styleable.Tooltip_android_padding, 0);
            aVar2.E = d8.getDimensionPixelSize(R$styleable.Tooltip_android_minWidth, 0);
            aVar2.F = d8.getDimensionPixelSize(R$styleable.Tooltip_android_minHeight, 0);
            aVar2.G = d8.getDimensionPixelSize(R$styleable.Tooltip_android_layout_margin, 0);
            d8.recycle();
            d5.recycle();
            arrayList2.add(aVar2);
            WeakHashMap weakHashMap2 = z0.f15748a;
            if (k0.b(this) && (c9 = gb.c(this)) != null) {
                int[] iArr = new int[2];
                c9.getLocationOnScreen(iArr);
                aVar2.I = iArr[0];
                c9.getWindowVisibleDisplayFrame(aVar2.C);
                c9.addOnLayoutChangeListener(aVar2.B);
            }
        }
        int i11 = arrayList2.size() == 1 ? 0 : 1;
        int size = arrayList2.size();
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            jb.a aVar3 = (jb.a) obj;
            aVar3.f12505a.f12496j = i11;
            aVar3.invalidateSelf();
        }
        c();
        postInvalidate();
    }

    public final boolean r(float f2, int i3) {
        if (Math.abs(f2 - ((Float) this.G.get(i3)).floatValue()) < 1.0E-4d) {
            return false;
        }
        float f10 = 0.0f;
        float minSeparation = this.J == 0.0f ? getMinSeparation() : 0.0f;
        if (this.W == 0) {
            if (minSeparation != 0.0f) {
                float f11 = this.E;
                f10 = l0.a(f11, this.F, (minSeparation - this.f10748w) / this.M, f11);
            }
            minSeparation = f10;
        }
        if (i()) {
            minSeparation = -minSeparation;
        }
        int i10 = i3 + 1;
        float floatValue = i10 >= this.G.size() ? this.F : ((Float) this.G.get(i10)).floatValue() - minSeparation;
        int i11 = i3 - 1;
        float floatValue2 = i11 < 0 ? this.E : minSeparation + ((Float) this.G.get(i11)).floatValue();
        if (f2 < floatValue2) {
            f2 = floatValue2;
        } else if (f2 > floatValue) {
            f2 = floatValue;
        }
        this.G.set(i3, Float.valueOf(f2));
        this.I = i3;
        Iterator it = this.f10738l.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            ((Float) this.G.get(i3)).getClass();
            throw null;
        }
        AccessibilityManager accessibilityManager = this.f10734h;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return true;
        }
        f fVar = this.f10735i;
        if (fVar == null) {
            this.f10735i = new f(this);
        } else {
            removeCallbacks(fVar);
        }
        f fVar2 = this.f10735i;
        fVar2.f10763a = i3;
        postDelayed(fVar2, 200L);
        return true;
    }

    public void removeOnChangeListener(L l3) {
        this.f10738l.remove(l3);
    }

    public void removeOnSliderTouchListener(T t8) {
        this.f10739m.remove(t8);
    }

    public final void s() {
        double d5;
        float f2 = this.V;
        float f10 = this.J;
        if (f10 > 0.0f) {
            d5 = Math.round(f2 * r1) / ((int) ((this.F - this.E) / f10));
        } else {
            d5 = f2;
        }
        if (i()) {
            d5 = 1.0d - d5;
        }
        float f11 = this.F;
        r((float) ((d5 * (f11 - r1)) + this.E), this.H);
    }

    public void setActiveThumbIndex(int i3) {
        this.H = i3;
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        setLayerType(z5 ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i3) {
        if (i3 < 0 || i3 >= this.G.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.I = i3;
        this.f10733g.w(i3);
        postInvalidate();
    }

    public void setHaloRadius(int i3) {
        if (i3 == this.f10751z) {
            return;
        }
        this.f10751z = i3;
        Drawable background = getBackground();
        if ((getBackground() instanceof RippleDrawable) && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setRadius(this.f10751z);
        } else {
            postInvalidate();
        }
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.P)) {
            return;
        }
        this.P = colorStateList;
        Drawable background = getBackground();
        if ((getBackground() instanceof RippleDrawable) && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        int g10 = g(colorStateList);
        Paint paint = this.f10731d;
        paint.setColor(g10);
        paint.setAlpha(63);
        invalidate();
    }

    public void setSeparationUnit(int i3) {
        this.W = i3;
    }

    public void setStepSize(float f2) {
        if (f2 < 0.0f) {
            String f10 = Float.toString(f2);
            String f11 = Float.toString(this.E);
            throw new IllegalArgumentException(r5.a.f(l0.v("The stepSize(", f10, ") must be 0, or a factor of the valueFrom(", f11, ")-valueTo("), Float.toString(this.F), ") range"));
        }
        if (this.J != f2) {
            this.J = f2;
            this.O = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f2) {
        this.U.k(f2);
    }

    public void setThumbRadius(int i3) {
        int i10 = 0;
        if (i3 == this.f10750y) {
            return;
        }
        this.f10750y = i3;
        this.f10748w = this.r + Math.max(i3 - this.f10744s, 0);
        WeakHashMap weakHashMap = z0.f15748a;
        if (k0.c(this)) {
            this.M = Math.max(getWidth() - (this.f10748w * 2), 0);
            j();
        }
        eb.e eVar = new eb.e(i10);
        eb.e eVar2 = new eb.e(i10);
        eb.e eVar3 = new eb.e(i10);
        eb.e eVar4 = new eb.e(i10);
        float f2 = this.f10750y;
        qb a3 = rb.a(0);
        l.b(a3);
        l.b(a3);
        l.b(a3);
        l.b(a3);
        eb.a aVar = new eb.a(f2);
        eb.a aVar2 = new eb.a(f2);
        eb.a aVar3 = new eb.a(f2);
        eb.a aVar4 = new eb.a(f2);
        m mVar = new m();
        mVar.f12540a = a3;
        mVar.f12541b = a3;
        mVar.f12542c = a3;
        mVar.f12543d = a3;
        mVar.e = aVar;
        mVar.f12544f = aVar2;
        mVar.f12545g = aVar3;
        mVar.f12546h = aVar4;
        mVar.f12547i = eVar;
        mVar.f12548j = eVar2;
        mVar.f12549k = eVar3;
        mVar.f12550l = eVar4;
        eb.h hVar = this.U;
        hVar.setShapeAppearanceModel(mVar);
        int i11 = this.f10750y * 2;
        hVar.setBounds(0, 0, i11, i11);
        postInvalidate();
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.U.q(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeWidth(float f2) {
        eb.h hVar = this.U;
        hVar.f12505a.f12496j = f2;
        hVar.invalidateSelf();
        postInvalidate();
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.Q)) {
            return;
        }
        this.Q = colorStateList;
        this.f10732f.setColor(g(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.R)) {
            return;
        }
        this.R = colorStateList;
        this.e.setColor(g(colorStateList));
        invalidate();
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.S)) {
            return;
        }
        this.S = colorStateList;
        this.f10729b.setColor(g(colorStateList));
        invalidate();
    }

    public void setTrackHeight(int i3) {
        if (this.f10747v != i3) {
            this.f10747v = i3;
            this.f10728a.setStrokeWidth(i3);
            this.f10729b.setStrokeWidth(this.f10747v);
            this.e.setStrokeWidth(this.f10747v / 2.0f);
            this.f10732f.setStrokeWidth(this.f10747v / 2.0f);
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.T)) {
            return;
        }
        this.T = colorStateList;
        this.f10728a.setColor(g(colorStateList));
        invalidate();
    }

    public void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        q(arrayList);
    }

    public final void t(int i3, Rect rect) {
        int m10 = this.f10748w + ((int) (m(getValues().get(i3).floatValue()) * this.M));
        int a3 = a();
        int i10 = this.f10750y;
        rect.set(m10 - i10, a3 - i10, m10 + i10, a3 + i10);
    }

    public final void u() {
        if (!(getBackground() instanceof RippleDrawable) || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int m10 = (int) ((m(((Float) this.G.get(this.I)).floatValue()) * this.M) + this.f10748w);
            int a3 = a();
            int i3 = this.f10751z;
            d1.b.f(background, m10 - i3, a3 - i3, m10 + i3, a3 + i3);
        }
    }

    public final void v() {
        if (this.O) {
            float f2 = this.E;
            float f10 = this.F;
            if (f2 >= f10) {
                throw new IllegalStateException(l0.q("valueFrom(", Float.toString(this.E), ") must be smaller than valueTo(", Float.toString(this.F), ")"));
            }
            if (f10 <= f2) {
                throw new IllegalStateException(l0.q("valueTo(", Float.toString(this.F), ") must be greater than valueFrom(", Float.toString(this.E), ")"));
            }
            if (this.J > 0.0f && !w(f10)) {
                throw new IllegalStateException(r5.a.f(l0.v("The stepSize(", Float.toString(this.J), ") must be 0, or a factor of the valueFrom(", Float.toString(this.E), ")-valueTo("), Float.toString(this.F), ") range"));
            }
            ArrayList arrayList = this.G;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                Float f11 = (Float) obj;
                if (f11.floatValue() < this.E || f11.floatValue() > this.F) {
                    throw new IllegalStateException(r5.a.f(l0.v("Slider value(", Float.toString(f11.floatValue()), ") must be greater or equal to valueFrom(", Float.toString(this.E), "), and lower or equal to valueTo("), Float.toString(this.F), ")"));
                }
                if (this.J > 0.0f && !w(f11.floatValue())) {
                    String f12 = Float.toString(f11.floatValue());
                    String f13 = Float.toString(this.E);
                    String f14 = Float.toString(this.J);
                    String f15 = Float.toString(this.J);
                    StringBuilder v6 = l0.v("Value(", f12, ") must be equal to valueFrom(", f13, ") plus a multiple of stepSize(");
                    v6.append(f14);
                    v6.append(") when using stepSize(");
                    v6.append(f15);
                    v6.append(")");
                    throw new IllegalStateException(v6.toString());
                }
            }
            float f16 = this.J;
            if (f16 != 0.0f) {
                if (((int) f16) != f16) {
                    Log.w("BaseSlider", "Floating point value used for stepSize(" + f16 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.");
                }
                float f17 = this.E;
                if (((int) f17) != f17) {
                    Log.w("BaseSlider", "Floating point value used for valueFrom(" + f17 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.");
                }
                float f18 = this.F;
                if (((int) f18) != f18) {
                    Log.w("BaseSlider", "Floating point value used for valueTo(" + f18 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.");
                }
            }
            this.O = false;
        }
    }

    public final boolean w(float f2) {
        double doubleValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Float.toString(this.E))).divide(new BigDecimal(Float.toString(this.J)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(doubleValue)) - doubleValue) < 1.0E-4d;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BaseSlider(android.content.Context r12, android.util.AttributeSet r13, int r14) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setValues(List<Float> list) {
        q(new ArrayList(list));
    }
}
