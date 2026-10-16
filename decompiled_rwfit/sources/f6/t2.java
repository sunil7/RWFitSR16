package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class t2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13342a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f13343b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleView f13344c;

    public t2(LinearLayout linearLayout, ActionItemView actionItemView, TitleView titleView) {
        this.f13342a = linearLayout;
        this.f13343b = actionItemView;
        this.f13344c = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13342a;
    }
}
