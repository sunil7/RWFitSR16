package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public final class q2 extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollingTabContainerView f1028a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q2(ScrollingTabContainerView scrollingTabContainerView, Context context) {
        super(context, null, R$attr.actionBarTabStyle);
        this.f1028a = scrollingTabContainerView;
        de.o I = de.o.I(context, null, new int[]{R.attr.background}, R$attr.actionBarTabStyle);
        if (((TypedArray) I.f12378c).hasValue(0)) {
            setBackgroundDrawable(I.w(0));
        }
        I.K();
        setGravity(8388627);
        throw null;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        ScrollingTabContainerView scrollingTabContainerView = this.f1028a;
        if (scrollingTabContainerView.e > 0) {
            int measuredWidth = getMeasuredWidth();
            int i11 = scrollingTabContainerView.e;
            if (measuredWidth > i11) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), i10);
            }
        }
    }

    @Override // android.view.View
    public final void setSelected(boolean z5) {
        boolean z6 = isSelected() != z5;
        super.setSelected(z5);
        if (z6 && z5) {
            sendAccessibilityEvent(4);
        }
    }
}
