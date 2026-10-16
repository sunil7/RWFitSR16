package l1;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public abstract class d1 {
    public static boolean a(ViewParent viewParent, View view, float f2, float f10, boolean z5) {
        return viewParent.onNestedFling(view, f2, f10, z5);
    }

    public static boolean b(ViewParent viewParent, View view, float f2, float f10) {
        return viewParent.onNestedPreFling(view, f2, f10);
    }

    public static void c(ViewParent viewParent, View view, int i3, int i10, int[] iArr) {
        viewParent.onNestedPreScroll(view, i3, i10, iArr);
    }

    public static void d(ViewParent viewParent, View view, int i3, int i10, int i11, int i12) {
        viewParent.onNestedScroll(view, i3, i10, i11, i12);
    }

    public static void e(ViewParent viewParent, View view, View view2, int i3) {
        viewParent.onNestedScrollAccepted(view, view2, i3);
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i3) {
        return viewParent.onStartNestedScroll(view, view2, i3);
    }

    public static void g(ViewParent viewParent, View view) {
        viewParent.onStopNestedScroll(view);
    }
}
