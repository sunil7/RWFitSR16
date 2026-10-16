package f6;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.ui.testui.TRingToolBarView;
import com.example.test.ui.view.ActionItemView;

/* loaded from: classes.dex */
public final class y1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f13460a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f13461b;

    /* renamed from: c, reason: collision with root package name */
    public final TRingToolBarView f13462c;

    public y1(ConstraintLayout constraintLayout, ActionItemView actionItemView, TRingToolBarView tRingToolBarView) {
        this.f13460a = constraintLayout;
        this.f13461b = actionItemView;
        this.f13462c = tRingToolBarView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13460a;
    }
}
