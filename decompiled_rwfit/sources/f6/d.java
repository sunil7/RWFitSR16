package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class d implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12771a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f12772b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f12773c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f12774d;

    public d(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, TitleView titleView) {
        this.f12771a = linearLayout;
        this.f12772b = actionItemView;
        this.f12773c = actionItemView2;
        this.f12774d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12771a;
    }
}
