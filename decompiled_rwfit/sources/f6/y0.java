package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class y0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13455a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f13456b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f13457c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f13458d;
    public final ActionItemView e;

    /* renamed from: f, reason: collision with root package name */
    public final TitleView f13459f;

    public y0(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, ActionItemView actionItemView3, ActionItemView actionItemView4, TitleView titleView) {
        this.f13455a = linearLayout;
        this.f13456b = actionItemView;
        this.f13457c = actionItemView2;
        this.f13458d = actionItemView3;
        this.e = actionItemView4;
        this.f13459f = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13455a;
    }
}
