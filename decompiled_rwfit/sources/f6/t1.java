package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class t1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13339a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f13340b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleView f13341c;

    public t1(LinearLayout linearLayout, ActionItemView actionItemView, TitleView titleView) {
        this.f13339a = linearLayout;
        this.f13340b = actionItemView;
        this.f13341c = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13339a;
    }
}
