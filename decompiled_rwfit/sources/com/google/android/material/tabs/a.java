package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public class a {
    public static RectF a(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.B || !(view instanceof TabLayout.TabView)) {
            return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        TabLayout.TabView tabView = (TabLayout.TabView) view;
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int b3 = (int) gb.b(tabView.getContext(), 24);
        if (contentWidth < b3) {
            contentWidth = b3;
        }
        int right = (tabView.getRight() + tabView.getLeft()) / 2;
        int bottom = (tabView.getBottom() + tabView.getTop()) / 2;
        int i3 = contentWidth / 2;
        return new RectF(right - i3, bottom - (contentHeight / 2), i3 + right, (right / 2) + bottom);
    }

    public void b(TabLayout tabLayout, View view, View view2, float f2, Drawable drawable) {
        RectF a3 = a(tabLayout, view);
        RectF a10 = a(tabLayout, view2);
        int i3 = (int) a3.left;
        int i10 = (int) a10.left;
        LinearInterpolator linearInterpolator = ja.a.f15383a;
        drawable.setBounds(Math.round((i10 - i3) * f2) + i3, drawable.getBounds().top, Math.round(f2 * (((int) a10.right) - r4)) + ((int) a3.right), drawable.getBounds().bottom);
    }
}
