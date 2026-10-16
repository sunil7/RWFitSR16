package f6;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.ui.testui.TRingToolBarView;
import com.example.test.ui.view.ActionItemView;

/* loaded from: classes.dex */
public final class n2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f13141a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f13142b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f13143c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f13144d;
    public final TRingToolBarView e;

    public n2(ConstraintLayout constraintLayout, ActionItemView actionItemView, ActionItemView actionItemView2, ActionItemView actionItemView3, TRingToolBarView tRingToolBarView) {
        this.f13141a = constraintLayout;
        this.f13142b = actionItemView;
        this.f13143c = actionItemView2;
        this.f13144d = actionItemView3;
        this.e = tRingToolBarView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13141a;
    }
}
