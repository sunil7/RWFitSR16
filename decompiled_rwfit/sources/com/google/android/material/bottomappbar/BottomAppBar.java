package com.google.android.material.bottomappbar;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.s3;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.example.test.ui.device.activity.i0;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import com.google.android.gms.internal.mlkit_vision_barcode.rb;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import l1.k0;
import l1.z0;
import m0.k;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements x0.b {
    public static final int V0 = R$style.Widget_MaterialComponents_BottomAppBar;
    public final int R;
    public final eb.h S;
    public AnimatorSet T;
    public AnimatorSet U;
    public final i0 U0;
    public int V;
    public int W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f10233a0;

    /* renamed from: b0, reason: collision with root package name */
    public final boolean f10234b0;

    /* renamed from: c0, reason: collision with root package name */
    public final boolean f10235c0;

    /* renamed from: d0, reason: collision with root package name */
    public final boolean f10236d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f10237e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f10238f0;

    /* renamed from: g0, reason: collision with root package name */
    public Behavior f10239g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f10240h0;
    public int i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f10241j0;

    /* renamed from: k0, reason: collision with root package name */
    public final a f10242k0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new g();

        /* renamed from: a, reason: collision with root package name */
        public int f10246a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f10247b;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f10246a = parcel.readInt();
            this.f10247b = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f10246a);
            parcel.writeInt(this.f10247b ? 1 : 0);
        }
    }

    public BottomAppBar(Context context) {
        this(context, null, 0);
    }

    private ActionMenuView getActionMenuView() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f10240h0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return B(this.V);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().f10264f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f10241j0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.i0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h getTopEdgeTreatment() {
        return (h) this.S.f12505a.f12488a.f12547i;
    }

    public final int A(ActionMenuView actionMenuView, int i3, boolean z5) {
        if (i3 != 1 || !z5) {
            return 0;
        }
        boolean d5 = gb.d(this);
        int measuredWidth = d5 ? getMeasuredWidth() : 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if ((childAt.getLayoutParams() instanceof s3) && (((s3) childAt.getLayoutParams()).f1048a & 8388615) == 8388611) {
                measuredWidth = d5 ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((d5 ? actionMenuView.getRight() : actionMenuView.getLeft()) + (d5 ? this.i0 : -this.f10241j0));
    }

    public final float B(int i3) {
        boolean d5 = gb.d(this);
        if (i3 == 1) {
            return ((getMeasuredWidth() / 2) - (this.R + (d5 ? this.f10241j0 : this.i0))) * (d5 ? -1 : 1);
        }
        return 0.0f;
    }

    public final void C(int i3, boolean z5) {
        int i10 = 2;
        WeakHashMap weakHashMap = z0.f15748a;
        if (!k0.c(this)) {
            this.f10237e0 = false;
            return;
        }
        AnimatorSet animatorSet = this.U;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ArrayList arrayList = new ArrayList();
        View z6 = z();
        FloatingActionButton floatingActionButton = z6 instanceof FloatingActionButton ? (FloatingActionButton) z6 : null;
        if (floatingActionButton == null || !floatingActionButton.i()) {
            i3 = 0;
            z5 = false;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
            if (Math.abs(actionMenuView.getTranslationX() - A(actionMenuView, i3, z5)) > 1.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                ofFloat2.addListener(new d(this, actionMenuView, i3, z5));
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.setDuration(150L);
                animatorSet2.playSequentially(ofFloat2, ofFloat);
                arrayList.add(animatorSet2);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                arrayList.add(ofFloat);
            }
        }
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(arrayList);
        this.U = animatorSet3;
        animatorSet3.addListener(new a(this, i10));
        this.U.start();
    }

    public final void D() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.U != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        View z5 = z();
        FloatingActionButton floatingActionButton = z5 instanceof FloatingActionButton ? (FloatingActionButton) z5 : null;
        if (floatingActionButton != null && floatingActionButton.i()) {
            G(actionMenuView, this.V, this.f10238f0, false);
        } else {
            G(actionMenuView, 0, false, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E() {
        /*
            r4 = this;
            com.google.android.material.bottomappbar.h r0 = r4.getTopEdgeTreatment()
            float r1 = r4.getFabTranslationX()
            r0.f10265g = r1
            android.view.View r0 = r4.z()
            eb.h r1 = r4.S
            boolean r2 = r4.f10238f0
            if (r2 == 0) goto L2b
            android.view.View r2 = r4.z()
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 == 0) goto L1f
            com.google.android.material.floatingactionbutton.FloatingActionButton r2 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r2
            goto L20
        L1f:
            r2 = 0
        L20:
            if (r2 == 0) goto L2b
            boolean r2 = r2.i()
            if (r2 == 0) goto L2b
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L2c
        L2b:
            r2 = 0
        L2c:
            r1.m(r2)
            if (r0 == 0) goto L3f
            float r1 = r4.getFabTranslationY()
            r0.setTranslationY(r1)
            float r1 = r4.getFabTranslationX()
            r0.setTranslationX(r1)
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.E():void");
    }

    public final void F(int i3) {
        float f2 = i3;
        if (f2 != getTopEdgeTreatment().e) {
            getTopEdgeTreatment().e = f2;
            this.S.invalidateSelf();
        }
    }

    public final void G(ActionMenuView actionMenuView, int i3, boolean z5, boolean z6) {
        e eVar = new e(this, actionMenuView, i3, z5);
        if (z6) {
            actionMenuView.post(eVar);
        } else {
            eVar.run();
        }
    }

    public ColorStateList getBackgroundTint() {
        return this.S.f12505a.e;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f10264f;
    }

    public int getFabAlignmentMode() {
        return this.V;
    }

    public int getFabAnimationMode() {
        return this.W;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f10263d;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f10262c;
    }

    public boolean getHideOnScroll() {
        return this.f10233a0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        rb.c(this, this.S);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        if (z5) {
            AnimatorSet animatorSet = this.U;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.T;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            E();
        }
        D();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.V = savedState.f10246a;
        this.f10238f0 = savedState.f10247b;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f10246a = this.V;
        savedState.f10247b = this.f10238f0;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        d1.b.h(this.S, colorStateList);
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().u(f2);
            this.S.invalidateSelf();
            E();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        eb.h hVar = this.S;
        hVar.k(f2);
        int g10 = hVar.f12505a.f12501o - hVar.g();
        Behavior behavior = getBehavior();
        behavior.f10226c = g10;
        if (behavior.f10225b == 1) {
            setTranslationY(behavior.f10224a + g10);
        }
    }

    public void setFabAlignmentMode(int i3) {
        int i10 = 1;
        this.f10237e0 = true;
        C(i3, this.f10238f0);
        if (this.V != i3) {
            WeakHashMap weakHashMap = z0.f15748a;
            if (k0.c(this)) {
                AnimatorSet animatorSet = this.T;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                ArrayList arrayList = new ArrayList();
                if (this.W == 1) {
                    View z5 = z();
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(z5 instanceof FloatingActionButton ? (FloatingActionButton) z5 : null, "translationX", B(i3));
                    ofFloat.setDuration(300L);
                    arrayList.add(ofFloat);
                } else {
                    View z6 = z();
                    FloatingActionButton floatingActionButton = z6 instanceof FloatingActionButton ? (FloatingActionButton) z6 : null;
                    if (floatingActionButton != null && !floatingActionButton.h()) {
                        floatingActionButton.hide(new c(this, i3));
                    }
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(arrayList);
                this.T = animatorSet2;
                animatorSet2.addListener(new a(this, i10));
                this.T.start();
            }
        }
        this.V = i3;
    }

    public void setFabAnimationMode(int i3) {
        this.W = i3;
    }

    public void setFabCornerSize(float f2) {
        if (f2 != getTopEdgeTreatment().f10266h) {
            getTopEdgeTreatment().f10266h = f2;
            this.S.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().f10263d = f2;
            this.S.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().f10262c = f2;
            this.S.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z5) {
        this.f10233a0 = z5;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public final View z() {
        if (getParent() instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) getParent();
            List list = (List) ((k) coordinatorLayout.f1888b.f19147b).getOrDefault(this, null);
            ArrayList arrayList = coordinatorLayout.f1890d;
            arrayList.clear();
            if (list != null) {
                arrayList.addAll(list);
            }
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                View view = (View) obj;
                if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                    return view;
                }
            }
        }
        return null;
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomAppBarStyle);
    }

    @Override // x0.b
    public Behavior getBehavior() {
        if (this.f10239g0 == null) {
            this.f10239g0 = new Behavior();
        }
        return this.f10239g0;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public final Rect e;

        /* renamed from: f, reason: collision with root package name */
        public WeakReference f10243f;

        /* renamed from: g, reason: collision with root package name */
        public int f10244g;

        /* renamed from: h, reason: collision with root package name */
        public final f f10245h;

        public Behavior() {
            this.f10245h = new f(this);
            this.e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, x0.c
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i3) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.f10243f = new WeakReference(bottomAppBar);
            int i10 = BottomAppBar.V0;
            View z5 = bottomAppBar.z();
            if (z5 != null) {
                WeakHashMap weakHashMap = z0.f15748a;
                if (!k0.c(z5)) {
                    x0.f fVar = (x0.f) z5.getLayoutParams();
                    fVar.f19719d = 49;
                    this.f10244g = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                    if (z5 instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) z5;
                        floatingActionButton.addOnLayoutChangeListener(this.f10245h);
                        floatingActionButton.c(bottomAppBar.f10242k0);
                        floatingActionButton.d(new a(bottomAppBar, 3));
                        floatingActionButton.e(bottomAppBar.U0);
                    }
                    bottomAppBar.E();
                }
            }
            coordinatorLayout.v(i3, bottomAppBar);
            super.h(coordinatorLayout, bottomAppBar, i3);
            return false;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, x0.c
        public final boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i10) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            return bottomAppBar.getHideOnScroll() && super.p(coordinatorLayout, bottomAppBar, view2, view3, i3, i10);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f10245h = new f(this);
            this.e = new Rect();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BottomAppBar(android.content.Context r19, android.util.AttributeSet r20, int r21) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
