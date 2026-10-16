package l1;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;

/* loaded from: classes.dex */
public abstract class b {
    public static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
        return accessibilityDelegate.getAccessibilityNodeProvider(view);
    }

    public static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i3, Bundle bundle) {
        return accessibilityDelegate.performAccessibilityAction(view, i3, bundle);
    }
}
