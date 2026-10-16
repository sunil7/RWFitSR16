package com.example.test.ui.main.adapter;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.i1;
import androidx.recyclerview.widget.q1;
import androidx.recyclerview.widget.w1;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class LayoutManagerScaleFirst extends GridLayoutManager {
    public View M;

    public static void u1(View view, float f2, float f10) {
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 1.0f);
        view.setScaleX(f2);
        view.setScaleY(f2);
        view.setAlpha(f2);
        view.setTranslationY(f10);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.i1
    public final int t0(int i3, q1 recycler, w1 w1Var) {
        e.f(recycler, "recycler");
        int t02 = super.t0(i3, recycler, w1Var);
        if (v() > 1) {
            View u10 = u(1);
            View u11 = u(0);
            View view = this.M;
            if (view != null && !view.equals(u11)) {
                View view2 = this.M;
                e.c(view2);
                u1(view2, 1.0f, 0.0f);
            }
            this.M = u11;
            if (u11 != null && u10 != null) {
                float top = (((1 - 0.0f) * u10.getTop()) / i1.B(u10)) + 0.0f;
                u1(u11, top, i1.B(u10) - u10.getTop());
                if (top < 0.0f) {
                    u1(u11, 1.0f, 0.0f);
                    n0(u11, recycler);
                }
            }
        }
        return t02;
    }
}
