package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class h1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12948a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f12949b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f12950c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f12951d;

    public h1(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, TitleView titleView) {
        this.f12948a = linearLayout;
        this.f12949b = actionItemView;
        this.f12950c = actionItemView2;
        this.f12951d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12948a;
    }
}
