package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.q;
import androidx.customview.view.AbsSavedState;
import com.example.test.ui.device.activity.f0;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_barcode.rb;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import eb.l;
import eb.m;
import eb.x;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;

/* loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, x {

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f10300q = {R.attr.state_checkable};
    public static final int[] r = {R.attr.state_checked};

    /* renamed from: s, reason: collision with root package name */
    public static final int f10301s = R$style.Widget_MaterialComponents_Button;

    /* renamed from: d, reason: collision with root package name */
    public final d f10302d;
    public final LinkedHashSet e;

    /* renamed from: f, reason: collision with root package name */
    public b f10303f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f10304g;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f10305h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f10306i;

    /* renamed from: j, reason: collision with root package name */
    public int f10307j;

    /* renamed from: k, reason: collision with root package name */
    public int f10308k;

    /* renamed from: l, reason: collision with root package name */
    public int f10309l;

    /* renamed from: m, reason: collision with root package name */
    public int f10310m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10311n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f10312o;

    /* renamed from: p, reason: collision with root package name */
    public int f10313p;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new c();

        /* renamed from: a, reason: collision with root package name */
        public boolean f10314a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            this.f10314a = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f10314a ? 1 : 0);
        }
    }

    public MaterialButton(Context context) {
        this(context, null);
    }

    private String getA11yClassName() {
        d dVar = this.f10302d;
        return ((dVar == null || !dVar.f10340q) ? Button.class : CompoundButton.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    public final boolean a() {
        d dVar = this.f10302d;
        return (dVar == null || dVar.f10338o) ? false : true;
    }

    public void addOnCheckedChangeListener(a aVar) {
        this.e.add(aVar);
    }

    public final void b() {
        int i3 = this.f10313p;
        boolean z5 = true;
        if (i3 != 1 && i3 != 2) {
            z5 = false;
        }
        if (z5) {
            q.e(this, this.f10306i, null, null, null);
            return;
        }
        if (i3 == 3 || i3 == 4) {
            q.e(this, null, null, this.f10306i, null);
        } else if (i3 == 16 || i3 == 32) {
            q.e(this, null, this.f10306i, null, null);
        }
    }

    public final void c(boolean z5) {
        Drawable drawable = this.f10306i;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f10306i = mutate;
            d1.b.h(mutate, this.f10305h);
            PorterDuff.Mode mode = this.f10304g;
            if (mode != null) {
                d1.b.i(this.f10306i, mode);
            }
            int i3 = this.f10307j;
            if (i3 == 0) {
                i3 = this.f10306i.getIntrinsicWidth();
            }
            int i10 = this.f10307j;
            if (i10 == 0) {
                i10 = this.f10306i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f10306i;
            int i11 = this.f10308k;
            int i12 = this.f10309l;
            drawable2.setBounds(i11, i12, i3 + i11, i10 + i12);
        }
        if (z5) {
            b();
            return;
        }
        Drawable[] a3 = q.a(this);
        Drawable drawable3 = a3[0];
        Drawable drawable4 = a3[1];
        Drawable drawable5 = a3[2];
        int i13 = this.f10313p;
        if (((i13 == 1 || i13 == 2) && drawable3 != this.f10306i) || (((i13 == 3 || i13 == 4) && drawable5 != this.f10306i) || ((i13 == 16 || i13 == 32) && drawable4 != this.f10306i))) {
            b();
        }
    }

    public final void d(int i3, int i10) {
        if (this.f10306i == null || getLayout() == null) {
            return;
        }
        int i11 = this.f10313p;
        if (!(i11 == 1 || i11 == 2) && i11 != 3 && i11 != 4) {
            if (i11 == 16 || i11 == 32) {
                this.f10308k = 0;
                if (i11 == 16) {
                    this.f10309l = 0;
                    c(false);
                    return;
                }
                int i12 = this.f10307j;
                if (i12 == 0) {
                    i12 = this.f10306i.getIntrinsicHeight();
                }
                int textHeight = (((((i10 - getTextHeight()) - getPaddingTop()) - i12) - this.f10310m) - getPaddingBottom()) / 2;
                if (this.f10309l != textHeight) {
                    this.f10309l = textHeight;
                    c(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f10309l = 0;
        if (i11 == 1 || i11 == 3) {
            this.f10308k = 0;
            c(false);
            return;
        }
        int i13 = this.f10307j;
        if (i13 == 0) {
            i13 = this.f10306i.getIntrinsicWidth();
        }
        int textWidth = i3 - getTextWidth();
        WeakHashMap weakHashMap = z0.f15748a;
        int e = ((((textWidth - i0.e(this)) - i13) - this.f10310m) - i0.f(this)) / 2;
        if ((i0.d(this) == 1) != (this.f10313p == 4)) {
            e = -e;
        }
        if (this.f10308k != e) {
            this.f10308k = e;
            c(false);
        }
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (a()) {
            return this.f10302d.f10330g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f10306i;
    }

    public int getIconGravity() {
        return this.f10313p;
    }

    public int getIconPadding() {
        return this.f10310m;
    }

    public int getIconSize() {
        return this.f10307j;
    }

    public ColorStateList getIconTint() {
        return this.f10305h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f10304g;
    }

    public int getInsetBottom() {
        return this.f10302d.f10329f;
    }

    public int getInsetTop() {
        return this.f10302d.e;
    }

    public ColorStateList getRippleColor() {
        if (a()) {
            return this.f10302d.f10335l;
        }
        return null;
    }

    public m getShapeAppearanceModel() {
        if (a()) {
            return this.f10302d.f10326b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (a()) {
            return this.f10302d.f10334k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (a()) {
            return this.f10302d.f10331h;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        return a() ? this.f10302d.f10333j : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return a() ? this.f10302d.f10332i : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f10311n;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (a()) {
            rb.c(this, this.f10302d.b(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        d dVar = this.f10302d;
        if (dVar != null && dVar.f10340q) {
            View.mergeDrawableStates(onCreateDrawableState, f10300q);
        }
        if (this.f10311n) {
            View.mergeDrawableStates(onCreateDrawableState, r);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.f10311n);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        d dVar = this.f10302d;
        accessibilityNodeInfo.setCheckable(dVar != null && dVar.f10340q);
        accessibilityNodeInfo.setChecked(this.f10311n);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f10314a);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f10314a = this.f10311n;
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i10, int i11, int i12) {
        super.onSizeChanged(i3, i10, i11, i12);
        d(i3, i10);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        super.onTextChanged(charSequence, i3, i10, i11);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void removeOnCheckedChangeListener(a aVar) {
        this.e.remove(aVar);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        if (!a()) {
            super.setBackgroundColor(i3);
            return;
        }
        d dVar = this.f10302d;
        if (dVar.b(false) != null) {
            dVar.b(false).setTint(i3);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!a()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        d dVar = this.f10302d;
        dVar.f10338o = true;
        ColorStateList colorStateList = dVar.f10333j;
        MaterialButton materialButton = dVar.f10325a;
        materialButton.setSupportBackgroundTintList(colorStateList);
        materialButton.setSupportBackgroundTintMode(dVar.f10332i);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i3) {
        setBackgroundDrawable(i3 != 0 ? pb.b(getContext(), i3) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z5) {
        if (a()) {
            this.f10302d.f10340q = z5;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z5) {
        d dVar = this.f10302d;
        if (dVar == null || !dVar.f10340q || !isEnabled() || this.f10311n == z5) {
            return;
        }
        this.f10311n = z5;
        refreshDrawableState();
        if (this.f10312o) {
            return;
        }
        this.f10312o = true;
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            boolean z6 = this.f10311n;
            MaterialButtonToggleGroup materialButtonToggleGroup = ((g) aVar).f10345a;
            if (!materialButtonToggleGroup.f10321g) {
                if (materialButtonToggleGroup.f10322h) {
                    materialButtonToggleGroup.f10324j = z6 ? getId() : -1;
                }
                if (materialButtonToggleGroup.d(getId(), z6)) {
                    materialButtonToggleGroup.b(getId(), this.f10311n);
                }
                materialButtonToggleGroup.invalidate();
            }
        }
        this.f10312o = false;
    }

    public void setCornerRadius(int i3) {
        if (a()) {
            d dVar = this.f10302d;
            if (dVar.f10339p && dVar.f10330g == i3) {
                return;
            }
            dVar.f10330g = i3;
            dVar.f10339p = true;
            l f2 = dVar.f10326b.f();
            f2.c(i3);
            dVar.c(f2.a());
        }
    }

    public void setCornerRadiusResource(int i3) {
        if (a()) {
            setCornerRadius(getResources().getDimensionPixelSize(i3));
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (a()) {
            this.f10302d.b(false).k(f2);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f10306i != drawable) {
            this.f10306i = drawable;
            c(true);
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i3) {
        if (this.f10313p != i3) {
            this.f10313p = i3;
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i3) {
        if (this.f10310m != i3) {
            this.f10310m = i3;
            setCompoundDrawablePadding(i3);
        }
    }

    public void setIconResource(int i3) {
        setIcon(i3 != 0 ? pb.b(getContext(), i3) : null);
    }

    public void setIconSize(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f10307j != i3) {
            this.f10307j = i3;
            c(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f10305h != colorStateList) {
            this.f10305h = colorStateList;
            c(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f10304g != mode) {
            this.f10304g = mode;
            c(false);
        }
    }

    public void setIconTintResource(int i3) {
        setIconTint(pb.a(getContext(), i3));
    }

    public void setInsetBottom(int i3) {
        d dVar = this.f10302d;
        dVar.d(dVar.e, i3);
    }

    public void setInsetTop(int i3) {
        d dVar = this.f10302d;
        dVar.d(i3, dVar.f10329f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f10303f = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z5) {
        b bVar = this.f10303f;
        if (bVar != null) {
            ((MaterialButtonToggleGroup) ((f0) bVar).f7859b).invalidate();
        }
        super.setPressed(z5);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (a()) {
            d dVar = this.f10302d;
            if (dVar.f10335l != colorStateList) {
                dVar.f10335l = colorStateList;
                MaterialButton materialButton = dVar.f10325a;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(cb.a.b(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i3) {
        if (a()) {
            setRippleColor(pb.a(getContext(), i3));
        }
    }

    @Override // eb.x
    public void setShapeAppearanceModel(m mVar) {
        if (!a()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f10302d.c(mVar);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z5) {
        if (a()) {
            d dVar = this.f10302d;
            dVar.f10337n = z5;
            dVar.f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (a()) {
            d dVar = this.f10302d;
            if (dVar.f10334k != colorStateList) {
                dVar.f10334k = colorStateList;
                dVar.f();
            }
        }
    }

    public void setStrokeColorResource(int i3) {
        if (a()) {
            setStrokeColor(pb.a(getContext(), i3));
        }
    }

    public void setStrokeWidth(int i3) {
        if (a()) {
            d dVar = this.f10302d;
            if (dVar.f10331h != i3) {
                dVar.f10331h = i3;
                dVar.f();
            }
        }
    }

    public void setStrokeWidthResource(int i3) {
        if (a()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i3));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!a()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        d dVar = this.f10302d;
        if (dVar.f10333j != colorStateList) {
            dVar.f10333j = colorStateList;
            if (dVar.b(false) != null) {
                d1.b.h(dVar.b(false), dVar.f10333j);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!a()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        d dVar = this.f10302d;
        if (dVar.f10332i != mode) {
            dVar.f10332i = mode;
            if (dVar.b(false) == null || dVar.f10332i == null) {
                return;
            }
            d1.b.i(dVar.b(false), dVar.f10332i);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f10311n);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialButton(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
