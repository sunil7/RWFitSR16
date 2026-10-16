package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class x1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13444a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f13445b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f13446c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f13447d;
    public final TitleView e;

    public x1(LinearLayout linearLayout, LinearLayout linearLayout2, ActionItemView actionItemView, ActionItemView actionItemView2, TitleView titleView) {
        this.f13444a = linearLayout;
        this.f13445b = linearLayout2;
        this.f13446c = actionItemView;
        this.f13447d = actionItemView2;
        this.e = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13444a;
    }
}
