package l1;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class o0 {
    public static x1 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        x1 h4 = x1.h(rootWindowInsets, null);
        v1 v1Var = h4.f15738a;
        v1Var.p(h4);
        v1Var.d(view.getRootView());
        return h4;
    }

    public static int b(View view) {
        return view.getScrollIndicators();
    }

    public static void c(View view, int i3) {
        view.setScrollIndicators(i3);
    }

    public static void d(View view, int i3, int i10) {
        view.setScrollIndicators(i3, i10);
    }
}
