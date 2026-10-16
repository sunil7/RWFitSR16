package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class s0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13290a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f13291b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f13292c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f13293d;
    public final ActionItemView e;

    /* renamed from: f, reason: collision with root package name */
    public final TitleView f13294f;

    public s0(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, ActionItemView actionItemView3, ActionItemView actionItemView4, TitleView titleView) {
        this.f13290a = linearLayout;
        this.f13291b = actionItemView;
        this.f13292c = actionItemView2;
        this.f13293d = actionItemView3;
        this.e = actionItemView4;
        this.f13294f = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13290a;
    }
}
