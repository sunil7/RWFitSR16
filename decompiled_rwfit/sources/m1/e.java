package m1;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.example.test.ui.device.activity.e0;
import java.util.List;

/* loaded from: classes.dex */
public final class e extends AccessibilityNodeProvider {

    /* renamed from: a, reason: collision with root package name */
    public final e0 f15940a;

    public e(e0 e0Var) {
        this.f15940a = e0Var;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final void addExtraDataToAccessibilityNodeInfo(int i3, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        this.f15940a.getClass();
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i3) {
        d A = this.f15940a.A(i3);
        if (A == null) {
            return null;
        }
        return A.f15938a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i3) {
        this.f15940a.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i3) {
        d D = this.f15940a.D(i3);
        if (D == null) {
            return null;
        }
        return D.f15938a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i3, int i10, Bundle bundle) {
        return this.f15940a.G(i3, i10, bundle);
    }
}
