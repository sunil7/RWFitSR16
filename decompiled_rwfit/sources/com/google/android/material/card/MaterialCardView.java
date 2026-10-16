package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_barcode.rb;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import d1.b;
import eb.h;
import eb.m;
import eb.x;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;
import pa.a;
import pa.c;

/* loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, x {

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f10350l = {R.attr.state_checkable};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f10351m = {R.attr.state_checked};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f10352n = {R$attr.state_dragged};

    /* renamed from: o, reason: collision with root package name */
    public static final int f10353o = R$style.Widget_MaterialComponents_CardView;

    /* renamed from: h, reason: collision with root package name */
    public final c f10354h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f10355i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10356j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10357k;

    public MaterialCardView(Context context) {
        this(context, null);
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f10354h.f17484c.getBounds());
        return rectF;
    }

    public final void b() {
        c cVar;
        RippleDrawable rippleDrawable;
        if (Build.VERSION.SDK_INT <= 26 || (rippleDrawable = (cVar = this.f10354h).f17494n) == null) {
            return;
        }
        Rect bounds = rippleDrawable.getBounds();
        int i3 = bounds.bottom;
        cVar.f17494n.setBounds(bounds.left, bounds.top, bounds.right, i3 - 1);
        cVar.f17494n.setBounds(bounds.left, bounds.top, bounds.right, i3);
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.f10354h.f17484c.f12505a.f12490c;
    }

    public ColorStateList getCardForegroundColor() {
        return this.f10354h.f17485d.f12505a.f12490c;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f10354h.f17489i;
    }

    public int getCheckedIconMargin() {
        return this.f10354h.e;
    }

    public int getCheckedIconSize() {
        return this.f10354h.f17486f;
    }

    public ColorStateList getCheckedIconTint() {
        return this.f10354h.f17491k;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f10354h.f17483b.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f10354h.f17483b.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f10354h.f17483b.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f10354h.f17483b.top;
    }

    public float getProgress() {
        return this.f10354h.f17484c.f12505a.f12495i;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f10354h.f17484c.h();
    }

    public ColorStateList getRippleColor() {
        return this.f10354h.f17490j;
    }

    public m getShapeAppearanceModel() {
        return this.f10354h.f17492l;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f10354h.f17493m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f10354h.f17493m;
    }

    public int getStrokeWidth() {
        return this.f10354h.f17487g;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f10356j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        rb.c(this, this.f10354h.f17484c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 3);
        c cVar = this.f10354h;
        if (cVar != null && cVar.r) {
            View.mergeDrawableStates(onCreateDrawableState, f10350l);
        }
        if (this.f10356j) {
            View.mergeDrawableStates(onCreateDrawableState, f10351m);
        }
        if (this.f10357k) {
            View.mergeDrawableStates(onCreateDrawableState, f10352n);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.f10356j);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        c cVar = this.f10354h;
        accessibilityNodeInfo.setCheckable(cVar != null && cVar.r);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.f10356j);
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        int i11;
        int i12;
        super.onMeasure(i3, i10);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        c cVar = this.f10354h;
        if (cVar.f17495o != null) {
            int i13 = cVar.e;
            int i14 = cVar.f17486f;
            int i15 = (measuredWidth - i13) - i14;
            int i16 = (measuredHeight - i13) - i14;
            MaterialCardView materialCardView = cVar.f17482a;
            if (materialCardView.getUseCompatPadding()) {
                i16 -= (int) Math.ceil(((materialCardView.getMaxCardElevation() * 1.5f) + (cVar.g() ? cVar.a() : 0.0f)) * 2.0f);
                i15 -= (int) Math.ceil((materialCardView.getMaxCardElevation() + (cVar.g() ? cVar.a() : 0.0f)) * 2.0f);
            }
            int i17 = i16;
            int i18 = cVar.e;
            WeakHashMap weakHashMap = z0.f15748a;
            if (i0.d(materialCardView) == 1) {
                i12 = i15;
                i11 = i18;
            } else {
                i11 = i15;
                i12 = i18;
            }
            cVar.f17495o.setLayerInset(2, i11, cVar.e, i12, i17);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f10355i) {
            c cVar = this.f10354h;
            if (!cVar.f17497q) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                cVar.f17497q = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f10354h.f17484c.l(colorStateList);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        c cVar = this.f10354h;
        cVar.f17484c.k(cVar.f17482a.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        h hVar = this.f10354h.f17485d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        hVar.l(colorStateList);
    }

    public void setCheckable(boolean z5) {
        this.f10354h.r = z5;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z5) {
        if (this.f10356j != z5) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f10354h.e(drawable);
    }

    public void setCheckedIconMargin(int i3) {
        this.f10354h.e = i3;
    }

    public void setCheckedIconMarginResource(int i3) {
        if (i3 != -1) {
            this.f10354h.e = getResources().getDimensionPixelSize(i3);
        }
    }

    public void setCheckedIconResource(int i3) {
        this.f10354h.e(pb.b(getContext(), i3));
    }

    public void setCheckedIconSize(int i3) {
        this.f10354h.f17486f = i3;
    }

    public void setCheckedIconSizeResource(int i3) {
        if (i3 != 0) {
            this.f10354h.f17486f = getResources().getDimensionPixelSize(i3);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        c cVar = this.f10354h;
        cVar.f17491k = colorStateList;
        Drawable drawable = cVar.f17489i;
        if (drawable != null) {
            b.h(drawable, colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z5) {
        super.setClickable(z5);
        c cVar = this.f10354h;
        if (cVar != null) {
            Drawable drawable = cVar.f17488h;
            MaterialCardView materialCardView = cVar.f17482a;
            Drawable c9 = materialCardView.isClickable() ? cVar.c() : cVar.f17485d;
            cVar.f17488h = c9;
            if (drawable != c9) {
                if (materialCardView.getForeground() instanceof InsetDrawable) {
                    ((InsetDrawable) materialCardView.getForeground()).setDrawable(c9);
                } else {
                    materialCardView.setForeground(cVar.d(c9));
                }
            }
        }
    }

    public void setDragged(boolean z5) {
        if (this.f10357k != z5) {
            this.f10357k = z5;
            refreshDrawableState();
            b();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.f10354h.i();
    }

    public void setOnCheckedChangeListener(a aVar) {
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z5) {
        super.setPreventCornerOverlap(z5);
        c cVar = this.f10354h;
        cVar.i();
        cVar.h();
    }

    public void setProgress(float f2) {
        c cVar = this.f10354h;
        cVar.f17484c.m(f2);
        h hVar = cVar.f17485d;
        if (hVar != null) {
            hVar.m(f2);
        }
        h hVar2 = cVar.f17496p;
        if (hVar2 != null) {
            hVar2.m(f2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0036, code lost:
    
        if (r3.f12505a.f12488a.e(r3.f()) == false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0041  */
    @Override // androidx.cardview.widget.CardView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setRadius(float r3) {
        /*
            r2 = this;
            super.setRadius(r3)
            pa.c r0 = r2.f10354h
            eb.m r1 = r0.f17492l
            eb.l r1 = r1.f()
            r1.c(r3)
            eb.m r3 = r1.a()
            r0.f(r3)
            android.graphics.drawable.Drawable r3 = r0.f17488h
            r3.invalidateSelf()
            boolean r3 = r0.g()
            if (r3 != 0) goto L38
            com.google.android.material.card.MaterialCardView r3 = r0.f17482a
            boolean r3 = r3.getPreventCornerOverlap()
            if (r3 == 0) goto L3b
            eb.h r3 = r0.f17484c
            eb.g r1 = r3.f12505a
            eb.m r1 = r1.f12488a
            android.graphics.RectF r3 = r3.f()
            boolean r3 = r1.e(r3)
            if (r3 != 0) goto L3b
        L38:
            r0.h()
        L3b:
            boolean r3 = r0.g()
            if (r3 == 0) goto L44
            r0.i()
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.setRadius(float):void");
    }

    public void setRippleColor(ColorStateList colorStateList) {
        c cVar = this.f10354h;
        cVar.f17490j = colorStateList;
        int[] iArr = cb.a.f3422a;
        RippleDrawable rippleDrawable = cVar.f17494n;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    public void setRippleColorResource(int i3) {
        ColorStateList a3 = pb.a(getContext(), i3);
        c cVar = this.f10354h;
        cVar.f17490j = a3;
        int[] iArr = cb.a.f3422a;
        RippleDrawable rippleDrawable = cVar.f17494n;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(a3);
        }
    }

    @Override // eb.x
    public void setShapeAppearanceModel(m mVar) {
        setClipToOutline(mVar.e(getBoundsAsRectF()));
        this.f10354h.f(mVar);
    }

    public void setStrokeColor(int i3) {
        ColorStateList valueOf = ColorStateList.valueOf(i3);
        c cVar = this.f10354h;
        if (cVar.f17493m == valueOf) {
            return;
        }
        cVar.f17493m = valueOf;
        h hVar = cVar.f17485d;
        hVar.f12505a.f12496j = cVar.f17487g;
        hVar.invalidateSelf();
        hVar.q(valueOf);
    }

    public void setStrokeWidth(int i3) {
        c cVar = this.f10354h;
        if (i3 == cVar.f17487g) {
            return;
        }
        cVar.f17487g = i3;
        h hVar = cVar.f17485d;
        ColorStateList colorStateList = cVar.f17493m;
        hVar.f12505a.f12496j = i3;
        hVar.invalidateSelf();
        hVar.q(colorStateList);
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z5) {
        super.setUseCompatPadding(z5);
        c cVar = this.f10354h;
        cVar.i();
        cVar.h();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        c cVar = this.f10354h;
        if (cVar != null && cVar.r && isEnabled()) {
            this.f10356j = !this.f10356j;
            refreshDrawableState();
            b();
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialCardViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialCardView(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.card.MaterialCardView.f10353o
            android.content.Context r7 = ib.a.a(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            r7 = 0
            r6.f10356j = r7
            r6.f10357k = r7
            r0 = 1
            r6.f10355i = r0
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R$styleable.MaterialCardView
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.w.d(r0, r1, r2, r3, r4, r5)
            pa.c r9 = new pa.c
            r9.<init>(r6, r1, r3)
            r6.f10354h = r9
            android.content.res.ColorStateList r0 = super.getCardBackgroundColor()
            eb.h r1 = r9.f17484c
            r1.l(r0)
            int r0 = super.getContentPaddingLeft()
            int r2 = super.getContentPaddingTop()
            int r3 = super.getContentPaddingRight()
            int r4 = super.getContentPaddingBottom()
            android.graphics.Rect r5 = r9.f17483b
            r5.set(r0, r2, r3, r4)
            r9.h()
            com.google.android.material.card.MaterialCardView r0 = r9.f17482a
            android.content.Context r2 = r0.getContext()
            int r3 = com.google.android.material.R$styleable.MaterialCardView_strokeColor
            android.content.res.ColorStateList r2 = com.google.android.gms.internal.mlkit_vision_barcode.t0.a(r2, r8, r3)
            r9.f17493m = r2
            if (r2 != 0) goto L5e
            r2 = -1
            android.content.res.ColorStateList r2 = android.content.res.ColorStateList.valueOf(r2)
            r9.f17493m = r2
        L5e:
            int r2 = com.google.android.material.R$styleable.MaterialCardView_strokeWidth
            int r2 = r8.getDimensionPixelSize(r2, r7)
            r9.f17487g = r2
            int r2 = com.google.android.material.R$styleable.MaterialCardView_android_checkable
            boolean r2 = r8.getBoolean(r2, r7)
            r9.r = r2
            r0.setLongClickable(r2)
            android.content.Context r2 = r0.getContext()
            int r3 = com.google.android.material.R$styleable.MaterialCardView_checkedIconTint
            android.content.res.ColorStateList r2 = com.google.android.gms.internal.mlkit_vision_barcode.t0.a(r2, r8, r3)
            r9.f17491k = r2
            android.content.Context r2 = r0.getContext()
            int r3 = com.google.android.material.R$styleable.MaterialCardView_checkedIcon
            android.graphics.drawable.Drawable r2 = com.google.android.gms.internal.mlkit_vision_barcode.t0.d(r2, r8, r3)
            r9.e(r2)
            int r2 = com.google.android.material.R$styleable.MaterialCardView_checkedIconSize
            int r2 = r8.getDimensionPixelSize(r2, r7)
            r9.f17486f = r2
            int r2 = com.google.android.material.R$styleable.MaterialCardView_checkedIconMargin
            int r2 = r8.getDimensionPixelSize(r2, r7)
            r9.e = r2
            android.content.Context r2 = r0.getContext()
            int r3 = com.google.android.material.R$styleable.MaterialCardView_rippleColor
            android.content.res.ColorStateList r2 = com.google.android.gms.internal.mlkit_vision_barcode.t0.a(r2, r8, r3)
            r9.f17490j = r2
            if (r2 != 0) goto Lb4
            int r2 = com.google.android.material.R$attr.colorControlHighlight
            int r2 = com.google.android.gms.internal.mlkit_vision_common.x.b(r2, r0)
            android.content.res.ColorStateList r2 = android.content.res.ColorStateList.valueOf(r2)
            r9.f17490j = r2
        Lb4:
            android.content.Context r2 = r0.getContext()
            int r3 = com.google.android.material.R$styleable.MaterialCardView_cardForegroundColor
            android.content.res.ColorStateList r2 = com.google.android.gms.internal.mlkit_vision_barcode.t0.a(r2, r8, r3)
            eb.h r3 = r9.f17485d
            if (r2 != 0) goto Lc6
            android.content.res.ColorStateList r2 = android.content.res.ColorStateList.valueOf(r7)
        Lc6:
            r3.l(r2)
            int[] r7 = cb.a.f3422a
            android.graphics.drawable.RippleDrawable r7 = r9.f17494n
            if (r7 == 0) goto Ld4
            android.content.res.ColorStateList r2 = r9.f17490j
            r7.setColor(r2)
        Ld4:
            float r7 = r0.getCardElevation()
            r1.k(r7)
            int r7 = r9.f17487g
            float r7 = (float) r7
            android.content.res.ColorStateList r2 = r9.f17493m
            eb.g r4 = r3.f12505a
            r4.f12496j = r7
            r3.invalidateSelf()
            r3.q(r2)
            pa.b r7 = r9.d(r1)
            r0.setBackgroundInternal(r7)
            boolean r7 = r0.isClickable()
            if (r7 == 0) goto Lfb
            android.graphics.drawable.LayerDrawable r3 = r9.c()
        Lfb:
            r9.f17488h = r3
            pa.b r7 = r9.d(r3)
            r0.setForeground(r7)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i3) {
        this.f10354h.f17484c.l(ColorStateList.valueOf(i3));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        c cVar = this.f10354h;
        if (cVar.f17493m == colorStateList) {
            return;
        }
        cVar.f17493m = colorStateList;
        h hVar = cVar.f17485d;
        hVar.f12505a.f12496j = cVar.f17487g;
        hVar.invalidateSelf();
        hVar.q(colorStateList);
    }
}
