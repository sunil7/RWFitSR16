package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.BaseInterpolator;
import android.view.animation.LinearInterpolator;
import com.example.test.ui.device.activity.e0;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.WeakHashMap;
import l1.h0;
import l1.i0;
import l1.z0;

/* loaded from: classes.dex */
public final class b {
    public bb.b A;
    public CharSequence B;
    public CharSequence C;
    public boolean D;
    public Bitmap F;
    public float G;
    public float H;
    public int[] I;
    public boolean J;
    public final TextPaint K;
    public final TextPaint L;
    public LinearInterpolator M;
    public BaseInterpolator N;
    public float O;
    public float P;
    public float Q;
    public ColorStateList R;
    public float S;
    public float T;
    public float U;
    public ColorStateList V;
    public float W;
    public float X;
    public StaticLayout Y;
    public float Z;

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f10558a;

    /* renamed from: a0, reason: collision with root package name */
    public float f10559a0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10560b;

    /* renamed from: b0, reason: collision with root package name */
    public float f10561b0;

    /* renamed from: c, reason: collision with root package name */
    public float f10562c;

    /* renamed from: c0, reason: collision with root package name */
    public CharSequence f10563c0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10564d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f10567f;

    /* renamed from: g, reason: collision with root package name */
    public int f10569g;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f10571h;

    /* renamed from: i, reason: collision with root package name */
    public final Rect f10572i;

    /* renamed from: j, reason: collision with root package name */
    public final RectF f10573j;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f10578o;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f10579p;

    /* renamed from: q, reason: collision with root package name */
    public float f10580q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public float f10581s;

    /* renamed from: t, reason: collision with root package name */
    public float f10582t;

    /* renamed from: u, reason: collision with root package name */
    public float f10583u;

    /* renamed from: v, reason: collision with root package name */
    public float f10584v;

    /* renamed from: w, reason: collision with root package name */
    public Typeface f10585w;

    /* renamed from: x, reason: collision with root package name */
    public Typeface f10586x;

    /* renamed from: y, reason: collision with root package name */
    public Typeface f10587y;

    /* renamed from: z, reason: collision with root package name */
    public bb.b f10588z;

    /* renamed from: k, reason: collision with root package name */
    public int f10574k = 16;

    /* renamed from: l, reason: collision with root package name */
    public int f10575l = 16;

    /* renamed from: m, reason: collision with root package name */
    public float f10576m = 15.0f;

    /* renamed from: n, reason: collision with root package name */
    public float f10577n = 15.0f;
    public boolean E = true;

    /* renamed from: d0, reason: collision with root package name */
    public int f10565d0 = 1;

    /* renamed from: e0, reason: collision with root package name */
    public float f10566e0 = 0.0f;

    /* renamed from: f0, reason: collision with root package name */
    public float f10568f0 = 1.0f;

    /* renamed from: g0, reason: collision with root package name */
    public int f10570g0 = 1;

    public b(ViewGroup viewGroup) {
        this.f10558a = viewGroup;
        TextPaint textPaint = new TextPaint(129);
        this.K = textPaint;
        this.L = new TextPaint(textPaint);
        this.f10572i = new Rect();
        this.f10571h = new Rect();
        this.f10573j = new RectF();
        float f2 = this.e;
        this.f10567f = l0.a(1.0f, f2, 0.5f, f2);
    }

