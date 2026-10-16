package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import za.a;

/* loaded from: classes.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {

    /* renamed from: v, reason: collision with root package name */
    public final FrameLayout.LayoutParams f10702v;

    public NavigationRailMenuView(Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.f10702v = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
    }

    public static int f(int i3, int i10, int i11) {
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), i10 / Math.max(1, i11)), 0);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    public final NavigationBarItemView d(Context context) {
        return new a(context);
    }

    public final int g(int i3, int i10, int i11, View view) {
        int i12;
        f(i3, i10, i11);
        int f2 = view == null ? f(i3, i10, i11) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt != view) {
                if (childAt.getVisibility() != 8) {
                    childAt.measure(i3, f2);
                    i12 = childAt.getMeasuredHeight();
                } else {
                    i12 = 0;
                }
                i13 += i12;
            }
        }
        return i13;
    }

    public int getMenuGravity() {
        return this.f10702v.gravity;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        int childCount = getChildCount();
        int i13 = i11 - i3;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i14;
                childAt.layout(0, i14, i13, measuredHeight);
                i14 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        int g10;
        int i11;
        int size = View.MeasureSpec.getSize(i10);
        int size2 = getMenu().l().size();
        if (size2 <= 1 || !NavigationBarMenuView.e(getLabelVisibilityMode(), size2)) {
            g10 = g(i3, size, size2, null);
        } else {
            View childAt = getChildAt(getSelectedItemPosition());
            if (childAt != null) {
                int f2 = f(i3, size, size2);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(i3, f2);
                    i11 = childAt.getMeasuredHeight();
                } else {
                    i11 = 0;
                }
                size -= i11;
                size2--;
            } else {
                i11 = 0;
            }
            g10 = g(i3, size, size2, childAt) + i11;
        }
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i3), i3, 0), View.resolveSizeAndState(g10, i10, 0));
    }

    public void setMenuGravity(int i3) {
        FrameLayout.LayoutParams layoutParams = this.f10702v;
        if (layoutParams.gravity != i3) {
            layoutParams.gravity = i3;
            setLayoutParams(layoutParams);
        }
    }
}
