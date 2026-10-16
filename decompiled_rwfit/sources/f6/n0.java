package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class n0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13133a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f13134b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f13135c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f13136d;
    public final ActionItemView e;

    /* renamed from: f, reason: collision with root package name */
    public final TitleView f13137f;

    public n0(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, ActionItemView actionItemView3, ActionItemView actionItemView4, TitleView titleView) {
        this.f13133a = linearLayout;
        this.f13134b = actionItemView;
        this.f13135c = actionItemView2;
        this.f13136d = actionItemView3;
        this.e = actionItemView4;
        this.f13137f = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13133a;
    }
}
