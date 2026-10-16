package l1;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public abstract class k0 {
    public static int a(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static boolean b(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean c(View view) {
        return view.isLaidOut();
    }

    public static boolean d(View view) {
        return view.isLayoutDirectionResolved();
    }

    public static void e(ViewParent viewParent, View view, View view2, int i3) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i3);
    }

    public static void f(View view, int i3) {
        view.setAccessibilityLiveRegion(i3);
    }

    public static void g(AccessibilityEvent accessibilityEvent, int i3) {
        accessibilityEvent.setContentChangeTypes(i3);
    }
}
