package f6;

import android.view.View;
import android.widget.LinearLayout;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class s1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13295a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f13296b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f13297c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f13298d;
    public final TitleView e;

    public s1(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, ActionItemView actionItemView3, TitleView titleView) {
        this.f13295a = linearLayout;
        this.f13296b = actionItemView;
        this.f13297c = actionItemView2;
        this.f13298d = actionItemView3;
        this.e = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13295a;
    }
}
