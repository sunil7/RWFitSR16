package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class v2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13404a;

    /* renamed from: b, reason: collision with root package name */
    public final TitleView f13405b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f13406c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f13407d;

    public v2(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, TitleView titleView) {
        this.f13404a = linearLayout;
        this.f13405b = titleView;
        this.f13406c = actionItemView;
        this.f13407d = actionItemView2;
    }

    @Override // m2.a
    public final View b() {
        return this.f13404a;
    }
}
