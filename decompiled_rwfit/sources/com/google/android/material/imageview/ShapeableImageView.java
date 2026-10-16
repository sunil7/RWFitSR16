package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.material.R$style;
import eb.h;
import eb.m;
import eb.o;
import eb.x;

/* loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements x {

    /* renamed from: v, reason: collision with root package name */
    public static final int f10513v = R$style.Widget_MaterialComponents_ShapeableImageView;

    /* renamed from: d, reason: collision with root package name */
    public final o f10514d;
    public final RectF e;

    /* renamed from: f, reason: collision with root package name */
    public final RectF f10515f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f10516g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f10517h;

    /* renamed from: i, reason: collision with root package name */
    public final Path f10518i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f10519j;

    /* renamed from: k, reason: collision with root package name */
    public h f10520k;

    /* renamed from: l, reason: collision with root package name */
    public m f10521l;

    /* renamed from: m, reason: collision with root package name */
    public float f10522m;

    /* renamed from: n, reason: collision with root package name */
    public final Path f10523n;

    /* renamed from: o, reason: collision with root package name */
    public final int f10524o;

    /* renamed from: p, reason: collision with root package name */
    public final int f10525p;

    /* renamed from: q, reason: collision with root package name */
    public final int f10526q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public final int f10527s;

    /* renamed from: t, reason: collision with root package name */
    public final int f10528t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f10529u;

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    public final boolean c() {
        return getLayoutDirection() == 1;
    }

    public final void d(int i3, int i10) {
        RectF rectF = this.e;
        rectF.set(getPaddingLeft(), getPaddingTop(), i3 - getPaddingRight(), i10 - getPaddingBottom());
        m mVar = this.f10521l;
        Path path = this.f10518i;
        this.f10514d.a(mVar, 1.0f, rectF, null, path);
        Path path2 = this.f10523n;
        path2.rewind();
        path2.addPath(path);
        RectF rectF2 = this.f10515f;
        rectF2.set(0.0f, 0.0f, i3, i10);
        path2.addRect(rectF2, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.r;
    }

    public final int getContentPaddingEnd() {
        int i3 = this.f10528t;
        return i3 != Integer.MIN_VALUE ? i3 : c() ? this.f10524o : this.f10526q;
    }

    public int getContentPaddingLeft() {
        int i3;
        int i10;
        if (this.f10527s != Integer.MIN_VALUE || this.f10528t != Integer.MIN_VALUE) {
            if (c() && (i10 = this.f10528t) != Integer.MIN_VALUE) {
                return i10;
            }
            if (!c() && (i3 = this.f10527s) != Integer.MIN_VALUE) {
                return i3;
            }
        }
        return this.f10524o;
    }

    public int getContentPaddingRight() {
        int i3;
        int i10;
        if (this.f10527s != Integer.MIN_VALUE || this.f10528t != Integer.MIN_VALUE) {
            if (c() && (i10 = this.f10527s) != Integer.MIN_VALUE) {
                return i10;
            }
            if (!c() && (i3 = this.f10528t) != Integer.MIN_VALUE) {
                return i3;
            }
        }
        return this.f10526q;
    }

    public final int getContentPaddingStart() {
        int i3 = this.f10527s;
        return i3 != Integer.MIN_VALUE ? i3 : c() ? this.f10526q : this.f10524o;
    }

    public int getContentPaddingTop() {
        return this.f10525p;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public m getShapeAppearanceModel() {
        return this.f10521l;
    }

    public ColorStateList getStrokeColor() {
        return this.f10519j;
    }

    public float getStrokeWidth() {
        return this.f10522m;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f10523n, this.f10517h);
        if (this.f10519j == null) {
            return;
        }
        Paint paint = this.f10516g;
        paint.setStrokeWidth(this.f10522m);
        int colorForState = this.f10519j.getColorForState(getDrawableState(), this.f10519j.getDefaultColor());
        if (this.f10522m <= 0.0f || colorForState == 0) {
            return;
        }
        paint.setColor(colorForState);
        canvas.drawPath(this.f10518i, paint);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        if (!this.f10529u && isLayoutDirectionResolved()) {
            this.f10529u = true;
            if (!isPaddingRelative() && this.f10527s == Integer.MIN_VALUE && this.f10528t == Integer.MIN_VALUE) {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            } else {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i10, int i11, int i12) {
        super.onSizeChanged(i3, i10, i11, i12);
        d(i3, i10);
    }

    @Override // android.view.View
    public final void setPadding(int i3, int i10, int i11, int i12) {
        super.setPadding(getContentPaddingLeft() + i3, getContentPaddingTop() + i10, getContentPaddingRight() + i11, getContentPaddingBottom() + i12);
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i3, int i10, int i11, int i12) {
        super.setPaddingRelative(getContentPaddingStart() + i3, getContentPaddingTop() + i10, getContentPaddingEnd() + i11, getContentPaddingBottom() + i12);
    }

    @Override // eb.x
    public void setShapeAppearanceModel(m mVar) {
        this.f10521l = mVar;
        h hVar = this.f10520k;
        if (hVar != null) {
            hVar.setShapeAppearanceModel(mVar);
        }
        d(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f10519j = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i3) {
        setStrokeColor(pb.a(getContext(), i3));
    }

    public void setStrokeWidth(float f2) {
        if (this.f10522m != f2) {
            this.f10522m = f2;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i3) {
        setStrokeWidth(getResources().getDimensionPixelSize(i3));
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ShapeableImageView(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r0 = com.google.android.material.imageview.ShapeableImageView.f10513v
            android.content.Context r7 = ib.a.a(r7, r8, r9, r0)
            r6.<init>(r7, r8, r9)
            eb.o r7 = eb.n.f12551a
            r6.f10514d = r7
            android.graphics.Path r7 = new android.graphics.Path
            r7.<init>()
            r6.f10518i = r7
            r7 = 0
            r6.f10529u = r7
            android.content.Context r1 = r6.getContext()
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r6.f10517h = r2
            r3 = 1
            r2.setAntiAlias(r3)
            r4 = -1
            r2.setColor(r4)
            android.graphics.PorterDuffXfermode r4 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.DST_OUT
            r4.<init>(r5)
            r2.setXfermode(r4)
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.e = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.f10515f = r2
            android.graphics.Path r2 = new android.graphics.Path
            r2.<init>()
            r6.f10523n = r2
            int[] r2 = com.google.android.material.R$styleable.ShapeableImageView
            android.content.res.TypedArray r2 = r1.obtainStyledAttributes(r8, r2, r9, r0)
            int r4 = com.google.android.material.R$styleable.ShapeableImageView_strokeColor
            android.content.res.ColorStateList r4 = com.google.android.gms.internal.mlkit_vision_barcode.t0.a(r1, r2, r4)
            r6.f10519j = r4
            int r4 = com.google.android.material.R$styleable.ShapeableImageView_strokeWidth
            int r4 = r2.getDimensionPixelSize(r4, r7)
            float r4 = (float) r4
            r6.f10522m = r4
            int r4 = com.google.android.material.R$styleable.ShapeableImageView_contentPadding
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.f10524o = r7
            r6.f10525p = r7
            r6.f10526q = r7
            r6.r = r7
            int r4 = com.google.android.material.R$styleable.ShapeableImageView_contentPaddingLeft
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f10524o = r4
            int r4 = com.google.android.material.R$styleable.ShapeableImageView_contentPaddingTop
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f10525p = r4
            int r4 = com.google.android.material.R$styleable.ShapeableImageView_contentPaddingRight
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f10526q = r4
            int r4 = com.google.android.material.R$styleable.ShapeableImageView_contentPaddingBottom
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.r = r7
            int r7 = com.google.android.material.R$styleable.ShapeableImageView_contentPaddingStart
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.f10527s = r7
            int r7 = com.google.android.material.R$styleable.ShapeableImageView_contentPaddingEnd
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.f10528t = r7
            r2.recycle()
            android.graphics.Paint r7 = new android.graphics.Paint
            r7.<init>()
            r6.f10516g = r7
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE
            r7.setStyle(r2)
            r7.setAntiAlias(r3)
            eb.l r7 = eb.m.b(r1, r8, r9, r0)
            eb.m r7 = r7.a()
            r6.f10521l = r7
            xa.a r7 = new xa.a
            r7.<init>(r6)
            r6.setOutlineProvider(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.imageview.ShapeableImageView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
