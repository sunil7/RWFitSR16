package com.google.android.material.floatingactionbutton;

import ab.g;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;
import wa.c;
import wa.d;
import wa.e;
import x0.b;
import x0.f;

/* loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements b {
    public static final int G = R$style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    public static final g H;
    public static final g I;
    public static final g J;
    public static final g K;
    public int A;
    public final ExtendedFloatingActionButtonBehavior B;
    public boolean C;
    public boolean D;
    public boolean E;
    public ColorStateList F;

    /* renamed from: t, reason: collision with root package name */
    public int f10485t;

    /* renamed from: u, reason: collision with root package name */
    public final c f10486u;

    /* renamed from: v, reason: collision with root package name */
    public final c f10487v;

    /* renamed from: w, reason: collision with root package name */
    public final e f10488w;

    /* renamed from: x, reason: collision with root package name */
    public final d f10489x;

    /* renamed from: y, reason: collision with root package name */
    public final int f10490y;

    /* renamed from: z, reason: collision with root package name */
    public int f10491z;

    static {
        Class<Float> cls = Float.class;
        H = new g(16, cls, "width");
        I = new g(17, cls, "height");
        J = new g(18, cls, "paddingStart");
        K = new g(19, cls, "paddingEnd");
    }

    public ExtendedFloatingActionButton(Context context) {
        this(context, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        if (r4.E == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r4, wa.a r5) {
        /*
            r0 = 1
            boolean r1 = r5.h()
            if (r1 == 0) goto L8
            return
        L8:
            java.util.WeakHashMap r1 = l1.z0.f15748a
            boolean r1 = l1.k0.c(r4)
            if (r1 != 0) goto L25
            int r1 = r4.getVisibility()
            if (r1 == 0) goto L1c
            int r1 = r4.f10485t
            r2 = 2
            if (r1 != r2) goto L21
            goto L54
        L1c:
            int r1 = r4.f10485t
            if (r1 == r0) goto L21
            goto L54
        L21:
            boolean r1 = r4.E
            if (r1 == 0) goto L54
        L25:
            boolean r1 = r4.isInEditMode()
            if (r1 != 0) goto L54
            r1 = 0
            r4.measure(r1, r1)
            android.animation.AnimatorSet r4 = r5.a()
            ab.q r2 = new ab.q
            r3 = 11
            r2.<init>(r5, r3)
            r4.addListener(r2)
            java.util.ArrayList r5 = r5.f19526c
            int r2 = r5.size()
        L43:
            if (r1 >= r2) goto L50
            java.lang.Object r3 = r5.get(r1)
            int r1 = r1 + r0
            android.animation.Animator$AnimatorListener r3 = (android.animation.Animator.AnimatorListener) r3
            r4.addListener(r3)
            goto L43
        L50:
            r4.start()
            return
        L54:
            r5.g()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.e(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton, wa.a):void");
    }

    public final void f(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // x0.b
    public x0.c getBehavior() {
        return this.B;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        int i3 = this.f10490y;
        if (i3 >= 0) {
            return i3;
        }
        WeakHashMap weakHashMap = z0.f15748a;
        return getIconSize() + (Math.min(i0.f(this), i0.e(this)) * 2);
    }

    public ja.e getExtendMotionSpec() {
        return this.f10487v.f19528f;
    }

    public ja.e getHideMotionSpec() {
        return this.f10489x.f19528f;
    }

    public ja.e getShowMotionSpec() {
        return this.f10488w.f19528f;
    }

    public ja.e getShrinkMotionSpec() {
        return this.f10486u.f19528f;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.C && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.C = false;
            this.f10486u.g();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z5) {
        this.E = z5;
    }

    public void setExtendMotionSpec(ja.e eVar) {
        this.f10487v.f19528f = eVar;
    }

    public void setExtendMotionSpecResource(int i3) {
        setExtendMotionSpec(ja.e.b(getContext(), i3));
    }

    public void setExtended(boolean z5) {
        if (this.C == z5) {
            return;
        }
        c cVar = z5 ? this.f10487v : this.f10486u;
        if (cVar.h()) {
            return;
        }
        cVar.g();
    }

    public void setHideMotionSpec(ja.e eVar) {
        this.f10489x.f19528f = eVar;
    }

    public void setHideMotionSpecResource(int i3) {
        setHideMotionSpec(ja.e.b(getContext(), i3));
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i3, int i10, int i11, int i12) {
        super.setPadding(i3, i10, i11, i12);
        if (!this.C || this.D) {
            return;
        }
        WeakHashMap weakHashMap = z0.f15748a;
        this.f10491z = i0.f(this);
        this.A = i0.e(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPaddingRelative(int i3, int i10, int i11, int i12) {
        super.setPaddingRelative(i3, i10, i11, i12);
        if (!this.C || this.D) {
            return;
        }
        this.f10491z = i3;
        this.A = i11;
    }

    public void setShowMotionSpec(ja.e eVar) {
        this.f10488w.f19528f = eVar;
    }

    public void setShowMotionSpecResource(int i3) {
        setShowMotionSpec(ja.e.b(getContext(), i3));
    }

    public void setShrinkMotionSpec(ja.e eVar) {
        this.f10486u.f19528f = eVar;
    }

    public void setShrinkMotionSpecResource(int i3) {
        setShrinkMotionSpec(ja.e.b(getContext(), i3));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i3) {
        super.setTextColor(i3);
        this.F = getTextColors();
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.extendedFloatingActionButtonStyle);
    }

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends x0.c {

        /* renamed from: a, reason: collision with root package name */
        public Rect f10492a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10493b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f10494c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f10493b = false;
            this.f10494c = true;
        }

        @Override // x0.c
        public final /* bridge */ /* synthetic */ boolean a(View view, Rect rect) {
            return false;
        }

        @Override // x0.c
        public final void c(f fVar) {
            if (fVar.f19722h == 0) {
                fVar.f19722h = 80;
            }
        }

        @Override // x0.c
        public final boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                s(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof f ? ((f) layoutParams).f19716a instanceof BottomSheetBehavior : false) {
                    t(view2, extendedFloatingActionButton);
                }
            }
            return false;
        }

        @Override // x0.c
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i3) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            ArrayList o3 = coordinatorLayout.o(extendedFloatingActionButton);
            int size = o3.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view2 = (View) o3.get(i10);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof f ? ((f) layoutParams).f19716a instanceof BottomSheetBehavior : false) && t(view2, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (s(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.v(i3, extendedFloatingActionButton);
            return true;
        }

        public final boolean s(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            f fVar = (f) extendedFloatingActionButton.getLayoutParams();
            if ((!this.f10493b && !this.f10494c) || fVar.f19720f != appBarLayout.getId()) {
                return false;
            }
            if (this.f10492a == null) {
                this.f10492a = new Rect();
            }
            Rect rect = this.f10492a;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                ExtendedFloatingActionButton.e(extendedFloatingActionButton, this.f10494c ? extendedFloatingActionButton.f10486u : extendedFloatingActionButton.f10489x);
                return true;
            }
            ExtendedFloatingActionButton.e(extendedFloatingActionButton, this.f10494c ? extendedFloatingActionButton.f10487v : extendedFloatingActionButton.f10488w);
            return true;
        }

        public final boolean t(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            f fVar = (f) extendedFloatingActionButton.getLayoutParams();
            if ((!this.f10493b && !this.f10494c) || fVar.f19720f != view.getId()) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                ExtendedFloatingActionButton.e(extendedFloatingActionButton, this.f10494c ? extendedFloatingActionButton.f10486u : extendedFloatingActionButton.f10489x);
                return true;
            }
            ExtendedFloatingActionButton.e(extendedFloatingActionButton, this.f10494c ? extendedFloatingActionButton.f10487v : extendedFloatingActionButton.f10488w);
            return true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f10493b = obtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f10494c = obtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ExtendedFloatingActionButton(android.content.Context r18, android.util.AttributeSet r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r2 = r19
            r4 = r20
            r7 = 20
            int r5 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.G
            r1 = r18
            android.content.Context r1 = ib.a.a(r1, r2, r4, r5)
            r0.<init>(r1, r2, r4)
            r8 = 0
            r0.f10485t = r8
            mc.g r1 = new mc.g
            r1.<init>(r7)
            wa.e r9 = new wa.e
            r9.<init>(r0, r1)
            r0.f10488w = r9
            wa.d r10 = new wa.d
            r10.<init>(r0, r1)
            r0.f10489x = r10
            r11 = 1
            r0.C = r11
            r0.D = r8
            r0.E = r8
            android.content.Context r1 = r0.getContext()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior r3 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior
            r3.<init>(r1, r2)
            r0.B = r3
            int[] r3 = com.google.android.material.R$styleable.ExtendedFloatingActionButton
            int[] r6 = new int[r8]
            android.content.res.TypedArray r3 = com.google.android.material.internal.w.d(r1, r2, r3, r4, r5, r6)
            int r6 = com.google.android.material.R$styleable.ExtendedFloatingActionButton_showMotionSpec
            ja.e r6 = ja.e.a(r1, r3, r6)
            int r12 = com.google.android.material.R$styleable.ExtendedFloatingActionButton_hideMotionSpec
            ja.e r12 = ja.e.a(r1, r3, r12)
            int r13 = com.google.android.material.R$styleable.ExtendedFloatingActionButton_extendMotionSpec
            ja.e r13 = ja.e.a(r1, r3, r13)
            int r14 = com.google.android.material.R$styleable.ExtendedFloatingActionButton_shrinkMotionSpec
            ja.e r14 = ja.e.a(r1, r3, r14)
            int r15 = com.google.android.material.R$styleable.ExtendedFloatingActionButton_collapsedSize
            r8 = -1
            int r8 = r3.getDimensionPixelSize(r15, r8)
            r0.f10490y = r8
            java.util.WeakHashMap r8 = l1.z0.f15748a
            int r8 = l1.i0.f(r0)
            r0.f10491z = r8
            int r8 = l1.i0.e(r0)
            r0.A = r8
            mc.g r8 = new mc.g
            r8.<init>(r7)
            wa.c r7 = new wa.c
            n6.a r15 = new n6.a
            r16 = r3
            r3 = 21
            r15.<init>(r0, r3)
            r7.<init>(r0, r8, r15, r11)
            r0.f10487v = r7
            wa.c r3 = new wa.c
            n.m0 r11 = new n.m0
            r15 = 25
            r11.<init>(r0, r15)
            r15 = 0
            r3.<init>(r0, r8, r11, r15)
            r0.f10486u = r3
            r9.f19528f = r6
            r10.f19528f = r12
            r7.f19528f = r13
            r3.f19528f = r14
            r16.recycle()
            eb.j r3 = eb.m.f12539m
            eb.l r1 = eb.m.c(r1, r2, r4, r5, r3)
            eb.m r1 = r1.a()
            r0.setShapeAppearanceModel(r1)
            android.content.res.ColorStateList r1 = r0.getTextColors()
            r0.F = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        this.F = getTextColors();
    }
}
