package com.google.android.material.timepicker;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.example.test.ui.device.activity.i0;
import com.google.android.material.R$id;

/* loaded from: classes.dex */
public final class c extends l1.c {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f10980d;

    public c(ClockFaceView clockFaceView) {
        this.f10980d = clockFaceView;
    }

    @Override // l1.c
    public final void d(View view, m1.d dVar) {
        View.AccessibilityDelegate accessibilityDelegate = this.f15682a;
        AccessibilityNodeInfo accessibilityNodeInfo = dVar.f15938a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int intValue = ((Integer) view.getTag(R$id.material_value_index)).intValue();
        if (intValue > 0) {
            accessibilityNodeInfo.setTraversalAfter((View) this.f10980d.f10957y.get(intValue - 1));
        }
        dVar.g(i0.o(0, 1, intValue, 1, view.isSelected()));
    }
}