    public static int a(int i3, float f2, int i10) {
        float f10 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i10) * f2) + (Color.alpha(i3) * f10)), (int) ((Color.red(i10) * f2) + (Color.red(i3) * f10)), (int) ((Color.green(i10) * f2) + (Color.green(i3) * f10)), (int) ((Color.blue(i10) * f2) + (Color.blue(i3) * f10)));
    }

    public static float g(float f2, float f10, float f11, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f11 = timeInterpolator.getInterpolation(f11);
        }
        return ja.a.a(f2, f10, f11);
    }

    public final float b() {
        if (this.B == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.L;
        textPaint.setTextSize(this.f10577n);
        textPaint.setTypeface(this.f10585w);
        textPaint.setLetterSpacing(this.W);
        CharSequence charSequence = this.B;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public final boolean c(CharSequence charSequence) {
        WeakHashMap weakHashMap = z0.f15748a;
        boolean z5 = i0.d(this.f10558a) == 1;
        if (this.E) {
            return (z5 ? j1.g.f15180d : j1.g.f15179c).f(charSequence, charSequence.length());
        }
        return z5;
    }

    public final void d(boolean z5, float f2) {
        boolean z6;
        float f10;
        boolean z8;
        StaticLayout staticLayout;
        if (this.B == null) {
            return;
        }
        float width = this.f10572i.width();
        float width2 = this.f10571h.width();
        int i3 = 1;
        if (Math.abs(f2 - this.f10577n) < 0.001f) {
            f10 = this.f10577n;
            this.G = 1.0f;
            Typeface typeface = this.f10587y;
            Typeface typeface2 = this.f10585w;
            if (typeface != typeface2) {
                this.f10587y = typeface2;
                z8 = true;
            } else {
                z8 = false;
            }
        } else {
            float f11 = this.f10576m;
            Typeface typeface3 = this.f10587y;
            Typeface typeface4 = this.f10586x;
            if (typeface3 != typeface4) {
                this.f10587y = typeface4;
                z6 = true;
            } else {
                z6 = false;
            }
            if (Math.abs(f2 - f11) < 0.001f) {
                this.G = 1.0f;
            } else {
                this.G = f2 / this.f10576m;
            }
            float f12 = this.f10577n / this.f10576m;
            width = (!z5 && width2 * f12 > width) ? Math.min(width / f12, width2) : width2;
            f10 = f11;
            z8 = z6;
        }
        if (width > 0.0f) {
            z8 = this.H != f10 || this.J || z8;
            this.H = f10;
            this.J = false;
        }
        if (this.C == null || z8) {
            TextPaint textPaint = this.K;
            textPaint.setTextSize(this.H);
            textPaint.setTypeface(this.f10587y);
            textPaint.setLinearText(this.G != 1.0f);
            boolean c9 = c(this.B);
            this.D = c9;
            int i10 = this.f10565d0;
            if (i10 > 1 && (!c9 || this.f10564d)) {
                i3 = i10;
            }
            try {
                p pVar = new p(this.B, textPaint, (int) width);
                pVar.f10629l = TextUtils.TruncateAt.END;
                pVar.f10628k = c9;
                pVar.e = Layout.Alignment.ALIGN_NORMAL;
                pVar.f10627j = false;
                pVar.f10623f = i3;
                float f13 = this.f10566e0;
                float f14 = this.f10568f0;
                pVar.f10624g = f13;
                pVar.f10625h = f14;
                pVar.f10626i = this.f10570g0;
                staticLayout = pVar.a();
            } catch (StaticLayoutBuilderCompat$StaticLayoutBuilderCompatException e) {
                Log.e("CollapsingTextHelper", e.getCause().getMessage(), e);
                staticLayout = null;
            }
            staticLayout.getClass();
            this.Y = staticLayout;
            this.C = staticLayout.getText();
        }
    }

    public final void e(Canvas canvas) {
        int save = canvas.save();
        if (this.C == null || !this.f10560b) {
            return;
        }
        float lineStart = (this.f10583u + (this.f10565d0 > 1 ? this.Y.getLineStart(0) : this.Y.getLineLeft(0))) - (this.f10561b0 * 2.0f);
        TextPaint textPaint = this.K;
        textPaint.setTextSize(this.H);
        float f2 = this.f10583u;
        float f10 = this.f10584v;
        float f11 = this.G;
        if (f11 != 1.0f && !this.f10564d) {
            canvas.scale(f11, f11, f2, f10);
        }
        if (this.f10565d0 <= 1 || ((this.D && !this.f10564d) || (this.f10564d && this.f10562c <= this.f10567f))) {
            canvas.translate(f2, f10);
            this.Y.draw(canvas);
        } else {
            int alpha = textPaint.getAlpha();
            canvas.translate(lineStart, f10);
            float f12 = alpha;
            textPaint.setAlpha((int) (this.f10559a0 * f12));
            this.Y.draw(canvas);
            textPaint.setAlpha((int) (this.Z * f12));
            int lineBaseline = this.Y.getLineBaseline(0);
            CharSequence charSequence = this.f10563c0;
            float f13 = lineBaseline;
            canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f13, textPaint);
            if (!this.f10564d) {
                String trim = this.f10563c0.toString().trim();
                if (trim.endsWith("…")) {
                    trim = trim.substring(0, trim.length() - 1);
                }
                String str = trim;
                textPaint.setAlpha(alpha);
                canvas.drawText(str, 0, Math.min(this.Y.getLineEnd(0), str.length()), 0.0f, f13, (Paint) textPaint);
            }
            canvas = canvas;
        }
        canvas.restoreToCount(save);
    }

    public final int f(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.I;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void h() {
        boolean z5;
        Rect rect = this.f10572i;
        if (rect.width() > 0 && rect.height() > 0) {
            Rect rect2 = this.f10571h;
            if (rect2.width() > 0 && rect2.height() > 0) {
                z5 = true;
                this.f10560b = z5;
            }
        }
        z5 = false;
        this.f10560b = z5;
    }

    public final void i(boolean z5) {
        float f2;
        StaticLayout staticLayout;
        ViewGroup viewGroup = this.f10558a;
        if ((viewGroup.getHeight() <= 0 || viewGroup.getWidth() <= 0) && !z5) {
            return;
        }
        float f10 = this.H;
        d(z5, this.f10577n);
        CharSequence charSequence = this.C;
        TextPaint textPaint = this.K;
        if (charSequence != null && (staticLayout = this.Y) != null) {
            this.f10563c0 = TextUtils.ellipsize(charSequence, textPaint, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.f10563c0;
        float measureText = charSequence2 != null ? textPaint.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f10575l, this.D ? 1 : 0);
        int i3 = absoluteGravity & 112;
        Rect rect = this.f10572i;
        if (i3 == 48) {
            this.r = rect.top;
        } else if (i3 != 80) {
            this.r = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.r = textPaint.ascent() + rect.bottom;
        }
        int i10 = absoluteGravity & 8388615;
        if (i10 == 1) {
            this.f10582t = rect.centerX() - (measureText / 2.0f);
        } else if (i10 != 5) {
            this.f10582t = rect.left;
        } else {
            this.f10582t = rect.right - measureText;
        }
        d(z5, this.f10576m);
        float height = this.Y != null ? r1.getHeight() : 0.0f;
        CharSequence charSequence3 = this.C;
        float measureText2 = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout2 = this.Y;
        if (staticLayout2 != null && this.f10565d0 > 1) {
            measureText2 = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.Y;
        this.f10561b0 = staticLayout3 != null ? this.f10565d0 > 1 ? staticLayout3.getLineStart(0) : staticLayout3.getLineLeft(0) : 0.0f;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f10574k, this.D ? 1 : 0);
        int i11 = absoluteGravity2 & 112;
        Rect rect2 = this.f10571h;
        if (i11 == 48) {
            this.f10580q = rect2.top;
        } else if (i11 != 80) {
            this.f10580q = rect2.centerY() - (height / 2.0f);
        } else {
            this.f10580q = textPaint.descent() + (rect2.bottom - height);
        }
        int i12 = absoluteGravity2 & 8388615;
        if (i12 == 1) {
            this.f10581s = rect2.centerX() - (measureText2 / 2.0f);
        } else if (i12 != 5) {
            this.f10581s = rect2.left;
        } else {
            this.f10581s = rect2.right - measureText2;
        }
        Bitmap bitmap = this.F;
        if (bitmap != null) {
            bitmap.recycle();
            this.F = null;
        }
        o(f10);
        float f11 = this.f10562c;
        boolean z6 = this.f10564d;
        RectF rectF = this.f10573j;
        if (z6) {
            if (f11 < this.f10567f) {
                rect = rect2;
            }
            rectF.set(rect);
        } else {
            rectF.left = g(rect2.left, rect.left, f11, this.M);
            rectF.top = g(this.f10580q, this.r, f11, this.M);
            rectF.right = g(rect2.right, rect.right, f11, this.M);
            rectF.bottom = g(rect2.bottom, rect.bottom, f11, this.M);
        }
        if (!this.f10564d) {
            this.f10583u = g(this.f10581s, this.f10582t, f11, this.M);
            this.f10584v = g(this.f10580q, this.r, f11, this.M);
            o(g(this.f10576m, this.f10577n, f11, this.N));
            f2 = f11;
        } else if (f11 < this.f10567f) {
            this.f10583u = this.f10581s;
            this.f10584v = this.f10580q;
            o(this.f10576m);
            f2 = 0.0f;
        } else {
            this.f10583u = this.f10582t;
            this.f10584v = this.r - Math.max(0, this.f10569g);
            o(this.f10577n);
            f2 = 1.0f;
        }
        v1.a aVar = ja.a.f15384b;
        this.Z = 1.0f - g(0.0f, 1.0f, 1.0f - f11, aVar);
        WeakHashMap weakHashMap = z0.f15748a;
        h0.k(viewGroup);
        this.f10559a0 = g(1.0f, 0.0f, f11, aVar);
        h0.k(viewGroup);
        ColorStateList colorStateList = this.f10579p;
        ColorStateList colorStateList2 = this.f10578o;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(f(colorStateList2), f2, f(this.f10579p)));
        } else {
            textPaint.setColor(f(colorStateList));
        }
        float f12 = this.W;
        float f13 = this.X;
        if (f12 != f13) {
            textPaint.setLetterSpacing(g(f13, f12, f11, aVar));
        } else {
            textPaint.setLetterSpacing(f12);
        }
        textPaint.setShadowLayer(ja.a.a(this.S, this.O, f11), ja.a.a(this.T, this.P, f11), ja.a.a(this.U, this.Q, f11), a(f(this.V), f11, f(this.R)));
        if (this.f10564d) {
            float f14 = this.f10567f;
            textPaint.setAlpha((int) ((f11 <= f14 ? ja.a.b(1.0f, 0.0f, this.e, f14, f11) : ja.a.b(0.0f, 1.0f, f14, 1.0f, f11)) * 255.0f));
        }
        h0.k(viewGroup);
    }

    public final void j(int i3) {
        ViewGroup viewGroup = this.f10558a;
        bb.e eVar = new bb.e(viewGroup.getContext(), i3);
        ColorStateList colorStateList = eVar.f3190a;
        if (colorStateList != null) {
            this.f10579p = colorStateList;
        }
        float f2 = eVar.f3199k;
        if (f2 != 0.0f) {
            this.f10577n = f2;
        }
        ColorStateList colorStateList2 = eVar.f3191b;
        if (colorStateList2 != null) {
            this.R = colorStateList2;
        }
        this.P = eVar.f3194f;
        this.Q = eVar.f3195g;
        this.O = eVar.f3196h;
        this.W = eVar.f3198j;
        bb.b bVar = this.A;
        if (bVar != null) {
            bVar.f3184c = true;
        }
        com.example.test.ui.device.activity.i0 i0Var = new com.example.test.ui.device.activity.i0(this, 9);
        eVar.a();
        this.A = new bb.b(i0Var, eVar.f3202n);
        eVar.c(viewGroup.getContext(), this.A);
        i(false);
    }

    public final void k(ColorStateList colorStateList) {
        if (this.f10579p != colorStateList) {
            this.f10579p = colorStateList;
            i(false);
        }
    }

    public final void l(int i3) {
        if (this.f10575l != i3) {
            this.f10575l = i3;
            i(false);
        }
    }

    public final void m(int i3) {
        ViewGroup viewGroup = this.f10558a;
        bb.e eVar = new bb.e(viewGroup.getContext(), i3);
        ColorStateList colorStateList = eVar.f3190a;
        if (colorStateList != null) {
            this.f10578o = colorStateList;
        }
        float f2 = eVar.f3199k;
        if (f2 != 0.0f) {
            this.f10576m = f2;
        }
        ColorStateList colorStateList2 = eVar.f3191b;
        if (colorStateList2 != null) {
            this.V = colorStateList2;
        }
        this.T = eVar.f3194f;
        this.U = eVar.f3195g;
        this.S = eVar.f3196h;
        this.X = eVar.f3198j;
        bb.b bVar = this.f10588z;
        if (bVar != null) {
            bVar.f3184c = true;
        }
        e0 e0Var = new e0(this, 10);
        eVar.a();
        this.f10588z = new bb.b(e0Var, eVar.f3202n);
        eVar.c(viewGroup.getContext(), this.f10588z);
        i(false);
    }

    public final void n(float f2) {
        float f10;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 != this.f10562c) {
            this.f10562c = f2;
            boolean z5 = this.f10564d;
            RectF rectF = this.f10573j;
            Rect rect = this.f10572i;
            Rect rect2 = this.f10571h;
            if (z5) {
                if (f2 < this.f10567f) {
                    rect = rect2;
                }
                rectF.set(rect);
            } else {
                rectF.left = g(rect2.left, rect.left, f2, this.M);
                rectF.top = g(this.f10580q, this.r, f2, this.M);
                rectF.right = g(rect2.right, rect.right, f2, this.M);
                rectF.bottom = g(rect2.bottom, rect.bottom, f2, this.M);
            }
            if (!this.f10564d) {
                this.f10583u = g(this.f10581s, this.f10582t, f2, this.M);
                this.f10584v = g(this.f10580q, this.r, f2, this.M);
                o(g(this.f10576m, this.f10577n, f2, this.N));
                f10 = f2;
            } else if (f2 < this.f10567f) {
                this.f10583u = this.f10581s;
                this.f10584v = this.f10580q;
                o(this.f10576m);
                f10 = 0.0f;
            } else {
                this.f10583u = this.f10582t;
                this.f10584v = this.r - Math.max(0, this.f10569g);
                o(this.f10577n);
                f10 = 1.0f;
            }
            v1.a aVar = ja.a.f15384b;
            this.Z = 1.0f - g(0.0f, 1.0f, 1.0f - f2, aVar);
            WeakHashMap weakHashMap = z0.f15748a;
            ViewGroup viewGroup = this.f10558a;
            h0.k(viewGroup);
            this.f10559a0 = g(1.0f, 0.0f, f2, aVar);
            h0.k(viewGroup);
            ColorStateList colorStateList = this.f10579p;
            ColorStateList colorStateList2 = this.f10578o;
            TextPaint textPaint = this.K;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(a(f(colorStateList2), f10, f(this.f10579p)));
            } else {
                textPaint.setColor(f(colorStateList));
            }
            float f11 = this.W;
            float f12 = this.X;
            if (f11 != f12) {
                textPaint.setLetterSpacing(g(f12, f11, f2, aVar));
            } else {
                textPaint.setLetterSpacing(f11);
            }
            textPaint.setShadowLayer(ja.a.a(this.S, this.O, f2), ja.a.a(this.T, this.P, f2), ja.a.a(this.U, this.Q, f2), a(f(this.V), f2, f(this.R)));
            if (this.f10564d) {
                float f13 = this.f10567f;
                textPaint.setAlpha((int) ((f2 <= f13 ? ja.a.b(1.0f, 0.0f, this.e, f13, f2) : ja.a.b(0.0f, 1.0f, f13, 1.0f, f2)) * 255.0f));
            }
            h0.k(viewGroup);
        }
    }

    public final void o(float f2) {
        d(false, f2);
        WeakHashMap weakHashMap = z0.f15748a;
        h0.k(this.f10558a);
    }
}
