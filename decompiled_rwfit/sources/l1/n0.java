package l1;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.R$id;

/* loaded from: classes.dex */
public abstract class n0 {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static x1 b(View view, x1 x1Var, Rect rect) {
        WindowInsets g10 = x1Var.g();
        if (g10 != null) {
            return x1.h(view.computeSystemWindowInsets(g10, rect), view);
        }
        rect.setEmpty();
        return x1Var;
    }

    public static boolean c(View view, float f2, float f10, boolean z5) {
        return view.dispatchNestedFling(f2, f10, z5);
    }

    public static boolean d(View view, float f2, float f10) {
        return view.dispatchNestedPreFling(f2, f10);
    }

    public static boolean e(View view, int i3, int i10, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i3, i10, iArr, iArr2);
    }

    public static boolean f(View view, int i3, int i10, int i11, int i12, int[] iArr) {
        return view.dispatchNestedScroll(i3, i10, i11, i12, iArr);
    }

    public static ColorStateList g(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode h(View view) {
        return view.getBackgroundTintMode();
    }

    public static float i(View view) {
        return view.getElevation();
    }

    public static x1 j(View view) {
        if (!k1.f15704d || !view.isAttachedToWindow()) {
            return null;
        }
        try {
            Object obj = k1.f15701a.get(view.getRootView());
            if (obj == null) {
                return null;
            }
            Rect rect = (Rect) k1.f15702b.get(obj);
            Rect rect2 = (Rect) k1.f15703c.get(obj);
            if (rect == null || rect2 == null) {
                return null;
            }
            int i3 = Build.VERSION.SDK_INT;
            o1 n1Var = i3 >= 30 ? new n1() : i3 >= 29 ? new m1() : new l1();
            n1Var.c(c1.c.a(rect.left, rect.top, rect.right, rect.bottom));
            n1Var.d(c1.c.a(rect2.left, rect2.top, rect2.right, rect2.bottom));
            x1 b3 = n1Var.b();
            b3.f15738a.p(b3);
            b3.f15738a.d(view.getRootView());
            return b3;
        } catch (IllegalAccessException e) {
            Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            return null;
        }
    }

    public static String k(View view) {
        return view.getTransitionName();
    }

    public static float l(View view) {
        return view.getTranslationZ();
    }

    public static float m(View view) {
        return view.getZ();
    }

    public static boolean n(View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean o(View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean p(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void q(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void r(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void s(View view, float f2) {
        view.setElevation(f2);
    }

    public static void t(View view, boolean z5) {
        view.setNestedScrollingEnabled(z5);
    }

    public static void u(View view, w wVar) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R$id.tag_on_apply_window_listener, wVar);
        }
        if (wVar == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new m0(view, wVar));
        }
    }

    public static void v(View view, String str) {
        view.setTransitionName(str);
    }

    public static void w(View view, float f2) {
        view.setTranslationZ(f2);
    }

    public static void x(View view, float f2) {
        view.setZ(f2);
    }

    public static boolean y(View view, int i3) {
        return view.startNestedScroll(i3);
    }

    public static void z(View view) {
        view.stopNestedScroll();
    }
}
