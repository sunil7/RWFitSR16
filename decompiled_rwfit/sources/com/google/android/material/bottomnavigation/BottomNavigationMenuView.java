package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.R$dimen;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import h.k;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;

/* loaded from: classes.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    public boolean A;
    public final int[] B;

    /* renamed from: v, reason: collision with root package name */
    public final int f10267v;

    /* renamed from: w, reason: collision with root package name */
    public final int f10268w;

    /* renamed from: x, reason: collision with root package name */
    public final int f10269x;

    /* renamed from: y, reason: collision with root package name */
    public final int f10270y;

    /* renamed from: z, reason: collision with root package name */
    public final int f10271z;

    public BottomNavigationMenuView(Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.f10267v = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_max_width);
        this.f10268w = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_min_width);
        this.f10269x = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_max_width);
        this.f10270y = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_min_width);
        this.f10271z = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_height);
        this.B = new int[5];
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    public final NavigationBarItemView d(Context context) {
        return new BottomNavigationItemView(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        int childCount = getChildCount();
        int i13 = i11 - i3;
        int i14 = i12 - i10;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                WeakHashMap weakHashMap = z0.f15748a;
                if (i0.d(this) == 1) {
                    int i17 = i13 - i15;
                    childAt.layout(i17 - childAt.getMeasuredWidth(), 0, i17, i14);
                } else {
                    childAt.layout(i15, 0, childAt.getMeasuredWidth() + i15, i14);
                }
                i15 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        k menu = getMenu();
        int size = View.MeasureSpec.getSize(i3);
        int size2 = menu.l().size();
        int childCount = getChildCount();
        int i11 = this.f10271z;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        boolean e = NavigationBarMenuView.e(getLabelVisibilityMode(), size2);
        int[] iArr = this.B;
        int i12 = this.f10269x;
        if (e && this.A) {
            View childAt = getChildAt(getSelectedItemPosition());
            int visibility = childAt.getVisibility();
            int i13 = this.f10270y;
            if (visibility != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE), makeMeasureSpec);
                i13 = Math.max(i13, childAt.getMeasuredWidth());
            }
            int i14 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.f10268w * i14), Math.min(i13, i12));
            int i15 = size - min;
            int min2 = Math.min(i15 / (i14 != 0 ? i14 : 1), this.f10267v);
            int i16 = i15 - (i14 * min2);
            int i17 = 0;
            while (i17 < childCount) {
                if (getChildAt(i17).getVisibility() != 8) {
                    int i18 = i17 == getSelectedItemPosition() ? min : min2;
                    iArr[i17] = i18;
                    if (i16 > 0) {
                        iArr[i17] = i18 + 1;
                        i16--;
                    }
                } else {
                    iArr[i17] = 0;
                }
                i17++;
            }
        } else {
            int min3 = Math.min(size / (size2 != 0 ? size2 : 1), i12);
            int i19 = size - (size2 * min3);
            for (int i20 = 0; i20 < childCount; i20++) {
                if (getChildAt(i20).getVisibility() != 8) {
                    iArr[i20] = min3;
                    if (i19 > 0) {
                        iArr[i20] = min3 + 1;
                        i19--;
                    }
                } else {
                    iArr[i20] = 0;
                }
            }
        }
        int i21 = 0;
        for (int i22 = 0; i22 < childCount; i22++) {
            View childAt2 = getChildAt(i22);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(iArr[i22], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i21 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i21, View.MeasureSpec.makeMeasureSpec(i21, 1073741824), 0), View.resolveSizeAndState(i11, makeMeasureSpec, 0));
    }

    public void setItemHorizontalTranslationEnabled(boolean z5) {
        this.A = z5;
    }
}
