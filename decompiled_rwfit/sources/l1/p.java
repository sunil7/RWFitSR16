package l1;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class p {
    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getLayoutDirection();
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    public static int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    public static boolean d(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.isMarginRelative();
    }

    public static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.resolveLayoutDirection(i3);
    }

    public static void f(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.setLayoutDirection(i3);
    }

    public static void g(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.setMarginEnd(i3);
    }

    public static void h(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.setMarginStart(i3);
    }
}
