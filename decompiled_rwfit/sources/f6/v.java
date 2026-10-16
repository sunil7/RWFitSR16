package f6;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class v implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13383a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f13384b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f13385c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f13386d;
    public final TitleView e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f13387f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f13388g;

    public v(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, ActionItemView actionItemView3, TitleView titleView, TextView textView, TextView textView2) {
        this.f13383a = linearLayout;
        this.f13384b = actionItemView;
        this.f13385c = actionItemView2;
        this.f13386d = actionItemView3;
        this.e = titleView;
        this.f13387f = textView;
        this.f13388g = textView2;
    }

    @Override // m2.a
    public final View b() {
        return this.f13383a;
    }
}
