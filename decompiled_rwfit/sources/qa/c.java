package qa;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.r;
import com.google.android.material.internal.s;
import eb.h;
import eb.l;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class c extends h implements Drawable.Callback, r {

    /* renamed from: o1, reason: collision with root package name */
    public static final int[] f17861o1 = {R.attr.state_enabled};

    /* renamed from: p1, reason: collision with root package name */
    public static final ShapeDrawable f17862p1 = new ShapeDrawable(new OvalShape());
    public float A;
    public ColorStateList B;
    public float C;
    public ColorStateList D;
    public CharSequence E;
    public boolean F;
    public Drawable G;
    public ColorStateList H;
    public float I;
    public boolean J;
    public boolean K;
    public Drawable L;
    public RippleDrawable M;
    public ColorStateList N;
    public float O;
    public SpannableStringBuilder P;
    public boolean Q;
    public boolean R;
    public Drawable S;
    public ColorStateList T;
    public ja.e U;
    public int U0;
    public ja.e V;
    public int V0;
    public float W;
    public int W0;
    public float X;
    public int X0;
    public float Y;
    public int Y0;
    public float Z;
    public int Z0;

    /* renamed from: a0, reason: collision with root package name */
    public float f17863a0;

    /* renamed from: a1, reason: collision with root package name */
    public boolean f17864a1;

    /* renamed from: b0, reason: collision with root package name */
    public float f17865b0;

    /* renamed from: b1, reason: collision with root package name */
    public int f17866b1;

    /* renamed from: c0, reason: collision with root package name */
    public float f17867c0;

    /* renamed from: c1, reason: collision with root package name */
    public int f17868c1;

    /* renamed from: d0, reason: collision with root package name */
    public float f17869d0;

    /* renamed from: d1, reason: collision with root package name */
    public ColorFilter f17870d1;

    /* renamed from: e0, reason: collision with root package name */
    public final Context f17871e0;

    /* renamed from: e1, reason: collision with root package name */
    public PorterDuffColorFilter f17872e1;

    /* renamed from: f0, reason: collision with root package name */
    public final Paint f17873f0;
    public ColorStateList f1;

    /* renamed from: g0, reason: collision with root package name */
    public final Paint.FontMetrics f17874g0;

    /* renamed from: g1, reason: collision with root package name */
    public PorterDuff.Mode f17875g1;

    /* renamed from: h0, reason: collision with root package name */
    public final RectF f17876h0;

    /* renamed from: h1, reason: collision with root package name */
    public int[] f17877h1;
    public final PointF i0;

    /* renamed from: i1, reason: collision with root package name */
    public ColorStateList f17878i1;

    /* renamed from: j0, reason: collision with root package name */
    public final Path f17879j0;

    /* renamed from: j1, reason: collision with root package name */
    public WeakReference f17880j1;

    /* renamed from: k0, reason: collision with root package name */
    public final s f17881k0;

    /* renamed from: k1, reason: collision with root package name */
    public TextUtils.TruncateAt f17882k1;

    /* renamed from: l1, reason: collision with root package name */
    public boolean f17883l1;

    /* renamed from: m1, reason: collision with root package name */
    public int f17884m1;

    /* renamed from: n1, reason: collision with root package name */
    public boolean f17885n1;

    /* renamed from: x, reason: collision with root package name */
    public ColorStateList f17886x;

    /* renamed from: y, reason: collision with root package name */
    public ColorStateList f17887y;

    /* renamed from: z, reason: collision with root package name */
    public float f17888z;

    public c(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3, Chip.f10361u);
        this.A = -1.0f;
        this.f17873f0 = new Paint(1);
        this.f17874g0 = new Paint.FontMetrics();
        this.f17876h0 = new RectF();
        this.i0 = new PointF();
        this.f17879j0 = new Path();
        this.f17868c1 = 255;
        this.f17875g1 = PorterDuff.Mode.SRC_IN;
        this.f17880j1 = new WeakReference(null);
        j(context);
        this.f17871e0 = context;
        s sVar = new s(this);
        this.f17881k0 = sVar;
        this.E = "";
        sVar.f10632a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = f17861o1;
        setState(iArr);
        if (!Arrays.equals(this.f17877h1, iArr)) {
            this.f17877h1 = iArr;
            if (Z()) {
                C(getState(), iArr);
            }
        }
        this.f17883l1 = true;
        int[] iArr2 = cb.a.f3422a;
        f17862p1.setTint(-1);
    }

    public static boolean A(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static void a0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean z(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public final void B() {
        b bVar = (b) this.f17880j1.get();
        if (bVar != null) {
            Chip chip = (Chip) bVar;
            chip.c(chip.f10375p);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean C(int[] r9, int[] r10) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: qa.c.C(int[], int[]):boolean");
    }

    public final void D(boolean z5) {
        if (this.Q != z5) {
            this.Q = z5;
            float w8 = w();
            if (!z5 && this.f17864a1) {
                this.f17864a1 = false;
            }
            float w9 = w();
            invalidateSelf();
            if (w8 != w9) {
                B();
            }
        }
    }

    public final void E(Drawable drawable) {
        if (this.S != drawable) {
            float w8 = w();
            this.S = drawable;
            float w9 = w();
            a0(this.S);
            u(this.S);
            invalidateSelf();
            if (w8 != w9) {
                B();
            }
        }
    }

    public final void F(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.T != colorStateList) {
            this.T = colorStateList;
            if (this.R && (drawable = this.S) != null && this.Q) {
                d1.b.h(drawable, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void G(boolean z5) {
        if (this.R != z5) {
            boolean X = X();
            this.R = z5;
            boolean X2 = X();
            if (X != X2) {
                if (X2) {
                    u(this.S);
                } else {
                    a0(this.S);
                }
                invalidateSelf();
                B();
            }
        }
    }

    public final void H(float f2) {
        if (this.A != f2) {
            this.A = f2;
            l f10 = this.f12505a.f12488a.f();
            f10.c(f2);
            setShapeAppearanceModel(f10.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.G;
        if (drawable3 != 0) {
            boolean z5 = drawable3 instanceof d1.h;
            drawable2 = drawable3;
            if (z5) {
                drawable2 = null;
            }
        } else {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float w8 = w();
            this.G = drawable != null ? drawable.mutate() : null;
            float w9 = w();
            a0(drawable2);
            if (Y()) {
                u(this.G);
            }
            invalidateSelf();
            if (w8 != w9) {
                B();
            }
        }
    }

    public final void J(float f2) {
        if (this.I != f2) {
            float w8 = w();
            this.I = f2;
            float w9 = w();
            invalidateSelf();
            if (w8 != w9) {
                B();
            }
        }
    }

    public final void K(ColorStateList colorStateList) {
        this.J = true;
        if (this.H != colorStateList) {
            this.H = colorStateList;
            if (Y()) {
                d1.b.h(this.G, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void L(boolean z5) {
        if (this.F != z5) {
            boolean Y = Y();
            this.F = z5;
            boolean Y2 = Y();
            if (Y != Y2) {
                if (Y2) {
                    u(this.G);
                } else {
                    a0(this.G);
                }
                invalidateSelf();
                B();
            }
        }
    }

    public final void M(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            if (this.f17885n1) {
                q(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void N(float f2) {
        if (this.C != f2) {
            this.C = f2;
            this.f17873f0.setStrokeWidth(f2);
            if (this.f17885n1) {
                this.f12505a.f12496j = f2;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O(android.graphics.drawable.Drawable r6) {
        /*
            r5 = this;
            r0 = 0
            android.graphics.drawable.Drawable r1 = r5.L
            if (r1 == 0) goto Lb
            boolean r2 = r1 instanceof d1.h
            if (r2 == 0) goto Lc
            d1.h r1 = (d1.h) r1
        Lb:
            r1 = r0
        Lc:
            if (r1 == r6) goto L49
            float r2 = r5.x()
            if (r6 == 0) goto L18
            android.graphics.drawable.Drawable r0 = r6.mutate()
        L18:
            r5.L = r0
            int[] r6 = cb.a.f3422a
            android.graphics.drawable.RippleDrawable r6 = new android.graphics.drawable.RippleDrawable
            android.content.res.ColorStateList r0 = r5.D
            android.content.res.ColorStateList r0 = cb.a.b(r0)
            android.graphics.drawable.Drawable r3 = r5.L
            android.graphics.drawable.ShapeDrawable r4 = qa.c.f17862p1
            r6.<init>(r0, r3, r4)
            r5.M = r6
            float r6 = r5.x()
            a0(r1)
            boolean r0 = r5.Z()
            if (r0 == 0) goto L3f
            android.graphics.drawable.Drawable r0 = r5.L
            r5.u(r0)
        L3f:
            r5.invalidateSelf()
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 == 0) goto L49
            r5.B()
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qa.c.O(android.graphics.drawable.Drawable):void");
    }

    public final void P(float f2) {
        if (this.f17867c0 != f2) {
            this.f17867c0 = f2;
            invalidateSelf();
            if (Z()) {
                B();
            }
        }
    }

    public final void Q(float f2) {
        if (this.O != f2) {
            this.O = f2;
            invalidateSelf();
            if (Z()) {
                B();
            }
        }
    }

    public final void R(float f2) {
        if (this.f17865b0 != f2) {
            this.f17865b0 = f2;
            invalidateSelf();
            if (Z()) {
                B();
            }
        }
    }

    public final void S(ColorStateList colorStateList) {
        if (this.N != colorStateList) {
            this.N = colorStateList;
            if (Z()) {
                d1.b.h(this.L, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void T(boolean z5) {
        if (this.K != z5) {
            boolean Z = Z();
            this.K = z5;
            boolean Z2 = Z();
            if (Z != Z2) {
                if (Z2) {
                    u(this.L);
                } else {
                    a0(this.L);
                }
                invalidateSelf();
                B();
            }
        }
    }

    public final void U(float f2) {
        if (this.Y != f2) {
            float w8 = w();
            this.Y = f2;
            float w9 = w();
            invalidateSelf();
            if (w8 != w9) {
                B();
            }
        }
    }

    public final void V(float f2) {
        if (this.X != f2) {
            float w8 = w();
            this.X = f2;
            float w9 = w();
            invalidateSelf();
            if (w8 != w9) {
                B();
            }
        }
    }

    public final void W(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            this.f17878i1 = null;
            onStateChange(getState());
        }
    }

    public final boolean X() {
        return this.R && this.S != null && this.f17864a1;
    }

    public final boolean Y() {
        return this.F && this.G != null;
    }

    public final boolean Z() {
        return this.K && this.L != null;
    }

    @Override // eb.h, com.google.android.material.internal.r
    public final void a() {
        B();
        invalidateSelf();
    }

    @Override // eb.h, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i3;
        Canvas canvas2;
        int i10;
        int i11;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i3 = this.f17868c1) == 0) {
            return;
        }
        if (i3 < 255) {
            canvas2 = canvas;
            i10 = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i3);
        } else {
            canvas2 = canvas;
            i10 = 0;
        }
        boolean z5 = this.f17885n1;
        Paint paint = this.f17873f0;
        RectF rectF = this.f17876h0;
        if (!z5) {
            paint.setColor(this.U0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, y(), y(), paint);
        }
        if (!this.f17885n1) {
            paint.setColor(this.V0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.f17870d1;
            if (colorFilter == null) {
                colorFilter = this.f17872e1;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, y(), y(), paint);
        }
        if (this.f17885n1) {
            super.draw(canvas);
        }
        if (this.C > 0.0f && !this.f17885n1) {
            paint.setColor(this.X0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.f17885n1) {
                ColorFilter colorFilter2 = this.f17870d1;
                if (colorFilter2 == null) {
                    colorFilter2 = this.f17872e1;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f2 = bounds.left;
            float f10 = this.C / 2.0f;
            rectF.set(f2 + f10, bounds.top + f10, bounds.right - f10, bounds.bottom - f10);
            float f11 = this.A - (this.C / 2.0f);
            canvas2.drawRoundRect(rectF, f11, f11, paint);
        }
        paint.setColor(this.Y0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.f17885n1) {
            RectF rectF2 = new RectF(bounds);
            Path path = this.f17879j0;
            eb.g gVar = this.f12505a;
            this.r.a(gVar.f12488a, gVar.f12495i, rectF2, this.f12520q, path);
            e(canvas2, paint, path, this.f12505a.f12488a, f());
        } else {
            canvas2.drawRoundRect(rectF, y(), y(), paint);
        }
        if (Y()) {
            v(bounds, rectF);
            float f12 = rectF.left;
            float f13 = rectF.top;
            canvas2.translate(f12, f13);
            this.G.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.G.draw(canvas2);
            canvas2.translate(-f12, -f13);
        }
        if (X()) {
            v(bounds, rectF);
            float f14 = rectF.left;
            float f15 = rectF.top;
            canvas2.translate(f14, f15);
            this.S.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.S.draw(canvas2);
            canvas2.translate(-f14, -f15);
        }
        if (this.f17883l1 && this.E != null) {
            PointF pointF = this.i0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.E;
            s sVar = this.f17881k0;
            if (charSequence != null) {
                float w8 = w() + this.W + this.Z;
                if (d1.c.a(this) == 0) {
                    pointF.x = bounds.left + w8;
                } else {
                    pointF.x = bounds.right - w8;
                    align = Paint.Align.RIGHT;
                }
                float centerY = bounds.centerY();
                TextPaint textPaint = sVar.f10632a;
                Paint.FontMetrics fontMetrics = this.f17874g0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = centerY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF.setEmpty();
            if (this.E != null) {
                float w9 = w() + this.W + this.Z;
                float x10 = x() + this.f17869d0 + this.f17863a0;
                if (d1.c.a(this) == 0) {
                    rectF.left = bounds.left + w9;
                    rectF.right = bounds.right - x10;
                } else {
                    rectF.left = bounds.left + x10;
                    rectF.right = bounds.right - w9;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            bb.e eVar = sVar.f10636f;
            TextPaint textPaint2 = sVar.f10632a;
            if (eVar != null) {
                textPaint2.drawableState = getState();
                sVar.f10636f.e(this.f17871e0, textPaint2, sVar.f10633b);
            }
            textPaint2.setTextAlign(align);
            boolean z6 = Math.round(sVar.a(this.E.toString())) > Math.round(rectF.width());
            if (z6) {
                int save = canvas2.save();
                canvas2.clipRect(rectF);
                i11 = save;
            } else {
                i11 = 0;
            }
            CharSequence charSequence2 = this.E;
            if (z6 && this.f17882k1 != null) {
                charSequence2 = TextUtils.ellipsize(charSequence2, textPaint2, rectF.width(), this.f17882k1);
            }
            canvas.drawText(charSequence2, 0, charSequence2.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z6) {
                canvas2.restoreToCount(i11);
            }
        }
        if (Z()) {
            rectF.setEmpty();
            if (Z()) {
                float f16 = this.f17869d0 + this.f17867c0;
                if (d1.c.a(this) == 0) {
                    float f17 = bounds.right - f16;
                    rectF.right = f17;
                    rectF.left = f17 - this.O;
                } else {
                    float f18 = bounds.left + f16;
                    rectF.left = f18;
                    rectF.right = f18 + this.O;
                }
                float exactCenterY = bounds.exactCenterY();
                float f19 = this.O;
                float f20 = exactCenterY - (f19 / 2.0f);
                rectF.top = f20;
                rectF.bottom = f20 + f19;
            }
            float f21 = rectF.left;
            float f22 = rectF.top;
            canvas2.translate(f21, f22);
            this.L.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            int[] iArr = cb.a.f3422a;
            this.M.setBounds(this.L.getBounds());
            this.M.jumpToCurrentState();
            this.M.draw(canvas2);
            canvas2.translate(-f21, -f22);
        }
        if (this.f17868c1 < 255) {
            canvas2.restoreToCount(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f17868c1;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f17870d1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f17888z;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(x() + this.f17881k0.a(this.E.toString()) + w() + this.W + this.Z + this.f17863a0 + this.f17869d0), this.f17884m1);
    }

    @Override // eb.h, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // eb.h, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.f17885n1) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.f17888z, this.A);
        } else {
            outline.setRoundRect(bounds, this.A);
            outline2 = outline;
        }
        outline2.setAlpha(this.f17868c1 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // eb.h, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (z(this.f17886x) || z(this.f17887y) || z(this.B)) {
            return true;
        }
        bb.e eVar = this.f17881k0.f10636f;
        if (eVar == null || (colorStateList = eVar.f3190a) == null || !colorStateList.isStateful()) {
            return (this.R && this.S != null && this.Q) || A(this.G) || A(this.S) || z(this.f1);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i3) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i3);
        if (Y()) {
            onLayoutDirectionChanged |= d1.c.b(this.G, i3);
        }
        if (X()) {
            onLayoutDirectionChanged |= d1.c.b(this.S, i3);
        }
        if (Z()) {
            onLayoutDirectionChanged |= d1.c.b(this.L, i3);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i3) {
        boolean onLevelChange = super.onLevelChange(i3);
        if (Y()) {
            onLevelChange |= this.G.setLevel(i3);
        }
        if (X()) {
            onLevelChange |= this.S.setLevel(i3);
        }
        if (Z()) {
            onLevelChange |= this.L.setLevel(i3);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // eb.h, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        if (this.f17885n1) {
            super.onStateChange(iArr);
        }
        return C(iArr, this.f17877h1);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j4);
        }
    }

    @Override // eb.h, android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
        if (this.f17868c1 != i3) {
            this.f17868c1 = i3;
            invalidateSelf();
        }
    }

    @Override // eb.h, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f17870d1 != colorFilter) {
            this.f17870d1 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // eb.h, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.f1 != colorStateList) {
            this.f1 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // eb.h, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.f17875g1 != mode) {
            this.f17875g1 = mode;
            ColorStateList colorStateList = this.f1;
            this.f17872e1 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z5, boolean z6) {
        boolean visible = super.setVisible(z5, z6);
        if (Y()) {
            visible |= this.G.setVisible(z5, z6);
        }
        if (X()) {
            visible |= this.S.setVisible(z5, z6);
        }
        if (Z()) {
            visible |= this.L.setVisible(z5, z6);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void u(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        d1.c.b(drawable, d1.c.a(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.L) {
            if (drawable.isStateful()) {
                drawable.setState(this.f17877h1);
            }
            d1.b.h(drawable, this.N);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.G;
        if (drawable == drawable2 && this.J) {
            d1.b.h(drawable2, this.H);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void v(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (Y() || X()) {
            float f2 = this.W + this.X;
            Drawable drawable = this.f17864a1 ? this.S : this.G;
            float f10 = this.I;
            if (f10 <= 0.0f && drawable != null) {
                f10 = drawable.getIntrinsicWidth();
            }
            if (d1.c.a(this) == 0) {
                float f11 = rect.left + f2;
                rectF.left = f11;
                rectF.right = f11 + f10;
            } else {
                float f12 = rect.right - f2;
                rectF.right = f12;
                rectF.left = f12 - f10;
            }
            Drawable drawable2 = this.f17864a1 ? this.S : this.G;
            float f13 = this.I;
            if (f13 <= 0.0f && drawable2 != null) {
                f13 = (float) Math.ceil(gb.b(this.f17871e0, 24));
                if (drawable2.getIntrinsicHeight() <= f13) {
                    f13 = drawable2.getIntrinsicHeight();
                }
            }
            float exactCenterY = rect.exactCenterY() - (f13 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + f13;
        }
    }

    public final float w() {
        if (!Y() && !X()) {
            return 0.0f;
        }
        float f2 = this.X;
        Drawable drawable = this.f17864a1 ? this.S : this.G;
        float f10 = this.I;
        if (f10 <= 0.0f && drawable != null) {
            f10 = drawable.getIntrinsicWidth();
        }
        return f10 + f2 + this.Y;
    }

    public final float x() {
        if (Z()) {
            return this.f17865b0 + this.O + this.f17867c0;
        }
        return 0.0f;
    }

    public final float y() {
        return this.f17885n1 ? h() : this.A;
    }
}
