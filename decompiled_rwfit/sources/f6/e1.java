package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class e1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12819a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f12820b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f12821c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f12822d;
    public final ActionItemView e;

    /* renamed from: f, reason: collision with root package name */
    public final TitleView f12823f;

    public e1(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, ActionItemView actionItemView3, ActionItemView actionItemView4, TitleView titleView) {
        this.f12819a = linearLayout;
        this.f12820b = actionItemView;
        this.f12821c = actionItemView2;
        this.f12822d = actionItemView3;
        this.e = actionItemView4;
        this.f12823f = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12819a;
    }
}
