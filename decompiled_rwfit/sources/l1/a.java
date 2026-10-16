package l1;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a extends View.AccessibilityDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final c f15676a;

    public a(c cVar) {
        this.f15676a = cVar;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f15676a.a(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        com.example.test.ui.device.activity.e0 b3 = this.f15676a.b(view);
        if (b3 != null) {
            return (AccessibilityNodeProvider) b3.f7855b;
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f15676a.c(view, accessibilityEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        Object tag;
        Object tag2;
        Object tag3;
        m1.d dVar = new m1.d(accessibilityNodeInfo);
        WeakHashMap weakHashMap = z0.f15748a;
        int i3 = R$id.tag_screen_reader_focusable;
        Object obj = null;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = Boolean.valueOf(s0.d(view));
        } else {
            tag = view.getTag(i3);
            if (!Boolean.class.isInstance(tag)) {
                tag = null;
            }
        }
        Boolean bool = (Boolean) tag;
        boolean z5 = (bool == null || !bool.booleanValue()) ? 0 : 1;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            accessibilityNodeInfo.setScreenReaderFocusable(z5);
        } else {
            Bundle extras = accessibilityNodeInfo.getExtras();
            if (extras != null) {
                extras.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", z5 | (extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (-2)));
            }
        }
        int i11 = R$id.tag_accessibility_heading;
        if (Build.VERSION.SDK_INT >= 28) {
            tag2 = Boolean.valueOf(s0.c(view));
        } else {
            tag2 = view.getTag(i11);
            if (!Boolean.class.isInstance(tag2)) {
                tag2 = null;
            }
        }
        Boolean bool2 = (Boolean) tag2;
        boolean z6 = bool2 != null && bool2.booleanValue();
        if (i10 >= 28) {
            accessibilityNodeInfo.setHeading(z6);
        } else {
            Bundle extras2 = accessibilityNodeInfo.getExtras();
            if (extras2 != null) {
                extras2.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", (z6 ? 2 : 0) | (extras2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (-3)));
            }
        }
        int i12 = R$id.tag_accessibility_pane_title;
        if (i10 >= 28) {
            tag3 = s0.b(view);
        } else {
            tag3 = view.getTag(i12);
            if (!CharSequence.class.isInstance(tag3)) {
                tag3 = null;
            }
        }
        CharSequence charSequence = (CharSequence) tag3;
        if (i10 >= 28) {
            accessibilityNodeInfo.setPaneTitle(charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
        int i13 = R$id.tag_state_description;
        if (Build.VERSION.SDK_INT >= 30) {
            obj = u0.a(view);
        } else {
            Object tag4 = view.getTag(i13);
            if (CharSequence.class.isInstance(tag4)) {
                obj = tag4;
            }
        }
        CharSequence charSequence2 = (CharSequence) obj;
        if (i10 >= 30) {
            accessibilityNodeInfo.setStateDescription(charSequence2);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence2);
        }
        this.f15676a.d(view, dVar);
        accessibilityNodeInfo.getText();
        List list = (List) view.getTag(R$id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        for (int i14 = 0; i14 < list.size(); i14++) {
            dVar.b((m1.c) list.get(i14));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f15676a.e(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f15676a.f(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
        return this.f15676a.g(view, i3, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEvent(View view, int i3) {
        this.f15676a.h(view, i3);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f15676a.i(view, accessibilityEvent);
    }
}
