package com.google.android.material.behavior;

import ab.q;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import ja.a;
import x0.c;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends c {

    /* renamed from: a, reason: collision with root package name */
    public int f10224a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f10225b = 2;

    /* renamed from: c, reason: collision with root package name */
    public int f10226c = 0;

    /* renamed from: d, reason: collision with root package name */
    public ViewPropertyAnimator f10227d;

    public HideBottomViewOnScrollBehavior() {
    }

    @Override // x0.c
    public boolean h(CoordinatorLayout coordinatorLayout, View view, int i3) {
        this.f10224a = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        return false;
    }

    @Override // x0.c
    public final void l(CoordinatorLayout coordinatorLayout, View view, int i3, int i10, int i11, int[] iArr) {
        if (i3 > 0) {
            if (this.f10225b == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this.f10227d;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.f10225b = 1;
            this.f10227d = view.animate().translationY(this.f10224a + this.f10226c).setInterpolator(a.f15385c).setDuration(175L).setListener(new q(this, 9));
            return;
        }
        if (i3 >= 0 || this.f10225b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator2 = this.f10227d;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
            view.clearAnimation();
        }
        this.f10225b = 2;
        this.f10227d = view.animate().translationY(0).setInterpolator(a.f15386d).setDuration(225L).setListener(new q(this, 9));
    }

    @Override // x0.c
    public boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i10) {
        return i3 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
