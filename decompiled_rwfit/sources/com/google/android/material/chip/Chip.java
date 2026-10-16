package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import bb.e;
import com.example.test.utils.s0;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_barcode.rb;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.internal.q;
import d1.h;
import eb.m;
import eb.x;
import j1.g;
import j1.i;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;
import java.util.WeakHashMap;
import l1.h0;
import l1.i0;
import l1.z0;
import qa.a;
import qa.b;
import qa.c;

/* loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements b, x {

    /* renamed from: u, reason: collision with root package name */
    public static final int f10361u = R$style.Widget_MaterialComponents_Chip_Action;

    /* renamed from: v, reason: collision with root package name */
    public static final Rect f10362v = new Rect();

    /* renamed from: w, reason: collision with root package name */
    public static final int[] f10363w = {R.attr.state_selected};

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f10364x = {R.attr.state_checkable};
    public c e;

    /* renamed from: f, reason: collision with root package name */
    public InsetDrawable f10365f;

    /* renamed from: g, reason: collision with root package name */
    public RippleDrawable f10366g;

    /* renamed from: h, reason: collision with root package name */
    public View.OnClickListener f10367h;

    /* renamed from: i, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f10368i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10369j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10370k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10371l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10372m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10373n;

    /* renamed from: o, reason: collision with root package name */
    public int f10374o;

    /* renamed from: p, reason: collision with root package name */
    public int f10375p;

    /* renamed from: q, reason: collision with root package name */
    public final a f10376q;
    public final Rect r;

    /* renamed from: s, reason: collision with root package name */
    public final RectF f10377s;

    /* renamed from: t, reason: collision with root package name */
    public final q f10378t;

    public Chip(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        RectF rectF = this.f10377s;
        rectF.setEmpty();
        if (d() && this.f10367h != null) {
            c cVar = this.e;
            Rect bounds = cVar.getBounds();
            rectF.setEmpty();
            if (cVar.Z()) {
                float f2 = cVar.f17869d0 + cVar.f17867c0 + cVar.O + cVar.f17865b0 + cVar.f17863a0;
                if (d1.c.a(cVar) == 0) {
                    float f10 = bounds.right;
                    rectF.right = f10;
                    rectF.left = f10 - f2;
                } else {
                    float f11 = bounds.left;
                    rectF.left = f11;
                    rectF.right = f11 + f2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i3 = (int) closeIconTouchBounds.left;
        int i10 = (int) closeIconTouchBounds.top;
        int i11 = (int) closeIconTouchBounds.right;
        int i12 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.r;
        rect.set(i3, i10, i11, i12);
        return rect;
    }

    private e getTextAppearance() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.f17881k0.f10636f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z5) {
        if (this.f10371l != z5) {
            this.f10371l = z5;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z5) {
        if (this.f10370k != z5) {
            this.f10370k = z5;
            refreshDrawableState();
        }
    }

    public final void c(int i3) {
        this.f10375p = i3;
        if (!this.f10373n) {
            InsetDrawable insetDrawable = this.f10365f;
            if (insetDrawable == null) {
                int[] iArr = cb.a.f3422a;
                g();
                return;
            } else {
                if (insetDrawable != null) {
                    this.f10365f = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr2 = cb.a.f3422a;
                    g();
                    return;
                }
                return;
            }
        }
        int max = Math.max(0, i3 - ((int) this.e.f17888z));
        int max2 = Math.max(0, i3 - this.e.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            InsetDrawable insetDrawable2 = this.f10365f;
            if (insetDrawable2 == null) {
                int[] iArr3 = cb.a.f3422a;
                g();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.f10365f = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr4 = cb.a.f3422a;
                    g();
                    return;
                }
                return;
            }
        }
        int i10 = max2 > 0 ? max2 / 2 : 0;
        int i11 = max > 0 ? max / 2 : 0;
        if (this.f10365f != null) {
            Rect rect = new Rect();
            this.f10365f.getPadding(rect);
            if (rect.top == i11 && rect.bottom == i11 && rect.left == i10 && rect.right == i10) {
                int[] iArr5 = cb.a.f3422a;
                g();
                return;
            }
        }
        if (getMinHeight() != i3) {
            setMinHeight(i3);
        }
        if (getMinWidth() != i3) {
            setMinWidth(i3);
        }
        this.f10365f = new InsetDrawable((Drawable) this.e, i10, i11, i10, i11);
        int[] iArr6 = cb.a.f3422a;
        g();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d() {
        /*
            r2 = this;
            qa.c r0 = r2.e
            if (r0 == 0) goto L13
            android.graphics.drawable.Drawable r0 = r0.L
            if (r0 == 0) goto Le
            boolean r1 = r0 instanceof d1.h
            if (r1 == 0) goto Lf
            d1.h r0 = (d1.h) r0
        Le:
            r0 = 0
        Lf:
            if (r0 == 0) goto L13
            r0 = 1
            return r0
        L13:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.d():boolean");
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        a aVar = this.f10376q;
        if (action == 10) {
            try {
                Field declaredField = p1.b.class.getDeclaredField("m");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(aVar)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = p1.b.class.getDeclaredMethod("y", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(aVar, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException e) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e);
            } catch (NoSuchFieldException e10) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e10);
            } catch (NoSuchMethodException e11) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e11);
            } catch (InvocationTargetException e12) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e12);
            }
        }
        return aVar.m(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        a aVar = this.f10376q;
        aVar.getClass();
        boolean z5 = false;
        int i3 = 0;
        z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                int i10 = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                if (keyCode == 19) {
                                    i10 = 33;
                                } else if (keyCode == 21) {
                                    i10 = 17;
                                } else if (keyCode != 22) {
                                    i10 = 130;
                                }
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z6 = false;
                                while (i3 < repeatCount && aVar.q(i10, null)) {
                                    i3++;
                                    z6 = true;
                                }
                                z5 = z6;
                                break;
                            }
                            break;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    int i11 = aVar.f17362l;
                    if (i11 != Integer.MIN_VALUE) {
                        aVar.s(i11, 16, null);
                    }
                    z5 = true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                z5 = aVar.q(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                z5 = aVar.q(1, null);
            }
        }
        if (!z5 || aVar.f17362l == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        int i3;
        super.drawableStateChanged();
        c cVar = this.e;
        boolean z5 = false;
        if (cVar != null && c.A(cVar.L)) {
            c cVar2 = this.e;
            ?? isEnabled = isEnabled();
            int i10 = isEnabled;
            if (this.f10372m) {
                i10 = isEnabled + 1;
            }
            int i11 = i10;
            if (this.f10371l) {
                i11 = i10 + 1;
            }
            int i12 = i11;
            if (this.f10370k) {
                i12 = i11 + 1;
            }
            int i13 = i12;
            if (isChecked()) {
                i13 = i12 + 1;
            }
            int[] iArr = new int[i13];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (this.f10372m) {
                iArr[i3] = 16842908;
                i3++;
            }
            if (this.f10371l) {
                iArr[i3] = 16843623;
                i3++;
            }
            if (this.f10370k) {
                iArr[i3] = 16842919;
                i3++;
            }
            if (isChecked()) {
                iArr[i3] = 16842913;
            }
            if (!Arrays.equals(cVar2.f17877h1, iArr)) {
                cVar2.f17877h1 = iArr;
                if (cVar2.Z()) {
                    z5 = cVar2.C(cVar2.getState(), iArr);
                }
            }
        }
        if (z5) {
            invalidate();
        }
    }

    public final boolean e() {
        c cVar = this.e;
        return cVar != null && cVar.Q;
    }

    public final void f() {
        c cVar;
        if (!d() || (cVar = this.e) == null || !cVar.K || this.f10367h == null) {
            z0.n(this, null);
        } else {
            z0.n(this, this.f10376q);
        }
    }

    public final void g() {
        this.f10366g = new RippleDrawable(cb.a.b(this.e.D), getBackgroundDrawable(), null);
        this.e.getClass();
        RippleDrawable rippleDrawable = this.f10366g;
        WeakHashMap weakHashMap = z0.f15748a;
        h0.q(this, rippleDrawable);
        h();
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f10365f;
        return insetDrawable == null ? this.e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.S;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.T;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.f17887y;
        }
        return null;
    }

    public float getChipCornerRadius() {
        c cVar = this.e;
        if (cVar != null) {
            return Math.max(0.0f, cVar.y());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.e;
    }

    public float getChipEndPadding() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.f17869d0;
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getChipIcon() {
        Drawable drawable;
        c cVar = this.e;
        if (cVar == null || (drawable = cVar.G) == 0) {
            return null;
        }
        if (!(drawable instanceof h)) {
            return drawable;
        }
        return null;
    }

    public float getChipIconSize() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.I;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.H;
        }
        return null;
    }

    public float getChipMinHeight() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.f17888z;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.W;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.B;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.C;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getCloseIcon() {
        Drawable drawable;
        c cVar = this.e;
        if (cVar == null || (drawable = cVar.L) == 0) {
            return null;
        }
        if (!(drawable instanceof h)) {
            return drawable;
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.P;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.f17867c0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.O;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.f17865b0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.N;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.f17882k1;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        a aVar = this.f10376q;
        if (aVar.f17362l == 1 || aVar.f17361k == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public ja.e getHideMotionSpec() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.V;
        }
        return null;
    }

    public float getIconEndPadding() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.Y;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.X;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.D;
        }
        return null;
    }

    public m getShapeAppearanceModel() {
        return this.e.f12505a.f12488a;
    }

    public ja.e getShowMotionSpec() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.U;
        }
        return null;
    }

    public float getTextEndPadding() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.f17863a0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.Z;
        }
        return 0.0f;
    }

    public final void h() {
        c cVar;
        if (TextUtils.isEmpty(getText()) || (cVar = this.e) == null) {
            return;
        }
        int x10 = (int) (cVar.x() + cVar.f17869d0 + cVar.f17863a0);
        c cVar2 = this.e;
        int w8 = (int) (cVar2.w() + cVar2.W + cVar2.Z);
        if (this.f10365f != null) {
            Rect rect = new Rect();
            this.f10365f.getPadding(rect);
            w8 += rect.left;
            x10 += rect.right;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        WeakHashMap weakHashMap = z0.f15748a;
        i0.k(this, w8, paddingTop, x10, paddingBottom);
    }

    public final void i() {
        TextPaint paint = getPaint();
        c cVar = this.e;
        if (cVar != null) {
            paint.drawableState = cVar.getState();
        }
        e textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.e(getContext(), paint, this.f10378t);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        rb.c(this, this.e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f10363w);
        }
        if (e()) {
            View.mergeDrawableStates(onCreateDrawableState, f10364x);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z5, int i3, Rect rect) {
        super.onFocusChanged(z5, i3, rect);
        a aVar = this.f10376q;
        int i10 = aVar.f17362l;
        if (i10 != Integer.MIN_VALUE) {
            aVar.j(i10);
        }
        if (z5) {
            aVar.q(i3, rect);
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i3;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (e() || isClickable()) {
            accessibilityNodeInfo.setClassName(e() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            accessibilityNodeInfo.setClassName("android.view.View");
        }
        accessibilityNodeInfo.setCheckable(e());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (chipGroup.f10537c) {
                i3 = 0;
                for (int i10 = 0; i10 < chipGroup.getChildCount(); i10++) {
                    if (chipGroup.getChildAt(i10) instanceof Chip) {
                        if (((Chip) chipGroup.getChildAt(i10)) == this) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
            i3 = -1;
            Object tag = getTag(R$id.row_index_key);
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) com.example.test.ui.device.activity.i0.o(tag instanceof Integer ? ((Integer) tag).intValue() : -1, 1, i3, 1, isChecked()).f7866b);
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i3) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        if (this.f10374o != i3) {
            this.f10374o = i3;
            h();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r0 != 3) goto L25;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L46
            if (r0 == r3) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L41
            goto L4c
        L21:
            boolean r0 = r5.f10370k
            if (r0 == 0) goto L4c
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r2)
        L2a:
            r0 = r3
            goto L4d
        L2c:
            boolean r0 = r5.f10370k
            if (r0 == 0) goto L41
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r0 = r5.f10367h
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            qa.a r0 = r5.f10376q
            r0.x(r3, r3)
            r0 = r3
            goto L42
        L41:
            r0 = r2
        L42:
            r5.setCloseIconPressed(r2)
            goto L4d
        L46:
            if (r1 == 0) goto L4c
            r5.setCloseIconPressed(r3)
            goto L2a
        L4c:
            r0 = r2
        L4d:
            if (r0 != 0) goto L57
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L56
            goto L57
        L56:
            return r2
        L57:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f10366g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f10366g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i3) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z5) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.D(z5);
        }
    }

    public void setCheckableResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.D(cVar.f17871e0.getResources().getBoolean(i3));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z5) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        c cVar = this.e;
        if (cVar == null) {
            this.f10369j = z5;
            return;
        }
        if (cVar.Q) {
            boolean isChecked = isChecked();
            super.setChecked(z5);
            if (isChecked == z5 || (onCheckedChangeListener = this.f10368i) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z5);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.E(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z5) {
        setCheckedIconVisible(z5);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i3) {
        setCheckedIconVisible(i3);
    }

    public void setCheckedIconResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.E(pb.b(cVar.f17871e0, i3));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.F(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.F(pb.a(cVar.f17871e0, i3));
        }
    }

    public void setCheckedIconVisible(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.G(cVar.f17871e0.getResources().getBoolean(i3));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        c cVar = this.e;
        if (cVar == null || cVar.f17887y == colorStateList) {
            return;
        }
        cVar.f17887y = colorStateList;
        cVar.onStateChange(cVar.getState());
    }

    public void setChipBackgroundColorResource(int i3) {
        ColorStateList a3;
        c cVar = this.e;
        if (cVar == null || cVar.f17887y == (a3 = pb.a(cVar.f17871e0, i3))) {
            return;
        }
        cVar.f17887y = a3;
        cVar.onStateChange(cVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.H(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.H(cVar.f17871e0.getResources().getDimension(i3));
        }
    }

    public void setChipDrawable(c cVar) {
        c cVar2 = this.e;
        if (cVar2 != cVar) {
            if (cVar2 != null) {
                cVar2.f17880j1 = new WeakReference(null);
            }
            this.e = cVar;
            cVar.f17883l1 = false;
            cVar.f17880j1 = new WeakReference(this);
            c(this.f10375p);
        }
    }

    public void setChipEndPadding(float f2) {
        c cVar = this.e;
        if (cVar == null || cVar.f17869d0 == f2) {
            return;
        }
        cVar.f17869d0 = f2;
        cVar.invalidateSelf();
        cVar.B();
    }

    public void setChipEndPaddingResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            float dimension = cVar.f17871e0.getResources().getDimension(i3);
            if (cVar.f17869d0 != dimension) {
                cVar.f17869d0 = dimension;
                cVar.invalidateSelf();
                cVar.B();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.I(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z5) {
        setChipIconVisible(z5);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i3) {
        setChipIconVisible(i3);
    }

    public void setChipIconResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.I(pb.b(cVar.f17871e0, i3));
        }
    }

    public void setChipIconSize(float f2) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.J(f2);
        }
    }

    public void setChipIconSizeResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.J(cVar.f17871e0.getResources().getDimension(i3));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.K(colorStateList);
        }
    }

    public void setChipIconTintResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.K(pb.a(cVar.f17871e0, i3));
        }
    }

    public void setChipIconVisible(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.L(cVar.f17871e0.getResources().getBoolean(i3));
        }
    }

    public void setChipMinHeight(float f2) {
        c cVar = this.e;
        if (cVar == null || cVar.f17888z == f2) {
            return;
        }
        cVar.f17888z = f2;
        cVar.invalidateSelf();
        cVar.B();
    }

    public void setChipMinHeightResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            float dimension = cVar.f17871e0.getResources().getDimension(i3);
            if (cVar.f17888z != dimension) {
                cVar.f17888z = dimension;
                cVar.invalidateSelf();
                cVar.B();
            }
        }
    }

    public void setChipStartPadding(float f2) {
        c cVar = this.e;
        if (cVar == null || cVar.W == f2) {
            return;
        }
        cVar.W = f2;
        cVar.invalidateSelf();
        cVar.B();
    }

    public void setChipStartPaddingResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            float dimension = cVar.f17871e0.getResources().getDimension(i3);
            if (cVar.W != dimension) {
                cVar.W = dimension;
                cVar.invalidateSelf();
                cVar.B();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.M(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.M(pb.a(cVar.f17871e0, i3));
        }
    }

    public void setChipStrokeWidth(float f2) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.N(f2);
        }
    }

    public void setChipStrokeWidthResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.N(cVar.f17871e0.getResources().getDimension(i3));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i3) {
        setText(getResources().getString(i3));
    }

    public void setCloseIcon(Drawable drawable) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.O(drawable);
        }
        f();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        c cVar = this.e;
        if (cVar == null || cVar.P == charSequence) {
            return;
        }
        String str = j1.b.f15168b;
        Locale locale = Locale.getDefault();
        int i3 = i.f15181a;
        j1.b bVar = j1.h.a(locale) == 1 ? j1.b.e : j1.b.f15170d;
        bVar.getClass();
        s0 s0Var = g.f15177a;
        cVar.P = bVar.c(charSequence);
        cVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z5) {
        setCloseIconVisible(z5);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i3) {
        setCloseIconVisible(i3);
    }

    public void setCloseIconEndPadding(float f2) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.P(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.P(cVar.f17871e0.getResources().getDimension(i3));
        }
    }

    public void setCloseIconResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.O(pb.b(cVar.f17871e0, i3));
        }
        f();
    }

    public void setCloseIconSize(float f2) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.Q(f2);
        }
    }

    public void setCloseIconSizeResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.Q(cVar.f17871e0.getResources().getDimension(i3));
        }
    }

    public void setCloseIconStartPadding(float f2) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.R(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.R(cVar.f17871e0.getResources().getDimension(i3));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.S(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.S(pb.a(cVar.f17871e0, i3));
        }
    }

    public void setCloseIconVisible(int i3) {
        setCloseIconVisible(getResources().getBoolean(i3));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i3, int i10, int i11, int i12) {
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i11 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i3, i10, i11, i12);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i3, int i10, int i11, int i12) {
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i11 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i3, i10, i11, i12);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        c cVar = this.e;
        if (cVar != null) {
            cVar.k(f2);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        c cVar = this.e;
        if (cVar != null) {
            cVar.f17882k1 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z5) {
        this.f10373n = z5;
        c(this.f10375p);
    }

    @Override // android.widget.TextView
    public void setGravity(int i3) {
        if (i3 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i3);
        }
    }

    public void setHideMotionSpec(ja.e eVar) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.V = eVar;
        }
    }

    public void setHideMotionSpecResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.V = ja.e.b(cVar.f17871e0, i3);
        }
    }

    public void setIconEndPadding(float f2) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.U(f2);
        }
    }

    public void setIconEndPaddingResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.U(cVar.f17871e0.getResources().getDimension(i3));
        }
    }

    public void setIconStartPadding(float f2) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.V(f2);
        }
    }

    public void setIconStartPaddingResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.V(cVar.f17871e0.getResources().getDimension(i3));
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i3) {
        if (this.e == null) {
            return;
        }
        super.setLayoutDirection(i3);
    }

    @Override // android.widget.TextView
    public void setLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i3);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i3);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i3) {
        super.setMaxWidth(i3);
        c cVar = this.e;
        if (cVar != null) {
            cVar.f17884m1 = i3;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i3);
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f10368i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f10367h = onClickListener;
        f();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.W(colorStateList);
        }
        this.e.getClass();
        g();
    }

    public void setRippleColorResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.W(pb.a(cVar.f17871e0, i3));
            this.e.getClass();
            g();
        }
    }

    @Override // eb.x
    public void setShapeAppearanceModel(m mVar) {
        this.e.setShapeAppearanceModel(mVar);
    }

    public void setShowMotionSpec(ja.e eVar) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.U = eVar;
        }
    }

    public void setShowMotionSpecResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.U = ja.e.b(cVar.f17871e0, i3);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z5) {
        if (!z5) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z5);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        c cVar = this.e;
        if (cVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(cVar.f17883l1 ? null : charSequence, bufferType);
        c cVar2 = this.e;
        if (cVar2 == null || TextUtils.equals(cVar2.E, charSequence)) {
            return;
        }
        cVar2.E = charSequence;
        cVar2.f17881k0.f10635d = true;
        cVar2.invalidateSelf();
        cVar2.B();
    }

    public void setTextAppearance(e eVar) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.f17881k0.b(eVar, cVar.f17871e0);
        }
        i();
    }

    public void setTextAppearanceResource(int i3) {
        setTextAppearance(getContext(), i3);
    }

    public void setTextEndPadding(float f2) {
        c cVar = this.e;
        if (cVar == null || cVar.f17863a0 == f2) {
            return;
        }
        cVar.f17863a0 = f2;
        cVar.invalidateSelf();
        cVar.B();
    }

    public void setTextEndPaddingResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            float dimension = cVar.f17871e0.getResources().getDimension(i3);
            if (cVar.f17863a0 != dimension) {
                cVar.f17863a0 = dimension;
                cVar.invalidateSelf();
                cVar.B();
            }
        }
    }

    public void setTextStartPadding(float f2) {
        c cVar = this.e;
        if (cVar == null || cVar.Z == f2) {
            return;
        }
        cVar.Z = f2;
        cVar.invalidateSelf();
        cVar.B();
    }

    public void setTextStartPaddingResource(int i3) {
        c cVar = this.e;
        if (cVar != null) {
            float dimension = cVar.f17871e0.getResources().getDimension(i3);
            if (cVar.Z != dimension) {
                cVar.Z = dimension;
                cVar.invalidateSelf();
                cVar.B();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipStyle);
    }

    public void setCloseIconVisible(boolean z5) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.T(z5);
        }
        f();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Chip(android.content.Context r17, android.util.AttributeSet r18, int r19) {
        /*
            Method dump skipped, instructions count: 924
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedIconVisible(boolean z5) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.G(z5);
        }
    }

    public void setChipIconVisible(boolean z5) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.L(z5);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        c cVar = this.e;
        if (cVar != null) {
            Context context2 = cVar.f17871e0;
            cVar.f17881k0.b(new e(context2, i3), context2);
        }
        i();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i3) {
        super.setTextAppearance(i3);
        c cVar = this.e;
        if (cVar != null) {
            Context context = cVar.f17871e0;
            cVar.f17881k0.b(new e(context, i3), context);
        }
        i();
    }
}
