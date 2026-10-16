package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class r1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13273a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f13274b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleView f13275c;

    public r1(LinearLayout linearLayout, ActionItemView actionItemView, TitleView titleView) {
        this.f13273a = linearLayout;
        this.f13274b = actionItemView;
        this.f13275c = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13273a;
    }
}
