package f6;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.ui.testui.TRingToolBarView;
import com.example.test.ui.view.ActionItemView;

/* loaded from: classes.dex */
public final class w0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f13415a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f13416b;

    /* renamed from: c, reason: collision with root package name */
    public final TRingToolBarView f13417c;

    public w0(ConstraintLayout constraintLayout, ActionItemView actionItemView, TRingToolBarView tRingToolBarView) {
        this.f13415a = constraintLayout;
        this.f13416b = actionItemView;
        this.f13417c = tRingToolBarView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13415a;
    }
}
