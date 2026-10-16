package m1;

import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public abstract class a {
    public static int a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    public static void b(AccessibilityEvent accessibilityEvent, int i3) {
        accessibilityEvent.setContentChangeTypes(i3);
    }
}
