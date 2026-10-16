package m1;

import android.view.accessibility.AccessibilityRecord;

/* loaded from: classes.dex */
public abstract class f {
    public static int a(AccessibilityRecord accessibilityRecord) {
        return accessibilityRecord.getMaxScrollX();
    }

    public static int b(AccessibilityRecord accessibilityRecord) {
        return accessibilityRecord.getMaxScrollY();
    }

    public static void c(AccessibilityRecord accessibilityRecord, int i3) {
        accessibilityRecord.setMaxScrollX(i3);
    }

    public static void d(AccessibilityRecord accessibilityRecord, int i3) {
        accessibilityRecord.setMaxScrollY(i3);
    }
}
