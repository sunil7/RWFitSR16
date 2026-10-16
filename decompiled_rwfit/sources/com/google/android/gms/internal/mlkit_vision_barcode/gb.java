package com.google.android.gms.internal.mlkit_vision_barcode;

import android.R;
import android.content.Context;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class gb {
    public static void a(View view, com.google.android.material.internal.z zVar) {
        WeakHashMap weakHashMap = l1.z0.f15748a;
        int f2 = l1.i0.f(view);
        int paddingTop = view.getPaddingTop();
        int e = l1.i0.e(view);
        int paddingBottom = view.getPaddingBottom();
        com.google.android.material.internal.a0 a0Var = new com.google.android.material.internal.a0();
        a0Var.f10554a = f2;
        a0Var.f10555b = paddingTop;
        a0Var.f10556c = e;
        a0Var.f10557d = paddingBottom;
        l1.n0.u(view, new com.example.test.utils.y(zVar, 15, a0Var, false));
        if (l1.k0.b(view)) {
            l1.l0.c(view);
        } else {
            view.addOnAttachStateChangeListener(new com.google.android.material.internal.y());
        }
    }

    public static float b(Context context, int i3) {
        return TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics());
    }

    public static ViewGroup c(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static boolean d(View view) {
        WeakHashMap weakHashMap = l1.z0.f15748a;
        return l1.i0.d(view) == 1;
    }

    public static PorterDuff.Mode e(int i3, PorterDuff.Mode mode) {
        if (i3 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i3 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i3 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i3) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
