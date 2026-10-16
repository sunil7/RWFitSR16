package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.R$attr;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;

/* loaded from: classes.dex */
public class NavigationRailView extends NavigationBarView {

    /* renamed from: g, reason: collision with root package name */
    public final int f10703g;

    /* renamed from: h, reason: collision with root package name */
    public final View f10704h;

    public NavigationRailView(Context context) {
        this(context, null);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public final NavigationBarMenuView a(Context context) {
        return new NavigationRailMenuView(context);
    }

    public View getHeaderView() {
        return this.f10704h;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        View view = this.f10704h;
        int i13 = 0;
        boolean z6 = (view == null || view.getVisibility() == 8) ? false : true;
        int i14 = this.f10703g;
        if (z6) {
            int bottom = this.f10704h.getBottom() + i14;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i13 = bottom - top;
            }
        } else if ((navigationRailMenuView.f10702v.gravity & 112) == 48) {
            i13 = i14;
        }
        if (i13 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i13, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i13);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i3) != 1073741824 && suggestedMinimumWidth > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), getPaddingRight() + getPaddingLeft() + suggestedMinimumWidth), 1073741824);
        }
        super.onMeasure(i3, i10);
        View view = this.f10704h;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        measureChild(getNavigationRailMenuView(), i3, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f10704h.getMeasuredHeight()) - this.f10703g, Integer.MIN_VALUE));
    }

    public void setMenuGravity(int i3) {
        getNavigationRailMenuView().setMenuGravity(i3);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationRailStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NavigationRailView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.R$style.Widget_MaterialComponents_NavigationRailView
            r7.<init>(r8, r9, r10, r4)
            android.content.res.Resources r8 = r7.getResources()
            int r0 = com.google.android.material.R$dimen.mtrl_navigation_rail_margin
            int r8 = r8.getDimensionPixelSize(r0)
            r7.f10703g = r8
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R$styleable.NavigationRailView
            r6 = 0
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            de.o r9 = com.google.android.material.internal.w.e(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R$styleable.NavigationRailView_headerLayout
            java.lang.Object r0 = r9.f12378c
            android.content.res.TypedArray r0 = (android.content.res.TypedArray) r0
            int r10 = r0.getResourceId(r10, r6)
            r1 = 49
            if (r10 == 0) goto L53
            android.content.Context r2 = r7.getContext()
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            android.view.View r10 = r2.inflate(r10, r7, r6)
            android.view.View r2 = r7.f10704h
            if (r2 == 0) goto L44
            r7.removeView(r2)
            r2 = 0
            r7.f10704h = r2
        L44:
            r7.f10704h = r10
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = -2
            r2.<init>(r3, r3)
            r2.gravity = r1
            r2.topMargin = r8
            r7.addView(r10, r6, r2)
        L53:
            int r8 = com.google.android.material.R$styleable.NavigationRailView_menuGravity
            int r8 = r0.getInt(r8, r1)
            r7.setMenuGravity(r8)
            r9.K()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigationrail.NavigationRailView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
