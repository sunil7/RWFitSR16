package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.testui.TRingToolBarView;
import com.example.test.ui.view.ActionItemView;

/* loaded from: classes.dex */
public final class b1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12712a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f12713b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f12714c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f12715d;
    public final TRingToolBarView e;

    public b1(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, ActionItemView actionItemView3, TRingToolBarView tRingToolBarView) {
        this.f12712a = linearLayout;
        this.f12713b = actionItemView;
        this.f12714c = actionItemView2;
        this.f12715d = actionItemView3;
        this.e = tRingToolBarView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12712a;
    }
}
